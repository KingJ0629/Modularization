package com.uama.happinesscommunity.net;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.uama.happinesscommunity.CommonApplication;
import com.uama.happinesscommunity.bean.BaseEntity;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by gujiajia on 2016/6/2.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class Retrofit2Interceptor implements Interceptor {

    private Context context;
    private Toast toast;
    private Gson gson;

    public Retrofit2Interceptor() {
        this(null);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Retrofit2Interceptor(Context context) {
        this.context = context;
        gson = new Gson();
    }
    
    public static final String VERSION = "2";
    public static final String COMPANY_CODE = "sq";
    public static final String MOBILE_TYPE = "2";
    public static final String APP_TYPE = "2";
    
    //获取手机系统版本号
    public static String getOSVersion() {
        return android.os.Build.VERSION.RELEASE;
    }
    
    //获取APP版本号
    public static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Obtain app version error!";
        }
    }
    
    //获取手机设备号
    public static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            return "Obtain serverId error!";
        }
    }
    
    //获取设备名称
    public static String getMobileName() {
        return android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
    }
    
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request chainRequest = chain.request();
//        long t1 = System.nanoTime();
        Request.Builder builder = chainRequest.newBuilder();
        builder.addHeader("companyCode", COMPANY_CODE);//必传
        builder.addHeader("mobileType", MOBILE_TYPE);//必传
        builder.addHeader("apptype", APP_TYPE);
        builder.addHeader("mobileVersion", getOSVersion());
        builder.addHeader("appVersion", getAppVersion(CommonApplication.context));
        builder.addHeader("mobileNo", getAndroidId(CommonApplication.context));
        builder.addHeader("mobileName", getMobileName());
        builder.addHeader("time", Long.toString(System.currentTimeMillis() / 1000));
//        if(!TextUtils.isEmpty(SePref.getToken(CommonApplication.context))){
//            builder.addHeader("token",SePref.getToken(CommonApplication.context));
//        }
        Request request = builder.build();
        Response response = chain.proceed(request);
//        long t2 = System.nanoTime();
        try {
            ResponseBody responseBody = response.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            String requestStr = buffer.clone().readString(Charset.forName("UTF-8"));
            if (!TextUtils.isEmpty(requestStr)) {
                BaseEntity baseBean = gson.fromJson(requestStr, BaseEntity.class);
                // 这里可以统一对返回值数据作判断
                Message msg = new Message();
                msg.what = Integer.parseInt(baseBean.getStatus());
                myHandler.sendMessage(msg);
//                System.out.println("HTTP耗:时"+ (t2 - t1) / 1e6d+"ms");
//                System.out.println("http:"+requestStr);
            } else {
                Message msg = new Message();
                msg.what = -1;
                myHandler.sendMessage(msg);
            }
        } catch (Exception e) {
            Log.i("Http Exception:", e.toString());
        }
        return response;
    }

    Handler myHandler =  new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -1:
//                    showTextToast("数据获取失败，请重试");
                    break;
                case 100:
//                    showTextToast("成功了");
                    break;
                case 101:
//                    showTextToast("失败了");
                    break;
                case 102:
                    // 如果code为102并且token不为空，则为token过期
                    // 否则不用提示
//                    if (!TextUtils.isEmpty(SePref.getToken(CommonApplication.context))) {
//                        onTokenExpired();
//                    }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    // token过期
//    private void onTokenExpired() {
//        Utils.clearUserInfo(SeApp.context);
//        SeApp.context.sendBroadcast(new Intent(Constants.ACTION_TOKEN_EXPIRED));
//    }

    private void showTextToast(String msg) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}

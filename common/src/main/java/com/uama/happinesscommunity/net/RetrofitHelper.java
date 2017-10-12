package com.uama.happinesscommunity.net;

import android.content.Context;

import com.uama.happinesscommunity.bean.BaseEntity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by liwei on 2016/10/27 15:10
 * Email: liwei@uama.com.cn
 * Description: retrofit访问接口帮助类
 */

public class RetrofitHelper {

    private ArrayList<Call> calls = new ArrayList<>();

    public static RetrofitHelper get(Context context) {
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.setContext(context);
        return retrofitHelper;
    }

    private RetrofitHelper() {}

    private Context context;

    private void setContext(Context context) {
        this.context = context;
    }

    public <T extends BaseEntity> void  enqueue(Call<T> call, final RetrofitCallback<T> callback) {
        calls.add(call);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (call.isCanceled()) return;
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body.getStatus().equals(ApiClient.SUCCESS)) {
                        if (callback != null) {
                            callback.onSuccess(call, body);
                        }
                    } else if (callback != null && callback instanceof RetrofitPayCallback && body.getStatus().equals("106")) {
                        ((RetrofitPayCallback) callback).onPayError(call, body.getStatus(), body.getMsg());
                    } else {
                        if (callback != null) {
                            callback.onError(call, body.getMsg());
                        }
                    }
                } else {
                    if (callback != null) {
                        callback.onError(call, "net_error");
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                t.printStackTrace();
                if (call.isCanceled()) return;
                if (callback != null) {
                    callback.onError(call, "net_error");
                }
            }
        });
    }

    /**
     * 取消所有请求
     */
    public void cancelCalls() {
        for (Call call : calls) {
            if (call != null && !call.isCanceled()) {
                call.cancel();
            }
        }
    }
}

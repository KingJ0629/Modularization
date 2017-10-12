package com.uama.happinesscommunity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.uama.happinesscommunity.bean.BaseEntity;
import com.uama.happinesscommunity.net.RetrofitCallback;
import com.uama.happinesscommunity.net.RetrofitHelper;

import retrofit2.Call;

public class BaseFragment extends Fragment implements IBaseActFrag {

    public Context mContext;
    public final static int PAGE_SIZE = 20;
    protected Call httpCall;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != httpCall && !httpCall.isCanceled()) {
            httpCall.cancel();
        }
    
        retrofitHelper.cancelCalls();
    }
    
    private RetrofitHelper retrofitHelper;
    
    /**
     * 使用RetrofitHelper进行网络请求
     */
    public <T extends BaseEntity> void enqueue(Call<T> call, RetrofitCallback<T> callback) {
        retrofitHelper.enqueue(call, callback);
    }
    

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    
        retrofitHelper = RetrofitHelper.get(mContext);
    }
    
    // //////////////////////////////////////////////////跳转相关/////////////////////////////////////////////////////////////
    @Override
    public void qStartActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void qStartActivity(Class<? extends Activity> cls) {
        qStartActivity(cls, null);
    }

    @Override
    public void qStartActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(mActivity, cls);
        startActivity(intent);
    }

    @Override
    public void qStartActivityForResult(Class<? extends Activity> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(mActivity, cls);
        startActivityForResult(intent, requestCode);
    }

    /* 带结果返回上一个activity， 配合qStartActivityForResult使用 */
    @Override
    public void qBackForResult(int resultCode, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        mActivity.setResult(resultCode, intent);
        mActivity.finish();
    }

    @Override
    public void qBackToActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(mActivity, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public Handler getHandler() {
        return null;
    }

    public Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }
}

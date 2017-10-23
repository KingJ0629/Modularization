package com.uama.happinesscommunity.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.uama.happinesscommunity.di.AppComponent;

public class BaseFragment extends Fragment {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public Context getContext() {
        return mContext;
    }
    
    protected AppComponent getAppComponent() {
        return CommonApplication.getAppComponent();
    }
}

package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uama.happinesscommunity.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Jin
 */
public class LifeFragment extends BaseFragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.life_layout, container, false);
            ButterKnife.bind(this, rootView);
        }
        return rootView;
    }
}
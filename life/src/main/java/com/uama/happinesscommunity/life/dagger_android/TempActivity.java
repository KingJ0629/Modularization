package com.uama.happinesscommunity.life.dagger_android;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.uama.happinesscommunity.common.utils.L;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Jin on 2017/11/1.
 * Description
 */
public class TempActivity extends DaggerAppCompatActivity {

	@Inject
	TempBean mTempBean;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		L.i("TempBean : " + mTempBean.getText());
	}
}

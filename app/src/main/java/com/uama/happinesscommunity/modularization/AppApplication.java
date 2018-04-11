package com.uama.happinesscommunity.modularization;

import com.uama.happinesscommunity.base.CommonApplication;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Jin on 2017/10/26.
 * Description
 */
public class AppApplication extends CommonApplication {
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		return DaggerAppComponent.builder().application(this).build();
	}
}

package com.uama.happinesscommunity.modularization;

import com.uama.happinesscommunity.base.CommonApplication;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Jin on 2017/10/26.
 * Description
 */
public class AppApplication extends CommonApplication {
	
	private static AppComponent mAppComponent;
	private static AppApplication instance;
	
	@Override
	public void onCreate() {
		instance = this;
		super.onCreate();
	}
	
	public static synchronized AppApplication getInstance() {
		return instance;
	}
	
	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		getAppComponent().inject(this);
		return mAppComponent;
	}
	
	/**
	 * 实现单例注入元素
	 */
	public static AppComponent getAppComponent() {
		if (mAppComponent == null) {
			mAppComponent = DaggerAppComponent.builder().application(instance).build();
		}
		return mAppComponent;
	}
}

package com.uama.happinesscommunity.base;

import android.app.Application;
import android.content.Context;

import com.uama.happinesscommunity.di.AppComponent;
import com.uama.happinesscommunity.di.AppModule;
import com.uama.happinesscommunity.di.DaggerAppComponent;

/**
 * Created by Jin on 2017/10/12.
 * Description
 */
public class CommonApplication extends Application {
	
	public static Context context;
	
	private static AppComponent mAppComponent;
	private static CommonApplication instance;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
		context = getApplicationContext();
	}
	
	public static synchronized CommonApplication getInstance() {
		return instance;
	}
	
	/**
	 * 实现单例注入元素
	 */
	public static AppComponent getAppComponent() {
		if (mAppComponent == null) {
			mAppComponent = DaggerAppComponent.builder()
					.appModule(new AppModule(instance))
					.build();
		}
		return mAppComponent;
	}
}

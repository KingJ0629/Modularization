package com.uama.happinesscommunity.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
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
		
		if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
			ARouter.openLog();     // 打印日志
			ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
		}
		ARouter.init(this); // 尽可能早，推荐在Application中初始化
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

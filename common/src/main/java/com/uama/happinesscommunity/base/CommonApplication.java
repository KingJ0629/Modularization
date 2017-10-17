package com.uama.happinesscommunity.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Jin on 2017/10/12.
 * Description
 */
public class CommonApplication extends Application {
	
	public static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		context = getApplicationContext();
		
		if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
			ARouter.openLog();     // 打印日志
			ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
		}
		ARouter.init(this); // 尽可能早，推荐在Application中初始化
	}
}

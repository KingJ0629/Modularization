package com.uama.happinesscommunity.di;

import com.uama.happinesscommunity.base.CommonApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jin on 2017/10/18.
 * Description 提供依赖
 */
@Module
public class AppModule {
	
	private final CommonApplication application;
	
	public AppModule(CommonApplication application) {
		this.application = application;
	}
	
	@Provides
	@Singleton
	CommonApplication provideApplicationContext() {
		return application;
	}
}

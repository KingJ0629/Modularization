package com.uama.happinesscommunity.di;

import com.uama.happinesscommunity.base.CommonApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jin on 2017/10/23.
 * Description 全局单例中间件
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
	
	CommonApplication provideApplication();  // 提供App的Context
}

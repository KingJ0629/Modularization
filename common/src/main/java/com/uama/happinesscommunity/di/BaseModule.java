package com.uama.happinesscommunity.di;

import com.uama.happinesscommunity.Test;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jin on 2017/11/2.
 * Description
 */
@Module
public class BaseModule {
	
	@Singleton
	@Provides
	Test provideTestBean() {
		return new Test("test name");
	}
}

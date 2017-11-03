package com.uama.happinesscommunity.di;

import com.uama.happinesscommunity.TestActivity;
import com.uama.happinesscommunity.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Jin on 2017/11/2.
 * Description
 */
@Module
public abstract class BaseBindingModule {
	
	@ActivityScope
	@ContributesAndroidInjector
	abstract TestActivity TestActivityInjector();
}

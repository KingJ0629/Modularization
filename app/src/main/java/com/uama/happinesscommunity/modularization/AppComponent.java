package com.uama.happinesscommunity.modularization;

import android.app.Application;

import com.uama.happinesscommunity.di.BaseBindingModule;
import com.uama.happinesscommunity.di.BaseModule;
import com.uama.happinesscommunity.life.dagger_android.ActivityTempBindingModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Jin on 2017/11/2.
 * Description
 */
@Singleton
@Component(modules = {
		ApplicationModule.class,
		AndroidSupportInjectionModule.class,
		BaseModule.class, //提供全局单例的依赖
		BaseBindingModule.class,
		ActivityBindingModule.class,
		ActivityTempBindingModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
	
	void inject(AppApplication application);
	
	@Override
	void inject(DaggerApplication instance);
	
	// Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
	// never having to instantiate any modules or say which module we are passing the application to.
	// Application will just be provided into our app graph now.
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		AppComponent.Builder application(Application application);
		
		AppComponent build();
	}
}

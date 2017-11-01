package com.uama.happinesscommunity.di;

import android.app.Application;

import com.uama.happinesscommunity.base.CommonApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Jin on 2017/10/23.
 * Description 全局单例中间件
 */
@Singleton
@Component(modules = {
		ApplicationModule.class,
		ActivityBindingModule.class,
		AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
	
	void inject(CommonApplication application);
	
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

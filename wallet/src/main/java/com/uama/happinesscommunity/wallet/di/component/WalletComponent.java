package com.uama.happinesscommunity.wallet.di.component;

import android.content.Context;

import com.uama.happinesscommunity.di.AppComponent;
import com.uama.happinesscommunity.wallet.WalletActivity;
import com.uama.happinesscommunity.wallet.di.module.WalletModule;
import com.uama.happinesscommunity.wallet.di.scope.WalletActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Jin on 2017/10/18.
 * Description 钱包依赖注入中间件(连接提供依赖和消费依赖对象的组件)
 */
@WalletActivityScope
@Component(dependencies = AppComponent.class, modules = WalletModule.class)
public interface WalletComponent {
	
	void inject(WalletActivity activity);
	
	@Component.Builder
	interface Builder {
		
		WalletComponent.Builder appComponent(AppComponent appComponent);
		WalletComponent.Builder walletModule(WalletModule walletModule);
		
		@BindsInstance
		WalletComponent.Builder provideContext(Context mContext);
		
		WalletComponent build();
	}
	
}

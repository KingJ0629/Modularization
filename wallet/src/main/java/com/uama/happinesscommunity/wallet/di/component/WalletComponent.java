package com.uama.happinesscommunity.wallet.di.component;

import com.uama.happinesscommunity.wallet.WalletActivity;
import com.uama.happinesscommunity.wallet.di.module.WalletModule;

import dagger.Component;

/**
 * Created by Jin on 2017/10/18.
 * Description 钱包依赖注入中间件(连接提供依赖和消费依赖对象的组件)
 */
@Component(modules = WalletModule.class)
public interface WalletComponent {
	
	void inject(WalletActivity activity);
}

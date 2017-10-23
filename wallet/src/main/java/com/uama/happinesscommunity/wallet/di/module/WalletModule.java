package com.uama.happinesscommunity.wallet.di.module;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jin on 2017/10/18.
 * Description 钱包模块 提供依赖工厂
 */
@Module
public class WalletModule {

	String data = "";

//	public WalletModule(String data) {
//		this.data = data;
//	}
//
//	@Provides
//	WalletPresenter provideWalletPresenter() {
//		return new WalletPresenter(data);
//	}
	
	@Provides
	public String providerString(){
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}

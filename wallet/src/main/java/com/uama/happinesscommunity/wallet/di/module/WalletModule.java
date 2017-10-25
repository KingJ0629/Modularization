package com.uama.happinesscommunity.wallet.di.module;

import android.content.Context;

import com.uama.happinesscommunity.wallet.di.scope.WalletActivityScope;
import com.uama.happinesscommunity.wallet.model.WalletDataSource;
import com.uama.happinesscommunity.wallet.model.WalletLocalDataSource;
import com.uama.happinesscommunity.wallet.model.WalletRemoteDataSource;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jin on 2017/10/18.
 * Description 钱包模块 提供依赖工厂
 */
@Module
public class WalletModule {

	Context mContext;
	
	public WalletModule(Context mContext) {
		this.mContext = mContext;
	}

	@Named("local")
	@WalletActivityScope
	@Provides
	WalletDataSource provideWalletLocalDataSource() {
		return new WalletLocalDataSource(mContext);
	}
	
	@Named("remote")
	@WalletActivityScope
	@Provides
	WalletDataSource provideWalletRemoteDataSource() {
		return new WalletRemoteDataSource();
	}
	
	@Provides
	public String providerString(){
		return "data come from module";
	}
}

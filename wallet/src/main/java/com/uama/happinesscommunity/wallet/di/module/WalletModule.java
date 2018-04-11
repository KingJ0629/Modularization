package com.uama.happinesscommunity.wallet.di.module;

import android.content.Context;

import com.uama.happinesscommunity.wallet.di.scope.WalletActivityScope;
import com.uama.happinesscommunity.wallet.model.WalletDataSource;
import com.uama.happinesscommunity.wallet.model.WalletLocalDataSource;
import com.uama.happinesscommunity.wallet.model.WalletRemoteDataSource;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Jin on 2017/10/18.
 * Description 钱包模块 提供依赖工厂
 */
@Module
public abstract class WalletModule {

	Context mContext;
	
	public WalletModule(Context mContext) {
		this.mContext = mContext;
	}

	@Named("local")
	@WalletActivityScope
	@Binds
	abstract WalletDataSource provideWalletLocalDataSource(WalletLocalDataSource mWalletLocalDataSource);
	
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

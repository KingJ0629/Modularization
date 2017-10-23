package com.uama.happinesscommunity.wallet;

import com.uama.happinesscommunity.base.BasePresenter;
import com.uama.happinesscommunity.base.MVPBaseActivity;
import com.uama.happinesscommunity.wallet.di.component.DaggerWalletComponent;
import com.uama.happinesscommunity.wallet.di.component.WalletComponent;
import com.uama.happinesscommunity.wallet.di.module.WalletModule;

/**
 * Created by Jin on 2017/10/23.
 * Description
 */
public abstract class WalletMVPBaseActivity<V, T extends BasePresenter<V>> extends MVPBaseActivity<V, T> {
	
	protected WalletComponent getWalletComponent() {
		WalletModule mWalletModule = new WalletModule();
		mWalletModule.setData("data come from");
		return DaggerWalletComponent.builder().walletModule(mWalletModule).build();
	}
}

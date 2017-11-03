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
	
	WalletComponent mWalletComponent;
	
	/**
	 * 实现元素注入
	 * 作用域 {@link com.uama.happinesscommunity.wallet.di.scope.WalletActivityScope}
	 */
	protected WalletComponent getWalletComponent() {
		if (mWalletComponent == null)
			mWalletComponent = DaggerWalletComponent.builder()
					.appComponent(getAppComponent())
					.walletModule(new WalletModule())
					.provideContext(this)
					.build();
		return mWalletComponent;
	}
}

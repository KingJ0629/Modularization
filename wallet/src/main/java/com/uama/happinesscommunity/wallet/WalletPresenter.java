package com.uama.happinesscommunity.wallet;

import com.uama.happinesscommunity.wallet.model.Injection;
import com.uama.happinesscommunity.wallet.model.WalletBean;
import com.uama.happinesscommunity.wallet.model.WalletDataSource;
import com.uama.happinesscommunity.wallet.model.WalletRepository;

import java.util.List;

/**
 * Created by Jin on 2017/10/17.
 * Description 钱包模块的P层
 */
public class WalletPresenter extends WalletContract.Presenter {
	
	/**
	 * 如果数据源单一的话，项目中可以去掉Model层
	 * 数据获取在P层实现即可
 	 */
	WalletRepository mWalletRepository;
	
	@Override
	protected void init() {
		mWalletRepository = Injection.provideWalletRepository(mContext.getApplicationContext());
	}
	
	@Override
	protected void request() {
		
		// M层请求数据，M层保证数据渠道的多样性
		mWalletRepository.getWalletList(new WalletDataSource.LoadWalletListCallback() {
			@Override
			public void onWalletListLoaded(List<WalletBean> list) {
				// 回调V层
				getView().loadView(list);
			}
			
			@Override
			public void onWalletListNotAvailable() {
				
			}
		});
	}
}

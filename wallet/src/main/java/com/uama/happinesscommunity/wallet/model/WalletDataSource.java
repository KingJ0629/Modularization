package com.uama.happinesscommunity.wallet.model;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Jin on 2017/10/17.
 * Description
 */
public interface WalletDataSource {
	
	/**
	 * 获取整个列表
	 */
	interface LoadWalletListCallback {
		
		void onWalletListLoaded(List<Wallet> list);
		
		void onWalletListNotAvailable();
	}
	
	/**
	 * 获取单个数据
	 */
	interface GetWalletCallback {
		
		void onWalletLoaded(Wallet bean);
		
		void onWalletNotAvailable();
	}
	
	void getWalletList(@NonNull LoadWalletListCallback callback);
	
	void getWallet(@NonNull String walletId, @NonNull GetWalletCallback callback);
}

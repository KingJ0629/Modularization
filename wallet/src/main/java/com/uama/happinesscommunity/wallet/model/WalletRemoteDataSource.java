package com.uama.happinesscommunity.wallet.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by Jin on 2017/10/17.
 * Description 远程数据的实现
 */
public class WalletRemoteDataSource implements WalletDataSource {
	
	private static WalletRemoteDataSource INSTANCE;
	
	public static WalletRemoteDataSource getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new WalletRemoteDataSource();
		}
		return INSTANCE;
	}
	
	// Prevent direct instantiation.
	private WalletRemoteDataSource() {}
	
	@Override
	public void getWalletList(@NonNull LoadWalletListCallback callback) {
		// 请求远程数据
		callback.onWalletListLoaded(new ArrayList<WalletBean>());
	}
	
	@Override
	public void getWallet(@NonNull String walletId, @NonNull GetWalletCallback callback) {
		
	}
}

package com.uama.happinesscommunity.wallet.model;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Jin on 2017/10/17.
 * Description 本地数据的实现
 */
public class WalletLocalDataSource implements WalletDataSource {
	
	public WalletLocalDataSource(@NonNull Context context) {
		checkNotNull(context);
	}
	
	@Override
	public void getWalletList(@NonNull LoadWalletListCallback callback) {
		// 请求本地数据
		callback.onWalletListLoaded(new ArrayList<WalletBean>());
	}
	
	@Override
	public void getWallet(@NonNull String walletId, @NonNull GetWalletCallback callback) {
		
	}
}

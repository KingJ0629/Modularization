package com.uama.happinesscommunity.wallet.model;

import android.content.Context;
import android.support.annotation.NonNull;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Jin on 2017/10/17.
 * Description 本地数据的实现
 */
public class WalletLocalDataSource implements WalletDataSource {
	
	WalletDao mWalletDao;
	
	public WalletLocalDataSource(@NonNull Context context, WalletDao walletDao) {
		checkNotNull(context);
		this.mWalletDao = walletDao;
		
		{
			// 假数据
			final Wallet wallet = new Wallet("1", "我是假数据");
			new Thread() {
				@Override
				public void run() {
					super.run();
					
					mWalletDao.insertUser(wallet);
				}
			}.start();
		}
	}
	
	@Override
	public void getWalletList(@NonNull final LoadWalletListCallback callback) {
		
		new Thread() {
			@Override
			public void run() {
				super.run();
				
				// 请求本地数据
				callback.onWalletListLoaded(mWalletDao.getUser());
			}
		}.start();
	}
	
	@Override
	public void getWallet(@NonNull String walletId, @NonNull GetWalletCallback callback) {
		
	}
}

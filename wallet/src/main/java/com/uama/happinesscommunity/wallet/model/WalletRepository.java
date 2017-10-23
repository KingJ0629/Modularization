package com.uama.happinesscommunity.wallet.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Jin on 2017/10/17.
 * Description 钱包Model层
 */
public class WalletRepository implements WalletDataSource {
	
	private final WalletDataSource mTasksRemoteDataSource;
	
	private final WalletDataSource mTasksLocalDataSource;
	
	/**
	 * 缓存数据
	 */
	Map<String, WalletBean> mCachedData;
	
	/**
	 * 是否有本地数据
	 */
	boolean hasLocalData = true;
	
	@Inject
	public WalletRepository(@Named("remote") WalletDataSource tasksRemoteDataSource,
	                        @Named("local") WalletDataSource tasksLocalDataSource) {
		mTasksRemoteDataSource = checkNotNull(tasksRemoteDataSource);
		mTasksLocalDataSource = checkNotNull(tasksLocalDataSource);
	}
	
	@Override
	public void getWalletList(@NonNull final LoadWalletListCallback callback) {
		checkNotNull(callback);
		
		// 如果有缓存数据
		if (mCachedData != null) {
			callback.onWalletListLoaded(new ArrayList<>(mCachedData.values()));
			return;
		}
		
		if (hasLocalData) {
			/**
			 * 加载本地数据
			 */
			mTasksLocalDataSource.getWalletList(new LoadWalletListCallback() {
				@Override
				public void onWalletListLoaded(List<WalletBean> list) {
					callback.onWalletListLoaded(list);
				}
				
				@Override
				public void onWalletListNotAvailable() {
					callback.onWalletListNotAvailable();
				}
			});
		} else {
			/**
			 * 没有本地数据就从远程加载数据
			 */
			mTasksRemoteDataSource.getWalletList(new LoadWalletListCallback() {
				@Override
				public void onWalletListLoaded(List<WalletBean> list) {
					callback.onWalletListLoaded(list);
				}
				
				@Override
				public void onWalletListNotAvailable() {
					callback.onWalletListNotAvailable();
				}
			});
		}
	}
	
	@Override
	public void getWallet(@NonNull String walletId, @NonNull GetWalletCallback callback) {
		
	}
}

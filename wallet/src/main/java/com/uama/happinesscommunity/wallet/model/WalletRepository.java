package com.uama.happinesscommunity.wallet.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Jin on 2017/10/17.
 * Description 钱包Model层
 */
public class WalletRepository implements WalletDataSource {
	
	private static WalletRepository INSTANCE = null;
	
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
	
	private WalletRepository(@NonNull WalletDataSource tasksRemoteDataSource,
	                         @NonNull WalletDataSource tasksLocalDataSource) {
		mTasksRemoteDataSource = checkNotNull(tasksRemoteDataSource);
		mTasksLocalDataSource = checkNotNull(tasksLocalDataSource);
	}
	
	/**
	 * Returns the single instance of this class, creating it if necessary.
	 *
	 * @param tasksRemoteDataSource the backend data source
	 * @param tasksLocalDataSource  the device storage data source
	 * @return the {@link WalletDataSource} instance
	 */
	public static WalletRepository getInstance(WalletDataSource tasksRemoteDataSource,
	                                           WalletDataSource tasksLocalDataSource) {
		if (INSTANCE == null) {
			INSTANCE = new WalletRepository(tasksRemoteDataSource, tasksLocalDataSource);
		}
		return INSTANCE;
	}
	
	/**
	 * Used to force {@link #getInstance(WalletDataSource, WalletDataSource)} to create a new instance
	 * next time it's called.
	 */
	public static void destroyInstance() {
		INSTANCE = null;
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

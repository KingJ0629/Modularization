package com.uama.happinesscommunity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Jin on 2017/6/7.
 * Description MVP模式 V 和P建立关联的基类
 */
public abstract class MVPBaseFragment<V, T extends BasePresenter<V>> extends BaseFragment {
	
	// Presenter对象
	protected T mPresenter;
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 创建Presenter
		mPresenter = checkNotNull(createPresenter());
		
		// View与Presenter 建立关联
		mPresenter.attachView(mContext, (V) mContext);
	}
	
	protected abstract T createPresenter();
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		// 清空网络请求的calls
		mPresenter.cancelRetrofitHelper();
		
		// View与Presenter 解除关联
		/**
		 * 当Activity结束时，网络请求还没返回，mPresenter会一直持有Activity的对象,
		 * 导致Activity对象无法被回收，从而产生内存泄漏
		 */
		mPresenter.detachView();
	}
}

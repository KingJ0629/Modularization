package com.uama.happinesscommunity.base;

import android.content.Context;
import android.support.annotation.Nullable;

import com.uama.happinesscommunity.bean.BaseEntity;
import com.uama.happinesscommunity.common.utils.L;
import com.uama.happinesscommunity.net.ProtocolManagers;
import com.uama.happinesscommunity.net.RetrofitCallback;
import com.uama.happinesscommunity.net.RetrofitHelper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import dagger.internal.Preconditions;
import retrofit2.Call;

/**
 * Created by Jin on 2017/6/7.
 * Description Presenter的基类
 */
public abstract class BasePresenter<T> {
	
	protected Context mContext;
	
	// View 接口的弱引用
	protected Reference<T> mViewRef;
	
	// 建立关联
	public void attachView(Context mContext, T view) {
		this.mContext = mContext;
		mViewRef = new WeakReference<>(view);
		
		retrofitHelper = RetrofitHelper.get(mContext);
		
		init();
	}
	
	// 初始化数据
	protected void init() { }
	
	protected T getView() {
		return mViewRef.get();
	}
	
	public boolean isViewAttached() {
		return null != mViewRef & null != mViewRef.get();
	}
	
	/**
	 * 如果Activity被销毁，view会被置为null
	 */
	public void detachView() {
		if (null != mViewRef) {
			mViewRef.clear();
			mViewRef = null;
		}
	}
	
	/***  ------------封装网络请求----------- ***/
	private RetrofitHelper retrofitHelper;
	
	/**
	 * 使用RetrofitHelper进行网络请求
	 */
	public <T extends BaseEntity> void enqueue(Call<T> call, RetrofitCallback<T> callback) {
		retrofitHelper.enqueue(call, callback);
	}
	
	/**
	 * 当页面Destroy的时候清空calls
	 */
	public void cancelRetrofitHelper() {
		if (null != retrofitHelper)
			retrofitHelper.cancelCalls();
	}
	
	public <T> T getService(Class<T> service) {
		return ProtocolManagers.getInstance(mContext).getService(service);
	}
	/***  ------------封装网络请求  end ----------- ***/
	
	protected <T> T checkNotNull(T t, @Nullable String errorMessage) {
		try {
			Preconditions.checkNotNull(t, errorMessage);
		} catch (NullPointerException e) {
			L.e("后台返回非法数据!!");
		} finally {
			return t;
		}
	}
	
	protected boolean isNotNull(Object o) {
		return null != o;
	}
	
	/**
	 * 字符串不为空
	 * @return true为非空字符串
	 */
	protected boolean isNotNull(String str) {
		return str != null && !str.equals("null") && !str.equals("");
	}
}

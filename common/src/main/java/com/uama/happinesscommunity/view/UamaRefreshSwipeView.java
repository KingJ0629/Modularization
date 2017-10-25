package com.uama.happinesscommunity.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

/**
 * Created by Jin on 2017/10/25.
 * Description 下拉刷新控件--google原生样式
 */
public class UamaRefreshSwipeView extends SwipeRefreshLayout {
	
	public UamaRefreshSwipeView(Context context) {
		super(context);
		init();
	}
	
	public UamaRefreshSwipeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	/**
	 * 默认刷新样式初始化
	 */
	private void init() {
		
	}
	
	public interface OnRefreshListener {
		void onRefresh();
	}
	
	/**
	 * 下拉刷新监听
	 * @param onRefreshListener {@link OnRefreshListener}
	 */
	public void addOnRefreshListener(final OnRefreshListener onRefreshListener) {
		super.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				onRefreshListener.onRefresh();
			}
		});
	}
	
	/**
	 * 自动刷新
	 */
	public void autoRefresh() {
		super.setRefreshing(true);
	}
	
	/**
	 * 完成刷新
	 */
	public void refreshComplete() {
		super.setRefreshing(false);
	}
}

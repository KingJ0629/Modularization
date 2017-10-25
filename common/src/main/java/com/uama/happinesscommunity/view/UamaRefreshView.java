package com.uama.happinesscommunity.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

/**
 * Created by Jin on 2017/10/25.
 * Description 下拉刷新控件
 */
public class UamaRefreshView extends UamaRefreshLayout {
	
	public UamaRefreshView(Context context) {
		super(context);
		init();
	}
	
	public UamaRefreshView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	/**
	 * 默认刷新样式初始化
	 * 具体设置项根据第三方可配置项配置
	 */
	private void init() {
		super.setBackgroundColor(Color.GREEN);
		super.setAutoRefreshDuration(400);
		super.setRatioOfHeaderHeightToReach(1.5f);
	}
	
	public interface OnRefreshListener {
		void onRefresh();
	}
	
	/**
	 * 下拉刷新监听
	 * @param onRefreshListener {@link OnRefreshListener}
	 */
	public void addOnRefreshListener(final OnRefreshListener onRefreshListener) {
		super.addOnVRefreshListener(new UamaRefreshLayout.OnVRefreshListener() {
			
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
		super.autoRefresh();
	}
	
	/**
	 * 完成刷新
	 */
	public void refreshComplete() {
		super.refreshComplete();
	}
}

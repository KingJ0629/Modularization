package com.uama.happinesscommunity.common.listen;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * 自定义监听点击事件 ClassName: MyOnClickListener Function: TODO 防止重复点击 date: 2014年9月19日
 * 上午10:01:49
 *
 * @author Administrator
 * @version
 * @since JDK 1.6
 */
public class MyOnClickListener implements OnClickListener {

	private final OnClickListener mListener;
	private long clickTime;

	private boolean ignoreClick = true;

	public MyOnClickListener() {
		this(null);
	}

	public MyOnClickListener(OnClickListener listener) {
		this.mListener = listener;
	}

	@Override
	public void onClick(View v) {
		long curClickTime = SystemClock.elapsedRealtime();
		if (isIgnoreClick() && curClickTime - clickTime < 500) {
			// 忽略小于500ms内的重复点击
			return;
		}
		clickTime = curClickTime;
		if (mListener != null) {
			mListener.onClick(v);
		}
	}

	public boolean isIgnoreClick() {
		return ignoreClick;
	}

	public void setIgnoreClick(boolean ignoreClick) {
		this.ignoreClick = ignoreClick;
	}
}

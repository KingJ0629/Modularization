package com.uama.happinesscommunity.arouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.uama.happinesscommunity.common.R;

/**
 * Created by Jin on 2017/10/16.
 * Description 全局拦截
 */
@Interceptor(priority = 1)
public class DefaultInterceptor implements IInterceptor {
	
	@Override
	public void process(Postcard postcard, InterceptorCallback callback) {
		// 跳转动画
		postcard.withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom);
		callback.onContinue(postcard);
	}
	
	@Override
	public void init(Context context) {
		
	}
}

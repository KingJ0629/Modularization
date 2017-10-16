package com.uama.happinesscommunity.arouter.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jin on 2017/10/16.
 * Description 登录拦截器
 */
@Interceptor(priority = 2)
public class LoginInterceptor implements IInterceptor {
	
	private List<String> mInterceptorList;
	
	@Override
	public void process(Postcard postcard, InterceptorCallback callback) {
		if (mInterceptorList.contains(postcard.getPath())) {
			callback.onInterrupt(null);
		} else {
			postcard.withString("extra", "我是在拦截器中附加的参数");
			callback.onContinue(postcard);
		}
	}
	
	@Override
	public void init(Context context) {
		mInterceptorList = new ArrayList();
		mInterceptorList.add("/test/testInterceptor");
	}
}

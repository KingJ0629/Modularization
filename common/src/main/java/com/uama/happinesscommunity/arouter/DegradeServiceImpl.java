package com.uama.happinesscommunity.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * Created by Jin on 2017/10/16.
 * Description 自定义全局降级策略
 */
@Route(path = "/service/degrade")
public class DegradeServiceImpl implements DegradeService {
	
	@Override
	public void onLost(Context context, Postcard postcard) {
		// 自定义全局降级策略
	}
	
	@Override
	public void init(Context context) {
		
	}
}

package com.uama.happinesscommunity.life.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;
import com.uama.happinesscommunity.base.MVPBaseActivity;
import com.uama.happinesscommunity.life.DaggerLifeComponent;

import java.util.List;

/**
 * Created by Jin on 2017/10/26.
 * Description
 */
@Route(path = ARouterConstant.LIFE_SAMPLE)
public class SampleActivity extends MVPBaseActivity<SampleContract.View, SamplePresenter> implements SampleContract.View {
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mPresenter.request();
	}
	
	@Override
	protected void initInject() {
		DaggerLifeComponent.create().inject(this);
	}
	
	@Override
	public void loadView(List<String> list) {
	
	}
	
}

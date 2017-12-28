package com.uama.happinesscommunity.modularization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;
import com.uama.happinesscommunity.common.utils.L;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		
		EventBus.builder().addIndex(new AppEventBusIndex()).installDefaultEventBus();
	}
	
	@OnClick(R.id.layout)
	public void click() {
		L.i("msg", "MainActivity start");
		ARouter.getInstance().build(ARouterConstant.LIFE_INDEX).navigation();
	}
}

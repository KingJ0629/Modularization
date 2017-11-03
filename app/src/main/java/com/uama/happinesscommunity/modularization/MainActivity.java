package com.uama.happinesscommunity.modularization;

import android.content.Intent;
import android.os.Bundle;

import com.uama.happinesscommunity.Test;
import com.uama.happinesscommunity.common.utils.L;
import com.uama.happinesscommunity.life.dagger_android.TempActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
	
	@Inject
	Test tt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		
	}
	
	@OnClick(R.id.layout)
	public void click() {
		L.i("msg", "MainActivity start");
//		ARouter.getInstance().build(ARouterConstant.LIFE_SAMPLE).navigation();
		
		L.i("MainActivity   tt : " + tt.getName());
		
		Intent i = new Intent(this, TempActivity.class);
		startActivity(i);
	}
}

package com.uama.happinesscommunity.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uama.happinesscommunity.TestActivity;
import com.uama.happinesscommunity.common.utils.L;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		
	}
	
	@OnClick(R.id.layout)
	public void click() {
		L.i("msg", "MainActivity start");
//		ARouter.getInstance().build(ARouterConstant.LIFE_INDEX).navigation();
		
		Intent t = new Intent(this, TestActivity.class);
		startActivity(t);
		
	}
}

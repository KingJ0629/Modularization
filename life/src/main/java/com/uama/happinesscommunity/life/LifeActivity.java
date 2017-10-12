package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jin
 */
public class LifeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.life_layout);
		ButterKnife.bind(this);
	}
	
	@OnClick(R2.id.layout)
	public void click() {
		Log.i("msg", "LifeActivity");
		ARouter.getInstance().build("/wallet/WalletActivity").navigation();
	}
}
package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
	
	@OnClick(R2.id.tv1)
	public void click() {
		ARouter.getInstance().build("/wallet/WalletActivity").withString("name", "caodan").navigation();
	}
	
	@OnClick(R2.id.tv2)
	public void click2() {
		LifeBean bean = new LifeBean("xixi");
		ARouter.getInstance().build("/life/Life2Activity").withObject("bean", bean).navigation();
	}
}
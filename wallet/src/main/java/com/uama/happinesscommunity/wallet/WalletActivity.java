package com.uama.happinesscommunity.wallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;

import butterknife.ButterKnife;

/**
 * Created by Jin on 2017/10/12.
 * Description
 */
@Route(path = ARouterConstant.WALLET_INDEX)
public class WalletActivity extends Activity {
	
	@Autowired
	String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wallet_life_layout);
		ButterKnife.bind(this);
		ARouter.getInstance().inject(this);
		
		Log.i("msg", "WalletActivity class " + name);
	}
}

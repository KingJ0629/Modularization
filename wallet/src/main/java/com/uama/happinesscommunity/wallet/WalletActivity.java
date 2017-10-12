package com.uama.happinesscommunity.wallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.ButterKnife;

/**
 * Created by Jin on 2017/10/12.
 * Description
 */
@Route(path = "/wallet/WalletActivity")
public class WalletActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wallet_life_layout);
		ButterKnife.bind(this);
		
		Log.i("msg", "WalletActivity class");
	}
}
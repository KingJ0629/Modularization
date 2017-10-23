package com.uama.happinesscommunity.base;

import android.support.v7.app.AppCompatActivity;

import com.uama.happinesscommunity.di.AppComponent;

/**
 * Created by Jin on 2017/10/17.
 * Description
 */
public class BaseActivity extends AppCompatActivity {
	
	protected AppComponent getAppComponent() {
		return CommonApplication.getAppComponent();
	}
}

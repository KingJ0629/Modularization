package com.uama.happinesscommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.uama.happinesscommunity.common.utils.L;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Jin on 2017/11/1.
 * Description
 */
public class TestActivity extends DaggerAppCompatActivity {
	
	@Inject
	Test tt;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		L.i("tt : " + tt.getName());
	}
}

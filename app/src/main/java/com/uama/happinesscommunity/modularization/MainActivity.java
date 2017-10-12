package com.uama.happinesscommunity.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.uama.happinesscommunity.life.LifeActivity;

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
		Intent i = new Intent(this, LifeActivity.class);
		Log.i("msg", "转转");
		startActivity(i);
	}
}

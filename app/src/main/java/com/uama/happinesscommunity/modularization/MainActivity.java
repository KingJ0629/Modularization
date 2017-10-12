package com.uama.happinesscommunity.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.uama.happinesscommunity.LifeFragment;
import com.uama.happinesscommunity.life.LifeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		
		findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				LifeFragment lifeFragment;
				Intent i = new Intent(MainActivity.this, LifeActivity.class);
				Log.i("msg", "转转2");
				startActivity(i);
			}
		});
	}
	
	@OnClick(R.id.layout)
	public void click() {
		LifeFragment lifeFragment;
		Intent i = new Intent(this, LifeActivity.class);
		Log.i("msg", "转转");
		startActivity(i);
	}
}

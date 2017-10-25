package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;
import com.uama.happinesscommunity.common.utils.L;
import com.uama.happinesscommunity.view.UamaRefreshView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jin
 */
@Route(path = ARouterConstant.LIFE_INDEX2)
public class Life2Activity extends AppCompatActivity {
	
	@BindView(R2.id.refresh_layout)
	UamaRefreshView mView;
	
	@Autowired
	LifeBean bean;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.life2_layout);
		ButterKnife.bind(this);
		ARouter.getInstance().inject(this);
		
		Toast.makeText(this, bean.getHa(), Toast.LENGTH_SHORT).show();
		
		mView.addOnRefreshListener(new UamaRefreshView.OnRefreshListener() {
			@Override
			public void onRefresh() {
				mView.postDelayed(new Runnable() {
					@Override
					public void run() {
						h.sendEmptyMessage(0);
					}
				}, 1000);
			}
		});
	}
	
	Handler h = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			mView.refreshComplete();
		}
	};
	
	@OnClick(R2.id.tv)
	public void click() {
		L.i("msg", "Life2Activity");
		ARouter.getInstance().build(ARouterConstant.WALLET_INDEX).navigation();
	}
}
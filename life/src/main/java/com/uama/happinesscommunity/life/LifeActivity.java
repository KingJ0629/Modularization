package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;
import com.uama.happinesscommunity.view.UamaImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jin
 */
@Route(path = ARouterConstant.LIFE_INDEX)
public class LifeActivity extends AppCompatActivity {

	@BindView(R2.id.tv2)
	UamaImageView mView;
	
	private final static String TAG = "LifeActivity.class";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.life_layout);
		ButterKnife.bind(this);
		
		String url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=280326699,1207777040&fm=27&gp=0.jpg";
		mView.setImage(url);
	}
	
	@OnClick(R2.id.tv1)
	public void click() {
		ARouter.getInstance().build(ARouterConstant.WALLET_INDEX).withString("name", "我是参数").navigation();
	}
	
	@OnClick(R2.id.tv2)
	public void click2() {
		LifeBean bean = new LifeBean("自定义对象传递");
		ARouter.getInstance().build(ARouterConstant.LIFE_INDEX2).withObject("bean", bean).navigation();
	}
	
	/**
	 * 解决fragment onActivityResult不调用
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 *
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		FragmentManager fm = getSupportFragmentManager();
		if (fm.getFragments() == null) {
			Log.w(TAG, "Activity result fragment fragmentIndex out of range: 0x"
					+ Integer.toHexString(requestCode));
			return;
		}
		for (int i = 0; i <fm.getFragments().size() ; i++) {
			Fragment frag = fm.getFragments().get(i);
			if (frag == null) {
				Log.w(TAG, "Activity result no fragment exists for fragmentIndex: 0x"
						+ Integer.toHexString(requestCode));
			} else {
				handleResult(frag, requestCode, resultCode, data);
			}
		}
		return;
	}
	
	/**
	 * 递归调用，对所有子Fragment生效
	 * @param frag
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 
	private void handleResult(Fragment frag, int requestCode, int resultCode, Intent data) {
		frag.onActivityResult(requestCode, resultCode, data);
		List<Fragment> frags = frag.getChildFragmentManager().getFragments();
		if (frags != null) {
			for (Fragment f : frags) {
				if (f != null)
					handleResult(f, requestCode, resultCode, data);
			}
		}
	}*/
}
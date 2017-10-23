package com.uama.happinesscommunity.wallet;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.uama.happinesscommunity.arouter.constant.ARouterConstant;
import com.uama.happinesscommunity.common.utils.L;
import com.uama.happinesscommunity.wallet.model.WalletBean;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Jin on 2017/10/12.
 * Description 钱包模块View层
 */
@Route(path = ARouterConstant.WALLET_INDEX)
public class WalletActivity extends WalletMVPBaseActivity<WalletContract.View, WalletPresenter> implements WalletContract.View {
	
	@Autowired
	String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wallet_life_layout);
		ButterKnife.bind(this);
		ARouter.getInstance().inject(this);
		
		L.i("msg", "WalletActivity class " + name);
		
		mPresenter.request();
	}
	
	@Override
	protected void initInject() {
		getWalletComponent().inject(this);
	}
	
	@Override
	public void loadView(List<WalletBean> list) {
		L.i("msg", "WalletActivity MVP");
	}
}

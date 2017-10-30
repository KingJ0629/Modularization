package com.uama.happinesscommunity.wallet;

import com.uama.happinesscommunity.base.BasePresenter;
import com.uama.happinesscommunity.wallet.model.WalletBean;

import java.util.List;

/**
 * Created by Jin on 2017/7/19.
 * Description 钱包功能的 View、Presenter 抽象层
 */
public interface WalletContract {
	
	interface View {
		/**
		 * loadView
		 */
		void loadView(List<WalletBean> list);
	}
	
	abstract class Presenter extends BasePresenter<View> {
		
		/**
		 * request
		 */
		protected abstract void request();
	}
}

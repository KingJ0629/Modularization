package com.uama.happinesscommunity.life.sample;

import com.uama.happinesscommunity.base.BasePresenter;

import java.util.List;

/**
 * Created by Jin on 2017/10/26.
 * Description 中间件
 */
public interface SampleContract {
	
	interface View {
		/**
		 * loadView
		 */
		void loadView(List<String> list);
	}
	
	abstract class Presenter extends BasePresenter<View> {
		
		/**
		 * request
		 */
		protected  abstract void request();
	}
}

package com.uama.happinesscommunity.life.sample;

import com.uama.happinesscommunity.common.utils.L;

import javax.inject.Inject;

/**
 * Created by Jin on 2017/10/26.
 * Description
 */
public class SamplePresenter extends SampleContract.Presenter {
	
	@Inject
	public SamplePresenter() {}
	
	@Override
	protected void request() {
		getView().loadView(null);
		L.i("success");
	}
}

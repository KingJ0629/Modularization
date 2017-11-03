package com.uama.happinesscommunity.life.dagger_android;

import javax.inject.Inject;

/**
 * Created by Jin on 2017/11/1.
 * Description
 */
public class TempBean {
	
	@Inject
	public TempBean() {
		this.text = "sample text";
	}
	
	private String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}

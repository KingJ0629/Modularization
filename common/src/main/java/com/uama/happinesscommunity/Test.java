package com.uama.happinesscommunity;

import javax.inject.Inject;

/**
 * Created by Jin on 2017/11/1.
 * Description
 */
public class Test {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Inject
	public Test() {
		this.name = "test name";
	}
}

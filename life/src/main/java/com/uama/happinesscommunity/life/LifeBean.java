package com.uama.happinesscommunity.life;

import java.io.Serializable;

/**
 * Created by Jin on 2017/10/14.
 * Description
 */
public class LifeBean implements Serializable {
	
	private String ha;
	
	public String getHa() {
		return ha;
	}
	
	public LifeBean() {
		
	}
	
	public LifeBean(String ha) {
		this.ha = ha;
	}
	
	public void setHa(String ha) {
		this.ha = ha;
	}
}

package com.uama.happinesscommunity.wallet.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * Created by Jin on 2017/10/17.
 * Description
 */
@Entity(tableName = "wallets")
public class Wallet {
	
	@NonNull
	@PrimaryKey
	@ColumnInfo(name = "wallet_id")
	private String mId;
	
	@ColumnInfo(name = "name")
	private String name;
	
	@Ignore
	public Wallet(String name) {
		this.mId = UUID.randomUUID().toString();
		this.name = name;
	}
	
	public Wallet(String mId, String name) {
		this.mId = mId;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@NonNull
	public String getId() {
		return mId;
	}
	
	public void setId(@NonNull String id) {
		mId = id;
	}
}

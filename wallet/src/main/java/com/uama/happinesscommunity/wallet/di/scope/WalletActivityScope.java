package com.uama.happinesscommunity.wallet.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jin on 2017/10/25.
 * Description 作用域
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface WalletActivityScope {
}

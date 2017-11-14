package com.uama.happinesscommunity.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jin on 2017/11/3.
 * Description
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface FragmentInject {
}

package com.uama.happinesscommunity.life;

import com.uama.happinesscommunity.life.sample.SampleActivity;

import dagger.Component;

/**
 * Created by Jin on 2017/10/26.
 * Description 依赖注入中间件
 */
@Component
public interface LifeComponent {
	
	void inject(SampleActivity activity);
}

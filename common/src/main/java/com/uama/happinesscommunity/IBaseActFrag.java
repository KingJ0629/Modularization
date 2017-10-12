/*
 * 杭州绿漫科技有限公司
 * Copyright (c) 16-6-24 下午2:22.
 */

package com.uama.happinesscommunity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @author zexu
 */
public interface IBaseActFrag {

    void qStartActivity(Intent intent);

    void qStartActivity(Class<? extends Activity> cls);

    /**
     * 打开新的Activity
     */
    void qStartActivity(Class<? extends Activity> cls, Bundle bundle);

    /**
     * 打开新的Activity for result
     */
    void qStartActivityForResult(Class<? extends Activity> cls, Bundle bundle, int requestCode);

    /**
     * 带结果返回上一个activity， 配合qStartActivityForResult使用
     */
    void qBackForResult(int resultCode, Bundle bundle);

    /**
     * 回到之前的Activity
     */
    void qBackToActivity(Class<? extends Activity> cls, Bundle bundle);

    Context getContext();

    Handler getHandler();
}

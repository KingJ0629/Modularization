package com.uama.happinesscommunity.common.utils;

/**
 * Created by lvman on 2016/4/25.
 */
public class Tool {

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD > 500)
            lastClickTime = time;
        return timeD <= 500;
    }

    private static long lastClickTime = 0;
}

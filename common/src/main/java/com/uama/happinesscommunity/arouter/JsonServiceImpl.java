package com.uama.happinesscommunity.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

/**
 * Created by Jin on 2017/10/16.
 * Description 传递自定义对象解析
 */
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {
    
    @Override
    public void init(Context context) {

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return new Gson().fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }
}

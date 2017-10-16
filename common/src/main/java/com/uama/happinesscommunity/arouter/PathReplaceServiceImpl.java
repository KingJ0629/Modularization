package com.uama.happinesscommunity.arouter;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

/**
 * Created by Jin on 2017/10/16.
 * Description 重载ARouter的路径跳转
 */
@Route(path = "/service/path")
public class PathReplaceServiceImpl implements PathReplaceService {
	
	@Override
	public String forString(String path) {
		return path;
	}
	
	@Override
	public Uri forUri(Uri uri) {
		return uri;
	}
	
	@Override
	public void init(Context context) {
		
	}
}

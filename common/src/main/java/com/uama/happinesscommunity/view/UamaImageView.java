package com.uama.happinesscommunity.view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;

/**
 * Created by Jin on 2017/10/24.
 * Description 绿漫图片加载容器
 */
public class UamaImageView extends SimpleDraweeView {
	
	public UamaImageView(Context context) {
		super(context);
		init();
	}
	
	public UamaImageView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public UamaImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	/**
	 * 图片容器的默认配置参数
	 */
	private void init() {
		
	}
	
	/**
	 * 加载图片
	 * @param url 图片网络地址
	 */
	public void setImage(String url) {
		this.setImage(Uri.parse(url));
	}
	
	/**
	 * 加载图片
	 * @param res 本地图片资源
	 */
	public void setImage(@DrawableRes int res) {
		super.setImageURI(Uri.parse("res://" + UamaImageViewConfig.APPLICATION_ID + "/"+ res));
	}
	
	/**
	 * 加载图片
	 * @param uri Uri
	 */
	public void setImage(Uri uri) {
		loadImageUri(uri);
	}
	
	/**
	 * 原有项目加载图片的实现
	 * @param uri uri
	 */
	private void loadImageUri(Uri uri) {
		ImageRequest imageRequest = UamaImageViewConfig.getImageRequest(this, uri);
		DraweeController draweeController = UamaImageViewConfig.getDraweeController(imageRequest, this);
		super.setController(draweeController);
	}
	
	/**
	 * 设置自定义配置，配置可以写在 {@link UamaImageViewConfig} 中；
	 * 如果不设置，UamaImageView会自动加载一套项目默认的配置，在{@link #loadImageUri}中初始化
	 * @param mController UamaImageViewController 现在是Fresco DraweeController的替代层,方便以后图片加载框架整体替换
	 */
	public void setController(UamaImageViewController mController) {
		super.setController(mController);
	}
}

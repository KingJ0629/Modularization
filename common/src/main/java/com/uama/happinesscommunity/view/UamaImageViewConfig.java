package com.uama.happinesscommunity.view;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by Jin on 2017/10/24.
 * Description {@link UamaImageView} 配置
 */
public class UamaImageViewConfig {
	
	/**
	 * 项目包名，需要配置
	 */
	public static String APPLICATION_ID = "com.uama.happinesscommunity";
	
	/**
	 * 建议在Application中初始化这个方法
	 * @param context ApplicationContext
	 */
	public static void initialize(Context context) {
		Fresco.initialize(context);
	}
	
	/**
	 * 清除缓存
	 */
	public static void clearUamaImageViewCache() {
		ImagePipeline imagePipeline = Fresco.getImagePipeline();
		imagePipeline.clearMemoryCaches();
		imagePipeline.clearDiskCaches();
		imagePipeline.clearCaches();
	}
	
	/**********************   config  **************************/
	/**
	 * 原来项目中对Fresco的配置
	 */
	// 图片解码
	public static ImageDecodeOptions getImageDecodeOptions() {
		ImageDecodeOptions decodeOptions = ImageDecodeOptions.newBuilder()
				.setUseLastFrameForPreview(true)// 使用最后一帧进行预览
				.build();
		return decodeOptions;
	}
	
	// 图片显示
	public static ImageRequest getImageRequest(UamaImageView view, Uri uri) {
		ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
				.setImageDecodeOptions(getImageDecodeOptions())//  图片解码库
				.setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)// 请求经过缓存级别
//				.setResizeOptions(new ResizeOptions(view.getLayoutParams().width / 2, view.getLayoutParams().height / 2))// 调整大小
				.build();
		return imageRequest;
	}
	
	public static ImageRequest getImageRequest(UamaImageView view, Uri uri,int resizeX,int resizeY) {
		ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
				.setImageDecodeOptions(getImageDecodeOptions())//  图片解码库
				.setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)// 请求经过缓存级别
				.setResizeOptions(new ResizeOptions(resizeX, resizeY))// 调整大小
				.build();
		return imageRequest;
	}
	
	// DraweeController 控制 DraweeControllerBuilder
	public static DraweeController getDraweeController(ImageRequest imageRequest, UamaImageView view) {
		DraweeController draweeController = Fresco.newDraweeControllerBuilder()
				.setImageRequest(imageRequest)// 设置单个图片请求～不可与setFirstAvailableImageRequests共用，配合setLowResImageRequest为高分辨率的图
				.setOldController(view.getController())// DraweeController复用
				.build();
		return draweeController;
	}
	/**********************   config end  **************************/
}

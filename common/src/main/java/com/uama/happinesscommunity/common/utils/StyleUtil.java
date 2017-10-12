package com.uama.happinesscommunity.common.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uama.happinesscommunity.common.R;
import com.uama.happinesscommunity.common.listen.MyOnClickListener;

/**
 * ClassName:StyleUtil <br/>
 * Function:  统一顶部标题栏 Reason: <br/>
 * Date: 2016年5月30日 上午10:50:07 <br/>
 *
 * @author gujiajia
 * @version
 * @since JDK 1.6
 * @see
 */
public class StyleUtil {
	/**
	 * 只有左边返回键
	 *
	 * @param activity
	 * @param title 标题
	 */
	public static void titleBackKey(final Activity activity, String title) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(new MyOnClickListener() {

			@Override
			public void onClick(View v) {
				if (Tool.isFastDoubleClick())
					return;
				activity.finish();
			}
		});
	}

	//只有左边返回键，并有返回键监听
	public static void titleBackKeyWithListener(final Activity activity, String title, OnClickListener listen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(listen);
	}

	/**
	 * 只有左边文字返回键
	 *
	 * @param activity
	 * @param title 标题
	 */
	public static void titleBackTextView(final Activity activity, String title, String leftText) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(new MyOnClickListener() {

			@Override
			public void onClick(View v) {
				if (Tool.isFastDoubleClick())
					return;
				activity.finish();
			}
		});
		((TextView) activity.findViewById(R.id.head_left_tv)).setText(leftText);
	}

	/**
	 * 只有左边返回按键，并且自定义返回icon、监听事件
	 *
	 * @param activity
	 * @param title 标题
	 */
	public static void titleBackCustomIconWithListener(final Activity activity, String title, int leftPic, OnClickListener listen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(leftPic);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(listen);
	}

	/**
	 * fragment左边只有左边返回按键，并且自定义返回icon、监听事件
	 *
	 * @param rootView
	 * @param title 标题
	 */
	public static void titleBackCustomIconWithListener(final View rootView, String title, int leftPic, OnClickListener listen) {
		((TextView) rootView.findViewById(R.id.title_text)).setText(title);
		((ImageView) rootView.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) rootView.findViewById(R.id.iv_back)).setBackgroundResource(leftPic);
		LinearLayout lvBack = (LinearLayout) rootView.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(listen);
	}

	/**
	 * 左右都是TextView
	 *
	 * @param activity
	 * @param title 标题
	 */
	public static void titleBothTextView(final Activity activity, String title, String leftText, String rightText,
			OnClickListener listen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((TextView) activity.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(listen);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		((TextView) activity.findViewById(R.id.head_left_tv)).setText(leftText);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(listen);

	}

	/**
	 * fragment只有右边文字和监听事件
	 *
	 * @param rootView
	 * @param title 标题
	 */
	public static void titleWithRightTextViewListener(final View rootView, String title, String rightText, OnClickListener listen) {
		((TextView) rootView.findViewById(R.id.title_text)).setText(title);
		((TextView) rootView.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout rback = (LinearLayout) rootView.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(listen);
		LinearLayout lvBack = (LinearLayout) rootView.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.GONE);

	}

	/**
	 * 左边默认返回键，右边自定义图片和监听事件
	 *
	 * @param activity
	 * @param title 标题
	 */
	public static void titleBackKeyWithRightIconListener(final Activity activity, String title, int rightPic, OnClickListener listen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		ImageView leftIv = ((ImageView) activity.findViewById(R.id.iv_back));
		ImageView rightIv = ((ImageView) activity.findViewById(R.id.head_info));
		leftIv.setVisibility(View.VISIBLE);
		rightIv.setVisibility(View.VISIBLE);
		leftIv.setBackgroundResource(R.mipmap.header_back);
		rightIv.setImageResource(rightPic);
		LinearLayout lvRight = (LinearLayout) activity.findViewById(R.id.ler_save);
		lvRight.setVisibility(View.VISIBLE);
		lvRight.setOnClickListener(listen);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(new MyOnClickListener() {

			@Override
			public void onClick(View v) {
				if (Tool.isFastDoubleClick())
					return;
				activity.finish();
			}
		});
	}

	//左边返回键，右边文字和监听事件
	public static void titleBackKeyWithRightTextViewListener(final Activity activity, String title, String rightText,
			OnClickListener listen) {
		// activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((TextView) activity.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(listen);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(new MyOnClickListener() {

			@Override
			public void onClick(View v) {
				if (Tool.isFastDoubleClick())
					return;
				activity.finish();
			}
		});
	}

	//只有右边文字和监听事件
	public static void titleWithRightTextViewListener(final Activity activity, String title, String rightText,
			OnClickListener listen) {
		// activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((TextView) activity.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		LinearLayout lerback = (LinearLayout) activity.findViewById(R.id.ler_back);
		lerback.setVisibility(View.INVISIBLE);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(listen);
	}

	/**
	 * fragment左右自定义图片和监听
	 *
	 * @param title 标题
	 */
	public static void titleBothIconListener(View rootView, String title, int leftPic, OnClickListener leftListen,
			int rightPic, OnClickListener rightListen) {
		((TextView) rootView.findViewById(R.id.title_text)).setText(title);
		((ImageView) rootView.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) rootView.findViewById(R.id.head_info)).setVisibility(View.VISIBLE);
		((ImageView) rootView.findViewById(R.id.iv_back)).setBackgroundResource(leftPic);
		((ImageView) rootView.findViewById(R.id.head_info)).setBackgroundResource(rightPic);
		LinearLayout lvBack = (LinearLayout) rootView.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(leftListen);
		LinearLayout rback = (LinearLayout) rootView.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(rightListen);
	}

	/**
	 * 左右自定义图片和监听
	 *
	 * @param title 标题
	 */
	public static void titleBothIconListener(Activity activity, String title, OnClickListener leftListen, int rightPic, OnClickListener rightListen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.head_info)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((ImageView) activity.findViewById(R.id.head_info)).setBackgroundResource(rightPic);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(leftListen);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(rightListen);
	}
	/**
	 * 带左边返回按钮监听事件，右边自定义图片和监听事件
	 *
	 * @param title 标题
	 */
	public static void titleBackListenerWithRightIconListener(Activity activity, String title, OnClickListener leftListen, int rightPic,
											MyOnClickListener rightListen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.head_info)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((ImageView) activity.findViewById(R.id.head_info)).setBackgroundResource(rightPic);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(leftListen);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(rightListen);
	}
	/**
	 * 带左边返回按钮监听事件，右边自定义文字和监听事件
	 *
	 *
	 * @param title 标题
	 */
	public static void titleBackListenerWithRightTextListener(Activity activity, String title, OnClickListener leftListen, String rightText,
			OnClickListener rightListen) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
		((ImageView) activity.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) activity.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((TextView) activity.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout lvBack = (LinearLayout) activity.findViewById(R.id.ler_back);
		lvBack.setVisibility(View.VISIBLE);
		lvBack.setOnClickListener(leftListen);
		LinearLayout rback = (LinearLayout) activity.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(rightListen);
	}

	public static void init(Activity activity, String s1, String s2, OnClickListener rightListen) {
		titleBackKeyWithRightTextViewListener(activity, s1, s2, rightListen);
	}

	public static void init(Activity activity, String s1) {
		titleBackKey(activity, s1);
	}

	/**
	 * fragment 只有标题
	 *
	 * @param title
	 */
	public static void title(View view, String title) {
		((TextView) view.findViewById(R.id.title_text)).setText(title);
	}

	/**
	 * 只有标题
	 *
	 * @param title
	 */
	public static void title(Activity activity, String title) {
		((TextView) activity.findViewById(R.id.title_text)).setText(title);
	}
	public static void titleBothListener(final Activity act, String title, String rightText,
										   OnClickListener listen) {
		// act.requestWindowFeature(Window.FEATURE_NO_TITLE);
		((TextView) act.findViewById(R.id.title_text)).setText(title);
		((ImageView) act.findViewById(R.id.iv_back)).setVisibility(View.VISIBLE);
		((ImageView) act.findViewById(R.id.iv_back)).setBackgroundResource(R.mipmap.header_back);
		((TextView) act.findViewById(R.id.head_right_tv)).setText(rightText);
		LinearLayout rback = (LinearLayout) act.findViewById(R.id.ler_save);
		rback.setVisibility(View.VISIBLE);
		rback.setOnClickListener(listen);
		LinearLayout bback = (LinearLayout) act.findViewById(R.id.ler_back);
		bback.setVisibility(View.VISIBLE);
		bback.setOnClickListener(listen);
	}
}

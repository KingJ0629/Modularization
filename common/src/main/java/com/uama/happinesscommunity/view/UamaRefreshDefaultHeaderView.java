package com.uama.happinesscommunity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.uama.happinesscommunity.common.R;

public class UamaRefreshDefaultHeaderView extends RelativeLayout implements UamaRefreshLayout.UpdateHandler {
    
    private final ImageView mImageView;
    private final View mProgress;
    private TextView mTextView;
    private static final String TAG = "DefaultHeaderView";

    public UamaRefreshDefaultHeaderView(Context context) {
        this(context, null);
    }

    public UamaRefreshDefaultHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.default_header_layout, this, true);
        mTextView = (TextView) findViewById(R.id.text);
        mImageView = (ImageView) findViewById(R.id.image);
        mProgress = findViewById(R.id.progress);
    }

    //箭头是否朝上
    private boolean arrowUp;

    @Override
    public void onProgressUpdate(UamaRefreshLayout layout, UamaRefreshLayout.Progress progress, int status) {

        Log.i("msg", (progress.getCurrentY() * 100) / (progress.getRefreshY()) + "   ___");

        switch (status) {
            case UamaRefreshLayout.STATUS_INIT:
                mImageView.setVisibility(VISIBLE);
                mImageView.setImageResource(R.mipmap.arrow_down);
                mProgress.setVisibility(GONE);
                break;

            case UamaRefreshLayout.STATUS_DRAGGING:
                if (progress.getCurrentY() >= progress.getRefreshY()) {
                    if (arrowUp) {
                        arrowUp = false;
                        mTextView.setText(R.string.release_to_refresh);
                        mImageView.setImageResource(R.mipmap.arrow_up);
                    }
                } else {
                    if (!arrowUp) {
                        arrowUp = true;
                        mTextView.setText(R.string.pull_to_refresh);
                        mImageView.setImageResource(R.mipmap.arrow_down);
                    }
                }
                break;
            case UamaRefreshLayout.STATUS_RELEASE_PREPARE:
                mTextView.setText(R.string.begin_refresh);
                mImageView.setVisibility(GONE);
                break;
            case UamaRefreshLayout.STATUS_REFRESHING:
                mTextView.setText(R.string.refreshing);
                mImageView.setImageResource(android.R.drawable.btn_dropdown);
                mProgress.setVisibility(VISIBLE);
                break;
            case UamaRefreshLayout.STATUS_COMPLETE:
                mTextView.setText(R.string.refresh_complete);
                mProgress.setVisibility(GONE);
                mImageView.setVisibility(VISIBLE);
                mImageView.setImageResource(R.mipmap.okey);
                break;
            case UamaRefreshLayout.STATUS_RELEASE_CANCEL:
                mTextView.setText(R.string.cancel_refresh);
                break;
        }
    }
}

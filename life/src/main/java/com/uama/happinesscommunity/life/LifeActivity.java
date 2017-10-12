package com.uama.happinesscommunity.life;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jin
 */
public class LifeActivity extends AppCompatActivity {

//	private static final String ARG_PARAM1 = "param";
//	@BindView(R2.id.iv_back)
//	ImageView mIvBack;
//	@BindView(R2.id.head_left_tv)
//	TextView mHeadLeftTv;
//	@BindView(R2.id.ler_back)
//	LinearLayout mLerBack;
//	@BindView(R2.id.title_text)
//	TextView mTitleText;
//	@BindView(R2.id.head_info)
//	ImageView mHeadInfo;
//	@BindView(R2.id.head_right_tv)
//	TextView mHeadRightTv;
//	@BindView(R2.id.ler_save)
//	LinearLayout mLerSave;
//	@BindView(R2.id.recyclerView)
//	RecyclerView mRecyclerView;
//	@BindView(R2.id.wei_dian)
//	ImageView mWeiDian;
//	@BindView(R2.id.wei_dian_layout)
//	LinearLayout mWeiDianLayout;
	
	//    private LifeIndexPreAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.life_layout);
		ButterKnife.bind(this);
		
		Log.i("msg", "LifeActivity class");
		
		findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("msg", "LifeActivity2");
				ARouter.getInstance().build("/wallet/WalletActivity").navigation();
			}
		});
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		
		
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_size_smallest);
//        recyclerView.addItemDecoration(new SpaceItemBottomDecoration(spacingInPixels));
//        mAdapter = new LifeIndexPreAdapter(mContext, null);
//        recyclerView.setAdapter(mAdapter);
//
//        weiDian.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //进入微店
//                qStartActivity(MicroShopListActivity.class);
//            }
//        });
//
//        loadData();
	}
	
	@OnClick(R2.id.layout)
	public void click() {
		Log.i("msg", "LifeActivity");
		ARouter.getInstance().build("/wallet/WalletActivity").navigation();
	}
		

//    private List<LifeIndexResp.DataBean> list1, list2;
	
	public void loadData() {
//        list1 = new ArrayList<>();
//        list2 = new ArrayList<>();
//
//        LifeApiClient.lifeIndex(getActivity(), new Callback<LifeIndexResp>() {
//            @Override
//            public void onResponse(Call<LifeIndexResp> call, Response<LifeIndexResp> response) {
//                try {
//                    if (null != response.body())
//                        if (response.body().getStatus().equalsIgnoreCase(ApiClient.SUCCESS)) {
//
//                            List<LifeIndexResp.DataBean> list = response.body().getData();
//
//                            for (LifeIndexResp.DataBean bean : list) {
//                                if (bean.getType() == 1) {
//                                    list1.add(bean);
//                                } else if (bean.getType() == 2) {
//                                    list2.add(bean);
//                                }
//                            }
//
//                            mAdapter.setNewData(list1);
//                            weiDianlayout.setVisibility(list2.size() == 0 ? View.GONE : View.VISIBLE);
//                        } else {
//                            ToastUtil.showLong(mContext, response.body().getMsg());
//                        }
//                } catch (Exception e) {}
//            }
//
//            @Override
//            public void onFailure(Call<LifeIndexResp> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
		
	}
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ((ViewGroup) rootView.getParent()).removeView(rootView);
//        ButterKnife.unbind(this);
//    }
}
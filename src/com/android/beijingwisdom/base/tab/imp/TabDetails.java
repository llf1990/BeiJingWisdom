package com.android.beijingwisdom.base.tab.imp;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.beijingwisdom.base.BaseTabDetailPager;
import com.android.beijingwisdom.domain.NewsMenu.NewsClassify;

public class TabDetails extends BaseTabDetailPager {
	private static final String TAG = "TabDetails";
	public NewsClassify classify;
	public TextView tv;
	public TabDetails(Activity activity, NewsClassify classify) {
		super(activity);
		this.classify = classify;
		Log.i(TAG, this.classify.toString());
		initData();
	}

	@Override
	public View initView() {
		tv = new TextView(mActivty);
//		Log.i(TAG, tv.toString());
		
		return tv;
	}
	@Override
	public void initData() {
		Log.i(TAG, classify.title);
		tv.setText(classify.title);
	}
}

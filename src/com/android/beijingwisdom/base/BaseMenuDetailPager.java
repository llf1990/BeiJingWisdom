package com.android.beijingwisdom.base;

import android.app.Activity;
import android.view.View;

public abstract class BaseMenuDetailPager {
	protected Activity mActivity;
	public View mRootView;
	public BaseMenuDetailPager(Activity activity) {
		this.mActivity = activity;
		mRootView = initView();
	}
	//初始化布局子类必须实现
	public abstract View initView();
	//初始化数据
	public void initData(){
		
	}
}

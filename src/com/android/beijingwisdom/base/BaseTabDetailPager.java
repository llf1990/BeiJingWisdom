package com.android.beijingwisdom.base;

import android.app.Activity;
import android.view.View;

public abstract class BaseTabDetailPager {
	public Activity mActivty;
	public View mRootView;
	public BaseTabDetailPager(Activity activity) {
		this.mActivty = activity;
		mRootView = initView();
	}
	public abstract View initView() ;
	
	public void initData(){
		
	}

}

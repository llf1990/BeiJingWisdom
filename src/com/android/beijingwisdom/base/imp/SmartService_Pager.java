package com.android.beijingwisdom.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.android.beijingwisdom.base.BasePager;

public class SmartService_Pager extends BasePager {

	public SmartService_Pager(Activity mActivity) {
		super(mActivity);
		
	}
	
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		TextView view = new TextView(mActivity);
		view.setText("智慧服务");
		view.setTextColor(Color.RED);
		view.setGravity(Gravity.CENTER);
		fl_content.addView(view);
		tv_title.setText("生活");
	}
}
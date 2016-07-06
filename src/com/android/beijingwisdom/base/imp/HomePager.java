package com.android.beijingwisdom.base.imp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.android.beijingwisdom.base.BasePager;

public class HomePager extends BasePager {

	private static final String TAG = "HomePager";

	public HomePager(Activity mActivity) {
		super(mActivity);
	}
	
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		TextView view = new TextView(mActivity);
		view.setText("Ê×Ò³");
		view.setTextColor(Color.RED);
		view.setGravity(Gravity.CENTER);
		fl_content.addView(view);
		tv_title.setText("ÖÇ»Û±±¾©");
	}
}
package com.android.beijingwisdom.base.menu.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.android.beijingwisdom.base.BaseMenuDetailPager;
/**
 * 互动详情页
 * @author feng
 *
 */
public class InteractMenuDetail extends BaseMenuDetailPager {

	public InteractMenuDetail(Activity activity) {
		super(activity);
		
	}

	@Override
	public View initView() {
		TextView view = new TextView(mActivity);
		view.setText("互动详情页");
		view.setTextColor(Color.RED);
		view.setGravity(Gravity.CENTER);
		return view;
	}

}

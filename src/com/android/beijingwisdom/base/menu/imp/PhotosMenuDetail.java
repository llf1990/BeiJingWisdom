package com.android.beijingwisdom.base.menu.imp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.android.beijingwisdom.base.BaseMenuDetailPager;
/**
 * ×éÍ¼ÏêÇéÒ³
 * @author feng
 *
 */
public class PhotosMenuDetail extends BaseMenuDetailPager {

	public PhotosMenuDetail(Activity activity) {
		super(activity);
		
	}

	@Override
	public View initView() {
		TextView view = new TextView(mActivity);
		view.setText("×éÍ¼ÏêÇéÒ³");
		view.setTextColor(Color.RED);
		view.setGravity(Gravity.CENTER);
		return view;
	}

}

package com.android.beijingwisdom.base;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.activity.HomeActivity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class BasePager {
	public Activity mActivity;
	public TextView tv_title;
	public ImageButton ib_menu;
	public FrameLayout fl_content;
	
	public View curView;//当前view对象
	
	public BasePager(Activity mActivity){
		this.mActivity = mActivity;
		curView = initView();
	}
	/**
	 * 初始化布局
	 * @return
	 */
	public View initView(){
		View view = View.inflate(mActivity , R.layout.base_pager , null);
		tv_title = (TextView) view.findViewById(R.id.tv_title);
		ib_menu =  (ImageButton) view.findViewById(R.id.ib_menu);
		ib_menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				switchLeft();
			}
		});
		fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
		return view;
	}
	//侧边栏开关
	public void switchLeft() {
		HomeActivity mainUI = (HomeActivity) mActivity;
		mainUI.getSlidingMenu().toggle();
	}
	public void initData(){};
}

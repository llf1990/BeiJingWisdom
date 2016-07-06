package com.android.beijingwisdom.base;

import com.android.beijingwisdom.R;

import android.app.Activity;
import android.view.View;
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
		fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
		System.out.println("initview调用");
		return view;
	}
	
	public void initData(){};
}

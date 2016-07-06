package com.android.beijingwisdom.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScorllViewPager extends ViewPager {

	public NoScorllViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public NoScorllViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		//重写ontouchevent,禁用屏幕滑动事件，通过导航栏点击切换页面
		return true;
	}

}

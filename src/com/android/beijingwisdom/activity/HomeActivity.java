package com.android.beijingwisdom.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.fragment.BaseFragment;
import com.android.beijingwisdom.fragment.LeftMenuFragment;
import com.android.beijingwisdom.fragment.MainMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class HomeActivity extends  SlidingFragmentActivity{
	public static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
	public static final String TAG_MAIN_MENU = "TAG_MAIN_MENU";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home_main);
		
		//设置左侧边栏
		setBehindContentView(R.layout.activity_home_left);
		SlidingMenu slidingMenu = getSlidingMenu();//获得slidingmenu对象
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//设置全屏触摸
		slidingMenu.setBehindOffset(400);//设置屏幕预留200像素
		initFragment();
	}
	
	private void initFragment(){
		FragmentManager fm = getSupportFragmentManager();//版本兼容
		FragmentTransaction transaction = fm.beginTransaction();//开启事务
		transaction.replace(R.id.fl_main, new MainMenuFragment(),TAG_MAIN_MENU);
		transaction.replace(R.id.fl_left, new LeftMenuFragment(),TAG_LEFT_MENU);
		transaction.commit();//提交事务
	}
	
	public BaseFragment getMenuFragment(String TAG){
		FragmentManager fm = getSupportFragmentManager();
		BaseFragment fragment =  (BaseFragment) fm.findFragmentByTag(TAG);
		return fragment;
	}
}

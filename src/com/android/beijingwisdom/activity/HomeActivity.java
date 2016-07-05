package com.android.beijingwisdom.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.fragment.LeftMenuFragment;
import com.android.beijingwisdom.fragment.MainMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class HomeActivity extends  SlidingFragmentActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home_main);
		
		//ÉèÖÃ×ó²à±ßÀ¸
		setBehindContentView(R.layout.activity_home_left);
		SlidingMenu slidingMenu = getSlidingMenu();//»ñµÃslidingmenu¶ÔÏó
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//ÉèÖÃÈ«ÆÁ´¥Ãş
		slidingMenu.setBehindOffset(500);//ÉèÖÃÆÁÄ»Ô¤Áô200ÏñËØ
		initFragment();
	}
	
	private void initFragment(){
		FragmentManager fm = getSupportFragmentManager();//°æ±¾¼æÈİ
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.fl_main, new MainMenuFragment());
		transaction.replace(R.id.fl_left, new LeftMenuFragment());
		transaction.commit();
	}
}

package com.android.beijingwisdom.activity;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.utils.SPUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
	
	private RelativeLayout rl_splash_root;
	private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        /**
         * 旋转动画,围绕自身中心旋转360
         */
        RotateAnimation rotaani = new RotateAnimation(0, 360, 
        		Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotaani.setDuration(1000);
        rotaani.setFillAfter(true);
        /**
         * 缩放动画
         */
        ScaleAnimation scaleani = new ScaleAnimation(0, 1,0, 1, 
        		Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleani.setDuration(1000);
        scaleani.setFillAfter(true);
        
        /**
         * 渐变动画
         */
        AlphaAnimation alphaani = new AlphaAnimation( 0, 1);
        alphaani.setDuration(2000);
        alphaani.setFillAfter(true);
        
        /**
         * 动画集合
         */
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotaani);
        set.addAnimation(scaleani);
        set.addAnimation(alphaani);
        
        rl_splash_root.startAnimation(set);
        
        set.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				//动画播放完毕判断用户是否第一次进入使用
				boolean isFirstEnter = SPUtil.getBoolean(sp, "isFirstEnter", true);
				Intent intent	;
				if(isFirstEnter){
					//进入新手引导页面，并将isFirstEnter置为false
					intent = new Intent(SplashActivity.this,GuideActivtiy.class);
					startActivity(intent);
					SPUtil.setBoolean(sp,"isFirstEnter", true);
				}else{
					//进入主页面
					intent = new Intent(SplashActivity.this,HomeActivity.class);
					startActivity(intent);
				}
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }
    
}

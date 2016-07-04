package com.android.beijingwisdom.activity;

import com.android.beijingwisdom.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.AlphabetIndexer;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
	
	private RelativeLayout rl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);
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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }
    
}

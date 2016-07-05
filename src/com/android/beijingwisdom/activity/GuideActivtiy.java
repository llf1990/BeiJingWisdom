package com.android.beijingwisdom.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.utils.SPUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 用户第一次使用APP使用该功能，进入新手引导
 * 
 * @author feng
 * 
 */
public class GuideActivtiy extends Activity {

	private ViewPager vp_guide;
	private List<ImageView> imagelist;
	private GuideAdapter adapter;
	private Button btn_start;
	private SharedPreferences sp;
	private LinearLayout ll_container;
	private int prvPosition = 0;// 当前postion的前一个位置
	// 引导页图片
	private int[] guidePage = new int[] { R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		sp = getSharedPreferences("config", MODE_PRIVATE);
		vp_guide = (ViewPager) findViewById(R.id.vp_guide);
		ll_container = (LinearLayout) findViewById(R.id.ll_container);
		btn_start = (Button) findViewById(R.id.btn_start);
		InitData();
		adapter = new GuideAdapter();
		vp_guide.setAdapter(adapter);

		vp_guide.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				System.out.println(position + ":" + prvPosition);
				ll_container.getChildAt(position).setEnabled(true);
				ll_container.getChildAt(prvPosition).setEnabled(false);
				prvPosition = position;
			}

			@Override
			public void onPageSelected(int position) {
				if(position == imagelist.size() -1 ){
					btn_start.setVisibility(View.VISIBLE);
				}else{
					btn_start.setVisibility(View.INVISIBLE);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub

			}

		});
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//更新sp,已经不是第一次进入
				SPUtil.setBoolean(sp, "isFirstEnter", false);
				Intent intent = new Intent(GuideActivtiy.this,HomeActivity.class);
				startActivity(intent);
			}
		});
	}

	private void InitData() {
		// 初始化viewpager图片
		prvPosition = 0;
		imagelist = new ArrayList<ImageView>();
		ImageView iv_guide_page;
		ImageView point;
		LinearLayout.LayoutParams params;
		for (int i = 0; i < guidePage.length; i++) {
			iv_guide_page = new ImageView(this);
			iv_guide_page.setBackgroundResource(guidePage[i]);
			imagelist.add(iv_guide_page);

			// 初始化小圆点
			point = new ImageView(this);
			point.setImageResource(R.drawable.point_selector);
			// 初始化父空间参数，宽高
			params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			if (i > 0) {
				params.leftMargin = 10;
			}
			point.setLayoutParams(params);// 设置布局参数
			point.setEnabled(false);
			ll_container.addView(point);// 小圆点添加到线性布局
		}
//		ll_container.getChildAt(prvPosition).setEnabled(true);
	}

	class GuideAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			return imagelist.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		/**
		 * 初始化item布局
		 * @param container
		 * @param position
		 * @return
		 */
		public Object instantiateItem(android.view.ViewGroup container,
				int position) {
			ImageView view = imagelist.get(position);
			container.addView(view);
			return view;

		};

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((View) object);
		}

	}
}

package com.android.beijingwisdom.base.menu.imp;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.base.BaseMenuDetailPager;
import com.android.beijingwisdom.base.BaseTabDetailPager;
import com.android.beijingwisdom.base.tab.imp.TabDetails;
import com.android.beijingwisdom.domain.NewsMenu.NewsClassify;
import com.android.beijingwisdom.domain.NewsMenu.NewsLeftMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
/**
 * ÐÂÎÅÏêÇéÒ³
 * @author feng
 *
 */
public class NewsMenuDetail extends BaseMenuDetailPager {
	private static final String TAG = "NewsMenuDetail";
	private ArrayList<NewsClassify> children;
	private ArrayList<TabDetails> mtabs;
	
	private ViewPager vp_topics;
	public NewsMenuDetail(Activity activity, ArrayList<NewsClassify> children) {
		super(activity);
		this.children = children;
	}
	@Override
	public void initData() {
		mtabs = new ArrayList<TabDetails>();
		for (NewsClassify classify : children) {
			Log.i(TAG, classify.toString());
			BaseTabDetailPager basetabpager = new TabDetails(mActivity,classify) ;
			mtabs.add((TabDetails) basetabpager);
		}
		
		vp_topics.setAdapter(new NewsDetailAdapter());
	}
	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.pager_news_detail, null);
		vp_topics = (ViewPager) view.findViewById(R.id.vp_topics);
		return view;
	}
	
	class NewsDetailAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			Log.i(TAG,""+mtabs.size());
			return mtabs.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			TabDetails details = mtabs.get(position);
			Log.i(TAG, details.classify.toString());
			View view = details.mRootView;
			Log.i(TAG, "view"+view.toString());
			container.addView(view);
			
			return view;
		}
	}

}

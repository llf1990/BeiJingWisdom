package com.android.beijingwisdom.base.imp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.beijingwisdom.activity.HomeActivity;
import com.android.beijingwisdom.base.BaseMenuDetailPager;
import com.android.beijingwisdom.base.BasePager;
import com.android.beijingwisdom.base.menu.imp.InteractMenuDetail;
import com.android.beijingwisdom.base.menu.imp.NewsMenuDetail;
import com.android.beijingwisdom.base.menu.imp.PhotosMenuDetail;
import com.android.beijingwisdom.base.menu.imp.TopicMenuDetail;
import com.android.beijingwisdom.domain.NewsMenu;
import com.android.beijingwisdom.domain.NewsMenu.NewsLeftMenu;
import com.android.beijingwisdom.fragment.LeftMenuFragment;
import com.android.beijingwisdom.global.GlobalConstants;
import com.android.beijingwisdom.utils.CacheUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class Newscenter_Pager extends BasePager {
	private static final String TAG = "Newscenter_Pager";
	public SharedPreferences sp;
	private ArrayList<BaseMenuDetailPager> menuDetails;//详情页对象的集合
	private  ArrayList<NewsLeftMenu> itemData;
	public Newscenter_Pager(Activity mActivity) {
		super(mActivity);
		
	}
	
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
		
		sp = mActivity.getSharedPreferences("config", mActivity.MODE_PRIVATE);
		//判断是否有缓存
		String cache = CacheUtils.getCache(GlobalConstants.CATEGORY_URL, sp);
		if(TextUtils.isEmpty(cache)){
			//初始化时请求服务器获取新闻资源
			getDataFromServer();
		}else{
			//已有缓存，直接处理数据
			System.out.println("读取缓存直接加载。。。。");
			processJson(cache);
		}
		
	}
	/**
	 * 从服务器获取数据
	 */
	private void getDataFromServer() {
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, GlobalConstants.CATEGORY_URL, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				//请求成功
				String result = responseInfo.result;
				System.out.println(result);
				processJson(result);
				CacheUtils.setCache(sp, GlobalConstants.CATEGORY_URL, result);
			}

			

			@Override
			public void onFailure(HttpException error, String msg) {
				//请求失败
				error.printStackTrace();
				Toast.makeText(mActivity, msg, 0).show();
			}
		});
		
	}
	protected void processJson(String json) {
		Gson gson  = new Gson();
		NewsMenu newdata = gson.fromJson(json, NewsMenu.class);
		System.out.println(newdata.retcode);
		
		HomeActivity mainUI = (HomeActivity) mActivity;
		LeftMenuFragment leftfragment = (LeftMenuFragment) mainUI.getMenuFragment(mainUI.TAG_LEFT_MENU);
		//给侧边栏设置数据
		itemData = newdata.data;
		leftfragment.setMenuData(itemData);
		//初始化详情页集合
		menuDetails = new ArrayList<BaseMenuDetailPager>();
		menuDetails.add(new NewsMenuDetail(mActivity,itemData.get(0).children));
		
//		Log.i(TAG,itemData.get(0).children.toString());
		
		menuDetails.add(new TopicMenuDetail(mActivity));
		menuDetails.add(new PhotosMenuDetail(mActivity));
		menuDetails.add(new InteractMenuDetail(mActivity));
		//默认加载新闻中心详情页
		setCurrentDetailPager(0);
		
	}
	//设置菜单详情页
	public void  setCurrentDetailPager(int position){
		//重新给framelayout添加内容
		BaseMenuDetailPager detailpager = menuDetails.get(position);
		View view = detailpager.mRootView;
		//清楚之前添加的布局
		fl_content.removeAllViews();
		fl_content.addView(view);
		//初始化页面数据
		detailpager.initData();
		//更新标题
		tv_title.setText(itemData.get(position).title);
	}
}
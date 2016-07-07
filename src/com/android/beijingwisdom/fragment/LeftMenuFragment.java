package com.android.beijingwisdom.fragment;

import java.util.ArrayList;

import com.android.beijingwisdom.R;
import com.android.beijingwisdom.activity.HomeActivity;
import com.android.beijingwisdom.base.imp.Newscenter_Pager;
import com.android.beijingwisdom.domain.NewsMenu.NewsLeftMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 主页面activity
 * @author feng
 *
 */
public class LeftMenuFragment extends BaseFragment {
	private ArrayList<NewsLeftMenu> newsLeftitems;
	@ViewInject(R.id.lv_leftmenu_items)
	private ListView lv_leftmenu_items;
	private int currentPos;
	LeftMenuAdapter adapter;
	
	@Override
	public View initView() {
		adapter = new LeftMenuAdapter();
		View view = View.inflate(mActivity,R.layout.fragment_home_left ,null);
		//lv_leftmenu_items = (ListView) view.findViewById(R.id.lv_leftmenu_items);
		ViewUtils.inject(this, view);
		lv_leftmenu_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				currentPos = position;//更新选中的位置
				adapter.notifyDataSetChanged();//通知选择器更新
				//收起侧边栏
				switchLeft();
				//点击变更framelayout内容
				setCurrentDetail(position);
			}

			
			
		});
		return view;
	}
	//侧边栏开关
	public void switchLeft() {
		HomeActivity mainUI = (HomeActivity) mActivity;
		mainUI.getSlidingMenu().toggle();
	}
	//获取当前侧边栏标题详情页
	public void setCurrentDetail(int position){
		//获取新闻中心对象
		HomeActivity mainUI = (HomeActivity) mActivity;
		//获取MainMenuFragment
		MainMenuFragment mainFragment = (MainMenuFragment) mainUI.getMenuFragment(mainUI.TAG_MAIN_MENU);
		//获取新闻中心对象,索引为1，
		Newscenter_Pager newscenter = (Newscenter_Pager) mainFragment.getBasePager(1);
		//设置新闻中心详情页
		newscenter.setCurrentDetailPager(position);
	}
	
	@Override
	public void initData() {
		
	}
	class LeftMenuAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return newsLeftitems.size();
		}

		@Override
		public NewsLeftMenu getItem(int position) {
			return newsLeftitems.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(mActivity, R.layout.item_list_menu_left, null);
			TextView  item = (TextView) view.findViewById(R.id.tv_menu_left);
			item.setText(getItem(position).title);
			//默认选中第一个图片文字显示红色
			if(currentPos == position){
				item.setEnabled(true);
			}else{
				item.setEnabled(false);//其他默认显示白色
			}
			
			return view;
		}
		
	}
	public void setMenuData(ArrayList<NewsLeftMenu> data) {
		currentPos = 0;
		newsLeftitems = data;
		lv_leftmenu_items.setAdapter(adapter);
	}

}

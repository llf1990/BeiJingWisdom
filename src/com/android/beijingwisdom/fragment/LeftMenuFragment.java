package com.android.beijingwisdom.fragment;

import com.android.beijingwisdom.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * Ö÷Ò³Ãæactivity
 * @author feng
 *
 */
public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView() {
		View view = View.inflate(mActivity,R.layout.fragment_home_left ,null);
		return view;
	}

	@Override
	public void initData() {
		
	}
	class LeftMenuAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
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
			return view;
		}
		
	}

}

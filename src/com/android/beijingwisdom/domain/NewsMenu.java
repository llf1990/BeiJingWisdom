package com.android.beijingwisdom.domain;

import java.util.ArrayList;

/**
 * json∂‘œÛ¥Ê¥¢
 * @author feng
 *
 */
public class NewsMenu {
	
	public int retcode;
	public ArrayList<Integer> extend;	
	public ArrayList<NewsLeftMenu>code;
	
	class NewsLeftMenu{
		public int id;
		public String title;
		public int type;
		public ArrayList<NewsClassify> children;
	}
	
	class NewsClassify{
		public int id;
		public String title;
		public int type;
		public String url;
	}
	
}

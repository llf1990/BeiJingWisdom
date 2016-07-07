package com.android.beijingwisdom.utils;

import android.content.SharedPreferences;

public class CacheUtils {
	/**
	 * 设置缓存
	 * @param url 作为key
	 * @param json 作为value 与url 一一对应
	 */
	public static void setCache(SharedPreferences sp,String url,String json){
		SPUtil.setString(sp, url, json);
	}
	/**
	 * 获取缓存
	 * @param url
	 * @param sp
	 * @return
	 */
	public static String getCache(String url,SharedPreferences sp){
		return SPUtil.getString(sp, url, null);
	}
	
}

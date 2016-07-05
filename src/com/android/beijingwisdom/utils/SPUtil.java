package com.android.beijingwisdom.utils;

import android.content.SharedPreferences;

public class SPUtil {
	
	public static boolean getBoolean(SharedPreferences sp ,String key,boolean defvalue){
		
		return sp.getBoolean(key, defvalue);
		
	}
	
	public static void setBoolean(SharedPreferences sp ,String key,boolean value){
		
		sp.edit().putBoolean(key, value).commit();
		
	}
	
	public static String getString(SharedPreferences sp ,String key,String defvalue){
		
		return sp.getString(key, defvalue);
		
	}
	
	public static void setString(SharedPreferences sp ,String key,String value){
		
		sp.edit().putString(key, value).commit();
		
	}
}

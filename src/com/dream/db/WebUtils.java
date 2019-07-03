package com.dream.db;

public class WebUtils {
	/**
	 * 在request作用域中查找参数key的值，如果key不存在那么返回默认值
	 * @param request
	 * @param defaultValue
	 * @param key
	 * @return
	 */
	public static int StringToInt(String str, int defaultValue) {
		try {
			int i = Integer.parseInt(str);
			return i;
		} catch (Exception e) {
           return defaultValue;
		}
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
			return true;
		}
		return false;
	}
}

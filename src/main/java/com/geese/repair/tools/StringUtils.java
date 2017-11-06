package com.geese.repair.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**  
 * @Description	字符串处理工具类
 * @author		buffter-fly
 * @date	    2017年10月9日 上午9:14:19  
 */  
public final class StringUtils {

	
	/**
	 * @Description 获取字符串长度
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:15:29 
	 * @param str
	 * @return
	 */
	public static int getRealLength(String str) {
		return getRealLength(str, "UTF-8");
	}

	
	/**
	 * @Description 获取字符串长度
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:15:26 
	 * @param str
	 * @param charsetName
	 * @return
	 */
	public static int getRealLength(String str, String charsetName) {
		str = nullToStrTrim(str);
		if (isEmpty(str)) {
			return 0;
		}
		try {
			return str.getBytes(charsetName).length;
		} catch (UnsupportedEncodingException e) {
			return 0;
		}
	}

	
	/**
	 * @Description 校验是否为空
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:15:17 
	 * @param str
	 * @return
	 */
	public static String nullToStrTrim(String str) {
		if (str == null) {
			str = "";
		}
		return str.trim();
	}

	
	/**
	 * @Description 校验是否为空
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:15:07 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.trim().length() == 0));
	}

	
	/**
	 * @Description 校验是否为空
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:14:56 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return ((str != null) && (str.trim().length() > 0));
	}

	
	/**
	 * @Description 编码处理
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:14:46 
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		return encode(str, "UTF-8");
	}

	
	/**
	 * @Description 编码处理
	 * 
	 * @author buffter-fly
	 * @date 2017年10月9日 上午9:14:37 
	 * @param str
	 * @param enc
	 * @return
	 */
	public static String encode(String str, String enc) {
		String strEncode = "";
		try {
			if (str != null)
				strEncode = URLEncoder.encode(str, enc);
		} catch (UnsupportedEncodingException e) {
		}
		return strEncode;
	}
}
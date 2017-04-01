package com.walk.management.common.utils;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	/**
	 * 截取给定长度的字符串
	 * @param source
	 * @param length
	 * @return
	 */
	public static String getSummary(String source,int length){
		if(StringUtils.isBlank(source)){
			return null;
		}
		if(length == 0){
			length = 30;
		}
		int len = source.length();
		if(len <= length){
			return source;
		}
		StringBuilder sb = new StringBuilder();
		int charLen = 0;
		for(int i=0;i<length;i++){
			int asciiCode = source.codePointAt(i);
			if(asciiCode >= 0 && asciiCode <= 255){
				charLen += 1;
			}else{
				charLen += 2;
			}
			if(charLen <= length){
				sb.append(source.charAt(i));
			}else{
				break;
			}
		}
		
		return length >= len ? sb.toString() : sb.append("...").toString();
	}
	
	public static void main(String[] args){
		String test = "你好吗？你现在生活的\n好吗？有";
		String newString = getSummary(test,14);
		System.out.println(newString);
	}
}


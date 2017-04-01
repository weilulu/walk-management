package com.walk.management.common.utils;
import java.text.*;
import java.util.Date;

public class TimeUtils {

	public static String getNowTimeString(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String timeString = sdf.format(new Date());
		return timeString;
	}
	public static void main(String[] args){
		TimeUtils.getNowTimeString("yyyy-MM-dd HH:mm:ss");
	}
}

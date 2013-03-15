package com.lee.study.itcastoa.service.util;

public class OAServiceUtils {
	
	public static String arrayToStr(Long[] pids){
		StringBuffer sb = new StringBuffer();
		if (pids.length != 0) {
			for (Long pid : pids) {
				sb.append(pid.toString()).append(",");
			}
		}
		
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	

}

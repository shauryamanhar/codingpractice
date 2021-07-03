package com.shaurya.gfg.dp;

public class ValidateIP {

	public static void main(String[] args) {
		String ip = "111111111111";
		System.out.println(validate(ip));
	}
	static boolean validate(String ip) {
		boolean blockComplete=false;
		String str = "";
		int end=0,i=0;
		while(end<ip.length()) {
			if(ip.charAt(end)=='.') {
				if(blockComplete==true) {
					return false;
				}
				if(!val(str)) {
					return false;
				}
				str="";
				blockComplete=true;
				i++;
			}else {
				str=str+ip.charAt(end);
				blockComplete=false;
			}
			end++;
		}
		System.out.println(str);
		if(!val(str)) {
			return false;
		}else {
			i++;
		}
		return i==4;
	}
	static boolean val(String str) {
		return !str.isEmpty() && str.length()<3 && Integer.valueOf(str)>=0 && Integer.valueOf(str)<=255;
	}

}

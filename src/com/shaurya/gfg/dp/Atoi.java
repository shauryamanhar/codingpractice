package com.shaurya.gfg.dp;

public class Atoi {

	public static void main(String[] args) {
		String str = "     -42";
		System.out.println(atoi(str));
	}
	static int atoi(String str){
	    if(str==null) {
	    	return -1;
	    }
	    if(str.isEmpty()) {
	    	return -1;
	    }
	    str = str.trim();
	    System.out.println("str.trim "+str);
	    long value = 0;
	    int i=0;
	    int sign=1;
	    if(str.charAt(0)=='-') {
	    	sign=-1;
	    	i=1;
	    }
	    if(str.charAt(0)=='+') {
	    	sign=1;
	    	i=1;
	    }
	    
	    for(;i<str.length();i++) {
	    	char ch = str.charAt(i);
	    	if(ch<'0' || ch>'9') {
	    		return -1;
	    	}
	    	value = value*10+(ch-'0');
	    	if(sign*value>Integer.MAX_VALUE) {
	    		return Integer.MAX_VALUE;
	    	}
	    	if(sign*value<Integer.MIN_VALUE) {
	    		return Integer.MIN_VALUE;
	    	}
	    }
	    return (int)value*sign;
    }

}

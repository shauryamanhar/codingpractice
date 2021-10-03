package com.shaurya.gfg.string;

public class RecursivelyRemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		String s = "gfg";
		String ans = remove(s);
		System.out.println(ans);
	}
	
	static String remove(String s) {
		String ans = rem(s);
		return ans;
	}
	//keep at least on 1 and for all removal need to maintain last remove char
	static String rem(String s) {
		if(s==null || s.length()==0) {
			return "";
		}
		if(s.length()==1) {
			return s;
		}
		String nodup = "";
		char front = s.charAt(0);
		String remain = rem(s.substring(1));
		if(remain.length()==0) {
			nodup=front+"";
		}else if(remain.length()==0 && remain.length()==1) {
			nodup=front+remain;
		}else if(front==remain.charAt(0)) {
			nodup=front+remain.substring(1);
		}else {
			nodup=front+remain;
		}
		return nodup;
	}
	
}

package com.shaurya.general;

public class StringArrayCombination {

	public static void main(String[] args) {
		String str[] = {"abc","def","ghi","xyzab"};
		stringCombination(str, 0, "");
	}
	static void stringCombination(String ip[],int curr,String partial) {
		if(curr==ip.length) {
			System.out.println(partial);
			return;
		}
		for(int i=0;i<ip[curr].length();i++) {
			stringCombination(ip, curr+1, partial+ip[curr].charAt(i));
		}
	}
}

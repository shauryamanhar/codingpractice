package com.shaurya.leetcode.amazon;

public class Balance1s2s {
	public static void main(String[] args) {
		
	}
	static int maxLenthOfEqual0s1s(String s) {
		int cnt0=0;
		int cnt1=0;
		int i=0,j=0;
		while(i<s.length() && j<s.length()) {
			if(s.charAt(j)=='0') {
				cnt0++;
			}else {
				cnt1++;
			}
		}
		return 0;
	}
}

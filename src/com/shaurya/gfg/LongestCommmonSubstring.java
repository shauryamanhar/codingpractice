package com.shaurya.gfg;

public class LongestCommmonSubstring {
	public static void main(String[] args) {
		String s1 = "abcdgh";
		String s2 = "acdghr";
		System.out.println(lcs(s1, 0, s2, 0, 0));
	}
	static int lcs(String s1,int i,String s2,int j,int count) {
		if(i>=s1.length() || j>=s2.length()) {
			return count;
		}
		
		if(s1.charAt(i)==s2.charAt(j)) {
			count = lcs(s1,i+1,s2,j+1,count+1);
		}else {
			count = Math.max(count, Math.max(lcs(s1,i+1,s2,j,0),lcs(s1,i,s2,j+1,0)));
		}
		return count;
	}
}

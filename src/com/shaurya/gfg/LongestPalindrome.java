package com.shaurya.gfg;

public class LongestPalindrome {
	public static void main(String[] args) {
		String str = "abba";
		int l =0,r= str.length()-1;
//		int ans = longestPalindrome(str, l, r);
//		System.out.println(ans);
		int ans = lp(str,l,r);
		System.out.println(ans);
	}
	
	static final int longestPalindrome(String str,int l,int r) {
		if(l>= str.length() || r<0) {
			return 0;
		}
		if(l>r) {
			return 0;
		}
		if(l==r) {
			return 1;
		}
		if(str.charAt(l)==str.charAt(r)) {
			int remainStringSize = r - l -1;
			if(remainStringSize==longestPalindrome(str, l+1, r-1)) {
				return 2+remainStringSize;
				
			}
		}
		int left = longestPalindrome(str, l+1, r);
		int right = longestPalindrome(str, l, r-1);
		return Math.max(left, right);
	}
	static int lp(String str,int l,int r) {
		if(l>= str.length() || r<0) {
			return 0;
		}
		if(l>r) {
			return 0;
		}
		if(l==r) {
			return 1;
		}
		if(str.charAt(l)==str.charAt(r)) {
			return 1+lp(str,l+1,r-1);
		}
		int left = lp(str, l+1, r);
		int right = lp(str, l, r-1);
		return Math.max(left, right)+1;
	}
	
	static int longestPalindromeDp(String str) {
		int ans = -1;
		int len = str.length();
		int dp[][] = new int[len+1][len+1]; 
		for(int i=1;i<=len;i++) {
			for(int j=1;j<=len;j++) {
				if(str.charAt(i-1)==str.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		ans = dp[len][len];
		return ans;
	}
	
	
}

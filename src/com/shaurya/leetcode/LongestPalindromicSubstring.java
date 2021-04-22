package com.shaurya.leetcode;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "geeks";
//		longestPalindrome(s);
		lp(s);
	}
	
	static public void lp(String c) {
		int len = c.length();
		char s[] = c.toCharArray();
		int dp[][] = new int[len][len];
		for(int i=0;i<len;i++) {
			dp[i][i]=1;
		}
		for(int i=0;i<len-1;i++) {
			dp[i][i+1]=(s[i]==s[i+1]?1:0);
		}
		int max=1;
		System.out.println("max found "+max);
		print(dp);
	}
	static void print(int a[][]) {
		for(int r[]:a) {
			for(int s:r) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}
	
	static public String longestPalindrome(String s) {
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(isPalindrome(s, i, j)) {
					System.out.println(s.substring(i,(j-i+1)));
				}
			}
		}
		return null;
	}
	static boolean isPalindrome(String s,int i,int j) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}

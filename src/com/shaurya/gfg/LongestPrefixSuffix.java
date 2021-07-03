package com.shaurya.gfg;

import java.util.Arrays;

public class LongestPrefixSuffix {

	public static void main(String[] args) {
		String str = "gigummcnu";
		prefixAlsoSuffix(str);
//		prefixAlsoSuffixLessSpace(str);
	}
	static void prefixAlsoSuffix(String s) {
		char ch[] = s.toCharArray();
		boolean hash[] = new boolean[26];
		int lps[] = new int[ch.length];
		int j=0;
		int max =0;
		for(int i=0;i<s.length();i++) {
			if(hash[ch[i]-'a']) {
				System.out.println("already seen "+ch[i]);
				if(ch[j]==ch[i]) {
					System.out.println(" both i and j are equal "+ch[i]);
					lps[i]=j+1;
					j++;
				}else {
					System.out.println("j value reset "+ch[i]);
					lps[i]=0;
					j=0;
				}
			}else {
				hash[ch[i]-'a']=true;
				System.out.println("not seen "+ch[i]);
			}
			max = Math.max(max, j);
		}
		System.out.println("lps "+Arrays.toString(lps));
	}
	static void prefixAlsoSuffixLessSpace(String str) {
		int n = str.length();
		
		int len =0;
		int lps[] = new int[n];
		lps[0]=0;
		
		//start from 2nd element
		int i=1;
		while(i<n) {
			if(str.charAt(i)==str.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0) {
					len = lps[len-1];
				}else {
					lps[i]=len;
					i++;
				}
			}
		}//while
		System.out.println("lps "+Arrays.toString(lps));
	}
}

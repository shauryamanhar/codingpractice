package com.shaurya.leetcode.amazon;

import java.util.ArrayList;

public class NStringCombination {

	public static void main(String[] args) {
		 String str[]= {"ABC","DEF","GHI"};
		 combination(str, 0, 0, new ArrayList<String>());
	}
	static void combination(String str[],int n,int idx,ArrayList<String> partial) {
		if(partial.size()==str.length) {
			System.out.println(partial);
			return;
		}
		if(n>=str.length) {
			return;
		}
		for(int i=0;i<str[n].length();i++) {
			partial.add(str[n].charAt(i)+"");
			combination(str, n+1, idx, partial);
			partial.remove(partial.size()-1);
		}
	}

}

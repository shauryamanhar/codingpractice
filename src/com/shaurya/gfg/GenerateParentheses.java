package com.shaurya.gfg;

import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(allParenthesis(n).size());
	}

	static List<String> allParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		char c[] = new char[2*n];
		generate(c, 0, 0, n, 0, list);
		return list;
	}
	static void generate(char arr[],int lc, int rc,int n,int idx,List<String> list) {
		if(lc==n && rc==n || idx==2*n) {
			list.add(new String(arr));
			return;
		}
		if(lc<n) {
			arr[idx]='(';
			generate(arr, lc+1, rc, n,idx+1,list);
		}
		if(lc>rc && rc<n) {
			arr[idx]=')';
			generate(arr, lc, rc+1, n,idx+1,list);
		}
	}
}

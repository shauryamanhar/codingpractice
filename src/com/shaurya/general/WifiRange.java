package com.shaurya.general;

import java.util.ArrayList;
import java.util.Arrays;

public class WifiRange {

	public static void main(String[] args) {
		int N = 5;
		String s = "10000010";
		int x=2;
		System.out.println(wifiRange(N, s, x));
	}
	static boolean wifiRange(int N,String s,int x) {
		ArrayList<Integer> idxList = new ArrayList<Integer>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				idxList.add(i);
			}
		}
		boolean range[] = new boolean[s.length()];
		for(int idx:idxList) {
			for(int i=0;i<s.length();i++) {
				if(i==idx || Math.abs(i-idx)<=x) {
					range[i]=true;
				}
			}
		}
		for(boolean avail:range) {
			if(avail==false) {
				return false;
			}
		}
		return true;
	}
}

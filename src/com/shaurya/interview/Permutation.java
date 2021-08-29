package com.shaurya.interview;

import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		int a[] = {1,1,2};
		permutation(0, a.length-1, a);
	}
	static void permutation(int idx,int lastIndex,int a[]) {
		if(idx==lastIndex) {
			System.out.println(Arrays.toString(a));
		}else {
			for(int i=idx;i<=lastIndex;i++) {
				//avoid duplicate
				if(i==idx && a[idx]==a[i]) {
					continue;
				}
				swap(i,idx,a);
				permutation(idx+1, lastIndex, a);
				swap(i,idx,a);
			}
		}
	}
	static void swap(int x,int y,int a[]) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}

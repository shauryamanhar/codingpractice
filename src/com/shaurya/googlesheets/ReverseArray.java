package com.shaurya.googlesheets;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		reverse(a);
		System.out.println(Arrays.toString(a));

	}
	static void reverse(int a[]) {
		int l=0,r=a.length-1;
		int temp=0;
		while(l<r) {
			temp = a[l];
			a[l]= a[r];
			a[r] = temp;
			l++;
			r--;
		}
	}

}

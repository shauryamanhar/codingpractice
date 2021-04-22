package com.shaurya.general;

import java.util.Arrays;

public class AmazonMusicQuestion {

	public static void main(String[] args) {
		int a[] = {1,10,25,35,60};
		int ride = 90;
		ride(a,ride);
	}
	
	public static void ride(int a[],int ride) {
		Arrays.sort(a);
		int first=-1;
		int second=-1;
		int l=0,r=a.length-1;
		while(l<r) {
			int sum = a[l]+a[r];
			if(ride-sum==30) {
				System.out.println("l "+a[l]);
				System.out.println("r "+a[r]);
			}
			l++;r--;
		}
	}

}

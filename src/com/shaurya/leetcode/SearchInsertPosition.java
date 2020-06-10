package com.shaurya.leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int a[] = {1,3,5,6};
		searchPosition(a, 7);
	}
	static void searchPosition(int a[],int t) {
		int l = 0,r=a.length;
		int index=-1;
		while(l<=r) {
			int mid = l+(r-l)/2;
			if(mid>=a.length) {
				index=mid;
				break;
			}
			if(a[mid]>=t) {
				index=mid;
				r = mid-1;
			}else {
				l=mid+1;
			}
		}
		System.out.println("index "+index);
	}

}

package com.shaurya.goldman;

public class SearchInRotateBinaryTree {

	public static void main(String[] args) {
		int a[] = {4,5,6,7,8,0,1,2};
		System.out.println(findPivot(a));
	}
	static int findPivot(int a[]) {
		int l=0,r=a.length-1;
		int mid = 0;
		while(l<r) {
			mid = l+(r-l)/2;
			if(mid<a.length && a[mid]<a[mid+1]) {
				l=mid+1;
			}else if(mid>0 && a[mid]<a[mid-1]) {
				r = mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}

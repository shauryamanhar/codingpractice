package com.shaurya.bitmanipulation;

public class AppearsOnce {

	public static void main(String[] args) {
		int a[] = {12,1,12,3,12,1,1,2,3,3};
//		for(int i=0;i<a.length;i++) {
//			System.out.println(BitwiseUtil.toBinary(a[i]));
//		}
		int ans=0;
		ans=ans^12;
		ans=ans^11;
		ans=ans^12;
		ans =ans^12;
		System.out.println(ans);
	}

}

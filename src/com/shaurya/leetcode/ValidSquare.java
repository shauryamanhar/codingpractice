package com.shaurya.leetcode;

public class ValidSquare {

	public static void main(String[] args) {
		long n=808201;
		System.out.println(isPerfect(2,n,n));

	}
	static boolean isPerfect(long l,long r,long num) { 
		if(l>=0 && l<=r) {
			long mid = l+((r-l)/2);
			if(mid*mid==num) {
				return true;
			}
			if(mid*mid>=num) {
				return isPerfect(l, mid-1, num);
			}
			else {
				return isPerfect(mid+1, r, num);
			}
		}else
			return false;
	}
	static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

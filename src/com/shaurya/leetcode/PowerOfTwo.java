package com.shaurya.leetcode;

public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(-2147483648));
		System.out.println(isPowerOfTwoOpitmal(-2147483648));
		System.out.println(isPowerOfTwoOpitmal(5));
	}
	
	static public boolean isPowerOfTwo(int n) {
		if(n<0) {
			return false;
		}
		int i=2;
		while(i<32) {
			int mask = 1<<i;
			if((mask^n)==0) {
				return true;
			}
			i++;
		}
		return false;
    }
	static public boolean isPowerOfTwoOpitmal(int n) {
		if(n<=0) {
			return false;
		}
		return (n&-n)==n;
	}
}

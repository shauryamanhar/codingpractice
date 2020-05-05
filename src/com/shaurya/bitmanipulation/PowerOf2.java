package com.shaurya.bitmanipulation;

public class PowerOf2 {
	public static void main(String[] args) {
		System.out.println(isPowerOf2(0));
		System.out.println(isPowerOf2(2));
		System.out.println(isPowerOf2(8));
		System.out.println(isPowerOf2(6));
	}
	
	static boolean isPowerOf2(int x) {
		return (x&(x-1))==0;
	}
	
}

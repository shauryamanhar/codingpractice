package com.shaurya.bitmanipulation;

public class CheckSetBit {
	public static void main(String[] args) {
		System.out.println(checkSet(20, 2));
	}
	static boolean checkSet(int n,int i) {
		return (n&1<<i)==0?false:true;
	}
}


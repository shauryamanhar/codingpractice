package com.shaurya.bitmanipulation;

public class CountNumberOf1s {

	public static void main(String[] args) {
		System.out.println(count1s(24));

	}
	static int count1s(int n) {
		int count=0;
		while(n>0) {
			n=n&(n-1);
			count++;
		}
		return count;
	}
	static String toBinary(int n) {
		String bit="";
		while(n>=1) {
			bit=(n%2)+bit;
			n=n/2;
		}
		return bit;
	}

}

package com.shaurya.bitmanipulation;

public class NumberToBinary {

	public static void main(String[] args) {
		int i=16;
		System.out.println(toBinary(i));
		System.out.println(Integer.toBinaryString(i));
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

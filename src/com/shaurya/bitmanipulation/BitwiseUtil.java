package com.shaurya.bitmanipulation;

public class BitwiseUtil {
	static String toBinary(int n) {
		String bit="";
		while(n>=1) {
			bit=(n%2)+bit;
			n=n/2;
		}
		
		return bit.isEmpty()?"0":bit;
	}
}

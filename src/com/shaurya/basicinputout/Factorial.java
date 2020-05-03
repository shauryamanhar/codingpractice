package com.shaurya.basicinputout;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(fact(n));
	}
	
	static int fact(int n) {
		if(n==1 || n==0) {
			return 1;
		}else {
			return n*fact(n-1);
		}
	}

}

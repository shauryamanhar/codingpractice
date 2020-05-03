package com.shaurya.basicinputout;

import java.util.Scanner;

public class CountDivisors {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int r = s.nextInt();
		int k = s.nextInt();
		System.out.println(div(r,k)-div(l-1,k));
	}
	
	static int div(int n,int k) {
		return n/k;
	}

}

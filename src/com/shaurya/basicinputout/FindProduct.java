package com.shaurya.basicinputout;

import java.util.Scanner;

public class FindProduct {

	public static void main(String[] args) {
		long mod = 1000000007 ;
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		long product=1,num;
		while(t-->0) {
			num = s.nextInt();
			product=((product%mod)*(num%mod))%mod;
		}
		System.out.println(product);
	}

}

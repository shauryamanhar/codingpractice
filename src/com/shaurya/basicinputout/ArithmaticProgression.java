package com.shaurya.basicinputout;

import java.util.Scanner;

public class ArithmaticProgression {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		long a,b,c;
		while (t-->0) {
			a=s.nextLong();
			b=s.nextLong();
			c=s.nextLong();
			System.out.println(a+b+c);
		}
	}
}

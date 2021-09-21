package com.shaurya.general;

public class Test{
	public static void main(String[] args) {
//		int n = 46;
		int n = 1068;
		for (int div = 2; div <= n; div++) {
			while (n % div == 0) {
				System.out.println("div " + div + " n " + n);
				n = n / div;
			}
		}
	}
}


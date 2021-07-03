package com.shaurya.interview;

public class Test {
	public static void main(String[] args) {
		System.out.println(nonRepeatingDigitProductCount(2,10,15));
	}
	
	static int nonRepeatingDigitProductCount(int x,int y,int z) {
		int count = 0;
		for (int i = y; i <= z; i++) {
			if (checkIfUnequal(i, x)) {
				count++;
			}
		}
		return count;
	}
	
	static boolean checkIfUnequal(int n, int q) {
		String s1 = Integer.toString(n);
		int count[] = new int[10];
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - '0']++;
		}
		int product = n * q;
		String s2 = Integer.toString(product);
		for (int i = 0; i < s2.length(); i++) {
			if (count[s2.charAt(i) - '0'] > 0) {
				return false;
			}
		}
		return true;
	}
}

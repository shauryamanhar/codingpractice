package com.shaurya.leetcode;

public class ShiftingLetters {

	public static void main(String[] args) {
		ShiftingLetters o = new ShiftingLetters();
		String s = "abc";
//		int shift[] = { 3, 5, 9 };
		int shift[] = { 16, 5, 9 };
		String ans = o.shiftingLetters(s, shift);
		System.out.println(ans);
	}

	public String shiftingLetters(String s, int[] shifts) {
		char[] c = new char[s.length()];
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			sum = (sum + shifts[i]) % 26;
			c[i] = (char) (s.charAt(i) + sum);
			if (c[i] > 'z') {
				c[i] -= 26;
			}
		}
		return new String(c);
	}

}

package com.shaurya.leetcode;

public class ShiftingLetters {

	public static void main(String[] args) {
		ShiftingLetters o = new ShiftingLetters();
		String s = "abc";
		int shift[] = { 3, 5, 9 };
//		int shift[] = { 16, 5, 9 };
		String ans = o.shiftingLetters(s, shift);
		System.out.println(ans);
	}

	public String shiftingLetters(String s, int[] shifts) {
		int len = s.length();
		int sum[] = new int[len];
		int prev = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum[i] = shifts[i] + prev;
			prev = sum[i];
		}
		char c[] = new char[len];
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			int next = ch + sum[i];
			if (next > 'z') {
				next = next % 26;
			}
			System.out.println("value of next " + next);
			c[i] = (char) (next % 26 + 'a');
			System.out.println("c[i] " + c[i]);
		}
		return new String(c);
	}

}

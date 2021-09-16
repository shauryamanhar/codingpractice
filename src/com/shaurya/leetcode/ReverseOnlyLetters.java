package com.shaurya.leetcode;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
//		String s = "a-bC-dEf-ghIj";
		String s = "a-bC-dEf-ghIj";
		reverseOnlyLetters(s);
	}

	static String reverseOnlyLetters(String s) {
		char ch[] = s.toCharArray();
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (!isAlphabet(ch[l])) {
				l++;
				continue;
			}
			if (!isAlphabet(ch[r])) {
				r--;
				continue;
			}
			swap(ch, l, r);
			l++;
			r--;
		}
		System.out.println(new String(ch));
		return new String(ch);
	}

	static void swap(char c[], int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

	static boolean isAlphabet(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

}

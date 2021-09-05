package com.shaurya.leetcode;

import java.util.Arrays;

public class OrderlyQueue {

	public static void main(String[] args) {

		String s = "baaca";

		int k = 1;
		System.out.println(orderlyQueue(s, k));
	}

	static String orderlyQueue(String s, int k) {
		if (k == 1) {
			String ans = s;
			for (int i = 0; i < s.length(); i++) {
				String temp = s.substring(i) + s.substring(0, i);
				System.out.println("temp " + temp);
				if (temp.compareTo(ans) < 0) {
					ans = temp;
				}
			}
			return ans;
		} else {
			char ch[] = s.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		}
	}

}

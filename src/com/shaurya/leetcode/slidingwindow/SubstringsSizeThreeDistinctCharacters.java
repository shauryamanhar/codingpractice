package com.shaurya.leetcode.slidingwindow;

import java.io.PrintStream;

public class SubstringsSizeThreeDistinctCharacters {
	static PrintStream out = System.out;

	public static void main(String[] args) {
		SubstringsSizeThreeDistinctCharacters o = new SubstringsSizeThreeDistinctCharacters();
		String s = "aababcabc";
//		String s = "ooouxoelszb";
		int ans = o.countGoodSubstrings(s.toCharArray());
		out.println(s);
		out.println(ans);
	}

	public int countGoodSubstrings(char str[]) {
		int cnt[] = new int[256];
		int l = 0, e = 0;
		int count = 0;
		while (e < str.length) {
			cnt[str[e]]++;
			while (cnt[str[e]] > 1) {
				cnt[str[l]]--;
				l++;
			}
			int size = e - l + 1;

			if (size == 3) {
				count++;
			}
			if (size >= 3) {
				cnt[str[l]]--;
				l++;
			}
			e++;
		}
		return count;
	}
}

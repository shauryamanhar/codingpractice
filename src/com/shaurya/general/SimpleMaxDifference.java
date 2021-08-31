package com.shaurya.general;

import java.util.Arrays;
import java.util.List;
public class SimpleMaxDifference {

	static int maxDifference(List<Integer> px) {
		int len = px.size();
		if(len==0 || len==1) {
			return 0;
		}
		int min = px.get(0);
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, px.get(i));
			int diff = Math.abs(min - px.get(i));
			maxDiff = Math.max(diff, maxDiff);
		}
		return maxDiff;
	}

	static int maxDifference2(List<Integer> px) {
		int len = px.size();
		if (len == 0 || len == 1) {
			return 0;
		}
		int min = px.get(0);
		int maxDiff = -1;
		for (int i = 1; i < len; i++) {
			int diff = px.get(i)-min;
			maxDiff = Math.max(maxDiff, diff);
			min = Math.min(min, px.get(i));
		}
		return maxDiff;
	}
	public static void main(String[] args) {
		List<Integer> px = Arrays.asList(7, 9, 5, 6, 2);
		px = Arrays.asList(2, 3, 10, 2, 4, 8, 1);
		px = Arrays.asList(10, 9, 8, 7, 6);
		System.out.println(maxDifference(px));
		System.out.println(maxDifference2(px));
	}
}

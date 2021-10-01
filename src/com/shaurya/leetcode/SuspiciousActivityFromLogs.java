package com.shaurya.leetcode;

import java.util.*;

public class SuspiciousActivityFromLogs {
	static List<String> processLogs(List<String> logs, int threshold) {
		Map<String, Integer> map = new HashMap<>();
		for (String logLine : logs) {
			String[] log = logLine.split(" ");
			map.put(log[0], map.getOrDefault(log[0], 0) + 1);
			if (log[0] != log[1]) {
				map.put(log[1], map.getOrDefault(log[1], 0) + 1);
			}
		}

		List<String> userIds = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= threshold) {
				userIds.add(entry.getKey());
			}
		}

		Collections.sort(userIds, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.parseInt(s1) - Integer.parseInt(s2);
			}
		});

		return userIds;
	}

	public static void main(String[] args) {
//	        List<String> input = new ArrayList() {{
//	            add ("345366 89921 45");
//	            add ("029323 38239 23");
//	            add ("38239 345366 15");
//	            add ("029323 38239 77");
//	            add ("345366 38239 23");
//	            add ("029323 345366 13");
//	            add ("38239 38239 23");
//	        }};
		List<String> input = Arrays.asList("1 2 50", "1 7 70", "1 3 20", "2 2 17");
		int th = 2;
		processLogs(input, th).forEach(System.out::println);
	}

}

class Solution2 {
	static int[] hackerCards(int[] collection, int d) {
		List<Integer> result = new ArrayList<>();
		int s, e;
		for (int idx = 0; idx <= collection.length; idx++) {
			if (idx == 0) {
				s = 1;
			}
			else {
				s = collection[idx - 1] + 1;
			}
			if (idx != collection.length) {
				e = collection[idx];
			}
			else {
				e = Integer.MAX_VALUE;
			}
			if (d < s) {
				break;
			}
			for (int k = s; k < e; k++) {
				if (k <= d) {
					result.add(k);
					d -= k;
				} else {
					break;
				}
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}
}

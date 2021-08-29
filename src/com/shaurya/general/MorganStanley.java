package com.shaurya.general;

import java.util.*;
import java.util.Map.Entry;

public class MorganStanley {
	private static String largestString(String s, int k) {
		char[] ch = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		for (Character c : ch) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		Arrays.sort(ch);
		char prev = '0';
		int left = ch.length - 1, right = ch.length - 1, count = 0;
		for (; right >= 0; right--) {
			if (ch[left] == ch[right] && map.get(ch[right]) != 0 && ch[right] != prev) {
				while (count < k && map.get(ch[right]) != 0) {
					list.add(ch[right]);
					map.put(ch[right], map.get(ch[right]) - 1);
					count++;
				}
			} else if (count == k && map.get(ch[right]) != 0) {
				list.add(ch[right]);
				map.put(ch[right], map.get(ch[right]) - 1);
				right = left + 1;
				count = 0;
				prev = list.get(list.size() - 1);

			} else {
				left--;
				right = left + 1;
				count = 0;
				prev = list.get(list.size() - 1);
			}
		}
		String ans = "";
		for(Character c:list) {
			ans+=c;
		}
		return ans;
	}//end

	public static void main(String[] args) {
		System.out.println(largestString("zzzazz", 2));
	}
}

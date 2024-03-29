package com.shaurya.general;
import java.util.*;
public class VowelSubstring {
	public static String findSubstring(String s, int k) {
		int maxCount = 0;
		int count = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < k; i++) {
			if (vowel(s.charAt(i))) {
				count++;
			}
		}
		end = k;
		maxCount = Math.max(maxCount, count);
		int as = 0;
		int ae = k;
		while (end < s.length() && start < end) {
			// remove
			if (vowel(s.charAt(start))) {
				count--;
			}
			start++;
			// add
			if (vowel(s.charAt(end))) {
				count++;
			}
			end++;
			// update value
			if (count == maxCount) {

			}
			if (count > maxCount) {
				maxCount = count;
				as = start;
				ae = end;
			}

		}
		if (maxCount == 0) {
			return "Not found!";
		}
		return s.substring(as, ae);

	}

	private static boolean vowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	public static void main(String[] args) {
		String s = "aab";
		int k = 2;
		System.out.println(findSubstring(s, k));

	}

	public static List<String> findSubstrings(String str) {
		if (str == null || str.isEmpty())
			return Collections.EMPTY_LIST;
		
		Map<Character, List<Integer>> map = new HashMap<>();
		int n = str.length();
		char[] chars = str.toCharArray();
		boolean consonants = false;
		for (int i = 0; i < n; i++) {
			char c = chars[i];
			if (isVowel(c)) {
				if (!map.containsKey(c))
					map.put(c, new ArrayList<>());
				if (!map.get(c).isEmpty()) {
					int last = map.get(c).get(map.get(c).size() - 1);
					if (i > last && i != last + 1)
						map.get(c).add(i);
				} else
					map.get(c).add(i);
			} else
				consonants = true;
		} /** * if there is no consonants, than we can't form the sub-string */
		if (!consonants)
			return Collections.EMPTY_LIST;
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		final List<String> subStrings = new ArrayList<>();
		int v = 0;
		String[] solution = null;
		for (; v < vowels.length; v++) {
			char vowel = vowels[v];
			if (map.containsKey(vowel)) {
				solution = subString(chars, map.get(vowel));
				break;
			}
		}
		if (v == map.size() - 1)
			return Arrays.asList(solution);
		else {
			subStrings.add(solution[0]);
			int x = vowels.length - 1;
			for (; x > v; x--) {
				char vowel = vowels[x];
				if (map.containsKey(vowel)) {
					solution = subString(chars, map.get(vowel));
					break;
				}
			}
			subStrings.add(solution[1]);
		}
		return subStrings;
	}

	private static String[] subString(char[] str, List<Integer> indexes) {
		String first = null;
		String last = null;
		for (int i : indexes) {
			StringBuilder builder = new StringBuilder();
			int x = i;
			while (x < str.length) {
				builder.append(str[x++]);
				if (!isVowel(builder.charAt(builder.length() - 1))) {
					String temp = builder.toString();
					if (first != null)
						first = first.compareTo(temp) < 0 ? first : temp;
					else
						first = temp;
					if (last != null)
						last = last.compareTo(temp) > 0 ? last : temp;
					else
						last = temp;
				}
			}
		}
		return new String[] { first, last };
	}

	private static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		return false;
	}

}

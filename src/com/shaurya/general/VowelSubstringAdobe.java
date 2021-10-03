package com.shaurya.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VowelSubstringAdobe {

	public static void main(String[] args) {
		String a = "aab";
		System.out.println(findSubstrings(a));
		SmallestAndLargestSubstring(a);
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

	static void SmallestAndLargestSubstring(String input) {

		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		char[] cons = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
				'y', 'z' };
		char[] charArray = input.toLowerCase().toCharArray();
		int longStartIndex = 0;
		int shortStartIndex = 0;
		int shortEndIndex = 0;
		int longEndIndex = 0;
		boolean findVowel = false;
		int bestStart = 0;
		int bestEnd = 0;
		int shortest = Integer.MAX_VALUE;

		for (int i = 0; i < charArray.length; i++) {
			for (int z = 0; z < vowels.length; z++) {
				if (charArray[i] == vowels[z]) {
					if (!findVowel) {
						// if this is the first vowel we see
						longStartIndex = i;
						shortStartIndex = i;
						findVowel = true;
					} else {
						shortStartIndex = i;
					}
				}
			}
			for (int j = 0; j < cons.length; j++) {
				if (charArray[i] == cons[j]) {
					if (findVowel) {
						// if we have seen any vowel, this consonant is useless
						longEndIndex = i; // this one is always than the previous for the largest
						shortEndIndex = i; // we have to check if this one is better or not
						if (shortEndIndex - shortStartIndex < shortest) {
							bestStart = shortStartIndex;
							bestEnd = shortEndIndex;
							shortest = shortEndIndex - shortStartIndex;
						}
					}
				}
			}
		}
		System.out.println(input.substring(bestStart, bestEnd + 1));
		System.out.println(input.substring(longStartIndex, longEndIndex + 1));
	}

}

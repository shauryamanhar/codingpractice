package com.shaurya.slidingwindow;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s = "ABBABBA";
		int k = 1;
		System.out.println(characterReplacement(s, k));

	}

	static public int characterReplacement(String s, int k) {
		int l=0,r=0;
		int count[] = new int[26];
		int maxCountChar=0;
		int maxLen=0;
		for(r=0;r<s.length();r++) {
			count[s.charAt(r)-'A']++;
			maxCountChar=Math.max(maxCountChar, count[s.charAt(r)-'A']);
			while((r-l+1-maxCountChar)>k) {
				count[s.charAt(l)-'A']--;
				l++;
			}
			maxLen = Math.max(maxLen, r-l+1);
		}
		return maxLen;
	}

}

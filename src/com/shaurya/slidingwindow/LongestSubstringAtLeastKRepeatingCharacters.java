package com.shaurya.slidingwindow;

public class LongestSubstringAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		String s="ababacb";
		int k=3;
		System.out.println(lss(s, k));

	}
	static int lss(String s,int k){
		int hash[] = new int[26];
		for(char c:s.toCharArray()) {
			hash[c-'a']++;
		}
		int len=0;
		int max=0;
		int i=0,j=0;
		while(j<s.length()) {
			len=0;
			while(j<s.length() && hash[s.charAt(j)-'a']>=k) {
				j++;
				len++;
			}
			max = Math.max(max, len);
			if(j<s.length()) {
				i=j+1;
				j=j+1;
			}
		}
		return max;
	}

}


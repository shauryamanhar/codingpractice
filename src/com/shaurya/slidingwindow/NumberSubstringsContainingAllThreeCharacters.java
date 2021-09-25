package com.shaurya.slidingwindow;


public class NumberSubstringsContainingAllThreeCharacters {
	public int numberOfSubstrings(String s) {
		int freq[] = new int[3];
		int count = 0;
		int j=0,i=0;
		while(i<s.length()) {
			char ch = s.charAt(i);
			freq[ch-'a']++;
			while(j<i && freq['a'-'a']>0
					&& freq['b'-'a']>0 && freq['c'-'a']>0) {
				freq[s.charAt(j)-'a']--;
				j++;
			}
			count+=j;
			i++;
		}
		return count;
    }
	
	public static void main(String[] args) {
		NumberSubstringsContainingAllThreeCharacters o = 
				new NumberSubstringsContainingAllThreeCharacters();
		String s = "abcabc";
		int ans = o.numberOfSubstrings(s);
		System.out.println(ans);

	}

}

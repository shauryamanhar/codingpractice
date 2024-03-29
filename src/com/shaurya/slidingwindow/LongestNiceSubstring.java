package com.shaurya.slidingwindow;

import java.util.HashSet;

public class LongestNiceSubstring {

	public String longestNiceSubstring(String s) {
		if(s.length()<2) {
			return "";
		}
		HashSet<Character> set = new HashSet<Character>(26*2);
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));
		}
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(set.contains(Character.toLowerCase(ch)) && set.contains(Character.toUpperCase(ch))) {
				continue;
			}
			String prev = longestNiceSubstring(s.substring(0, i));
            String next = "";
            if(i+1<s.length())
			    next = longestNiceSubstring(s.substring(i+1));
			return prev.length()>=next.length()?prev:next;
		}
		return s;
	}
	int solution(String s) {
		String ans = longestNiceSubstring(s);
		return ans.length()==0?-1:ans.length();
	}
	
	
	public static void main1(String[] args) {
		String s = "AcZCbaBz";
		LongestNiceSubstring op = new LongestNiceSubstring();
		int ans = op.solution(s);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int m = 13;
		int n = 3;
		double ans = Math.floor(Math.sqrt(m/(4+n)));
		System.out.println("ans "+ans);
	}

}

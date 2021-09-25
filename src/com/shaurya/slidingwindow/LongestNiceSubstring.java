package com.shaurya.slidingwindow;

import java.util.HashSet;

public class LongestNiceSubstring {

	public String longestNiceSubstring(String s) {
		System.out.println(">>"+s);
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
			System.out.println("prev "+prev);
            String next = "";
            if(i+1<s.length())
			    next = longestNiceSubstring(s.substring(i+1));
            System.out.println("next "+next);
			return prev.length()>=next.length()?prev:next;
		}
		return s;
	}
	public static void main(String[] args) {
		String s = "YazaAay";
		LongestNiceSubstring op = new LongestNiceSubstring();
		String ans = op.longestNiceSubstring(s);
		System.out.println(ans);
	}

}

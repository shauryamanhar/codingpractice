package com.shaurya.general;

import java.util.HashSet;

public class BalanceTree {
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
}

package com.shaurya.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
    static public int lengthOfLongestSubstring(String s) {
    	int hash[] = new int[26];
    	int i=0,j=0;
    	int len=0,max=-1;
    	while(i<s.length() && j<s.length()) {
    		if(hash[s.charAt(j)-'a']==0) {
    			hash[s.charAt(j)-'a']++;
    			j++;
    			len++;
    		}else {
    			hash[s.charAt(i)-'a']--;
    			i++;
    			len--;
    		}
    		max = Math.max(max, len);
    	}
    	return max;
    }
    static public int lengthOfLongestSubstringMap(String s) {
    	HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    	int i=0,j=0;
    	int len=0,max=-1;
    	while(i<s.length() && j<s.length()) {
    		if(hash.containsKey(s.charAt(j))==false) {
    			hash.put(s.charAt(j),1);
    			j++;
    			len++;
    		}else {
    			hash.remove(s.charAt(i));
    			i++;
    			len--;
    		}
    		max = Math.max(max, len);
    	}
    	return max;
    }

}

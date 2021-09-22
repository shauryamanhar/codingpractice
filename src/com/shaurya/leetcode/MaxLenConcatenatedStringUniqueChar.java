package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLenConcatenatedStringUniqueChar {
    public int maxLength(List<String> arr) {
    	List<String> ansList = new ArrayList<String>();
    	ansList.add("");
    	int ans = 0;
    	for(String str:arr) {
    		if(!uniqueChech(str)) {
    			continue;
    		}
    		List<String> currStr = new ArrayList<String>();
    		for(String candidate:ansList) {
    			String temp = candidate + str;
    			if(uniqueChech(temp)) {
    				currStr.add(temp);
    				ans = Math.max(ans, temp.length());
    			}
    		}
    		ansList.addAll(currStr);
    	}
    	return ans;
    }
    
    boolean uniqueChech(String str) {
    	if(str.length()>26) {
    		return false;
    	}
    	int[] freq = new int[26];
    	for(int i=0;i<str.length();i++) {
    		freq[str.charAt(i)-'a']++;
    		if(freq[str.charAt(i)-'a']>1) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public static void main(String[] args) {
    	List<String> str = Arrays.asList("un","iq","ue");
    	MaxLenConcatenatedStringUniqueChar m = new MaxLenConcatenatedStringUniqueChar();
    	int ans = m.maxLength(str);
    	System.out.println(ans);
	}
}

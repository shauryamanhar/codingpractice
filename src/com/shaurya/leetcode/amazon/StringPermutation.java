package com.shaurya.leetcode.amazon;

import java.util.HashMap;

public class StringPermutation {
	public static void main(String[] args) {
		String str = "AABB";
		HashMap<Character,Integer> frq = new HashMap<Character, Integer>();
		for(char ch:str.toCharArray()) {
			frq.put(ch, frq.getOrDefault(ch,0)+1);
		}
		permutation(str, 0, frq, "");
	}
	static void permutation(String str,int currIdx,HashMap<Character, Integer> frq,String partial) {
		if(partial.length()==str.length()) {
			System.out.println(partial);
			return;
		}
		for(Character ch:frq.keySet()) {
			if(frq.get(ch)>0) {
				frq.put(ch, frq.get(ch)-1);
				permutation(str, currIdx+1, frq, partial+ch);
				frq.put(ch, frq.get(ch)+1);
			}
		}
	}
}

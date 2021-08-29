package com.shaurya.leetcode;
import java.util.*;
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> groupAnagrams(String[] strs) {
		String[] sortedString = new String[strs.length];
		for(int i=0;i<strs.length;i++) {
			char[] sortedChars = strs[i].toCharArray();
			Arrays.sort(sortedChars);
			sortedString[i] = String.valueOf(sortedChars);
		}
		
		HashMap<String, ArrayList<String>> map = 
				new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<strs.length;i++) {
			String s = sortedString[i];
			if(!map.containsKey(s)) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(s, list);
			}else {
				map.get(s).add(strs[i]);
			}
		}
		
		List<List<String>> group = new ArrayList<>();
		
		for(Map.Entry<String, ArrayList<String>> element:map.entrySet()) {
			group.add(element.getValue());
		}
		return group;
    }

}

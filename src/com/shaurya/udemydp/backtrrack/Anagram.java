package com.shaurya.udemydp.backtrrack;

import java.util.*;
public class Anagram {

	public static void main(String[] args) {
		String str="god";
		int len=str.length();
		anagram(str, new boolean[len], new ArrayList<String>());
	}
	static void anagram(String str,boolean vis[],List<String> partial) {
		if(partial.size()==str.length()) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		for(int i=0;i<str.length();i++) {
			if(!vis[i]) {
				partial.add(str.charAt(i)+"");
				vis[i]=true;
				anagram(str, vis, partial);
				vis[i]=false;
				partial.remove(partial.size()-1);
			}
		}
	}

}

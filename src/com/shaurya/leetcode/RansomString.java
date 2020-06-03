package com.shaurya.leetcode;

public class RansomString {

	public static void main(String[] args) {
		System.out.println(canConstruct("c", "ab"));
	}
	static boolean canConstruct(String ransomNote, String magazine) {
        int ransom[] = new int[26];
        int mag[] = new int[26];
        for(int i=0;i<ransomNote.length();i++) {
        	ransom[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++) {
        	mag[magazine.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++) {
        	if((mag[i]>=ransom[i])) {
        		continue;
        	}
        	return false;
        }
        return true;
    }

}

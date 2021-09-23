package com.shaurya.leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BreakPalindrome {

	public String breakPalindrome(String str) {
		if (str.length() == 1) {
			return "";
		}
		boolean replaced = false;
		char ch[] = str.toCharArray();
		for (int i = 0; i <  ch.length; i++) {
			if(str.length()%2==0) {
				if (ch[i] != 'a') {
					ch[i] = 'a';
					replaced = true;
					break;
				}
			}else {
				if(ch[i]!='a' && i!=str.length()/2) {
    				ch[i]='a';
    				replaced = true;
    				break;
    			}
			}
		}
		if (replaced == false) {
			ch[ch.length - 1] = 'b';
		}
		return new String(ch);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("res/testcase.txt"));
		int t = sc.nextInt();
		BreakPalindrome b = new BreakPalindrome();
		sc.nextLine();
		for (int i = 1; i <= t; i++) {
			String str = sc.nextLine();
			String sol = b.breakPalindrome(str);
			System.out.println("#" + i +" "+str +" -> " + sol);
		}
	}

}
/*
 * 
 * 5 a aaa aba abba xxyzyxx
 * 
 */
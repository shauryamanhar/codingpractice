package com.shaurya.basicinputout;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a=s.next();
		char ch;
		for(int i=0;i<a.length();i++) {
			ch = a.charAt(i);
			if(ch>='A' && ch<='Z') {
				System.out.print((char)(ch+32));
			}else {
				System.out.print((char)(ch-32));
			}
		}
	}
}

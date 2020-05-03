package com.shaurya.basicinputout;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a,b,ans="YES";
		a = s.next();
		int l=0,r=a.length()-1;
		while(l<r) {
			if(a.charAt(l)!=a.charAt(r)) {
				ans="NO";
				break;
			}
			l++;
			r--;
		}
		System.out.println(ans);

	}

}

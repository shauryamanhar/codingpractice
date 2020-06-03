package com.shaurya.codeforces;

import java.util.Scanner;

public class WayToLongWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String s;
		sc.nextLine();
		while(t-->0) {
			s = sc.nextLine();
			solve(s);
		}
	}
	
	static void solve(String s) {
		int len = s.length();
		String ans=s;
		if(len>10) {
			len = len-2;
			ans = s.charAt(0)+""+len+s.charAt(s.length()-1)+"";
		}
		System.out.println(ans);
	}
}

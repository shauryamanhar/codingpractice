package com.shaurya.basicinputout;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String a,b;
		int hash1[];
		int hash2[];
		while(t-->0) {
			hash1= new int[128];
			hash2= new int[128];
			a = s.next();
			b = s.next();
			System.out.println("a>> "+a);
			System.out.println("b>> "+b);
			for(int i=0;i<a.length();i++) {
				hash1[(int)a.charAt(i)]++;
			}
			for(int i=0;i<b.length();i++) {
				hash2[(int)b.charAt(i)]++;
			}
			int count=0;
			for(int i=0;i<hash1.length;i++) {
				count+=(Math.abs(hash1[i]-hash2[i]));
			}
			System.out.println(count);
		}
	}

}

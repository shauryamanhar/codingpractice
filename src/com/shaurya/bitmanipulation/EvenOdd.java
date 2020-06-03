package com.shaurya.bitmanipulation;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t,n;
		String str;
		t = scan.nextInt();
		char ch[],temp;
		while(t-->0) {
			n=scan.nextInt();
			str=scan.next();
			ch = str.toCharArray();
			for(int i=0;i<str.length();i++) {
				temp=ch[ch.length-1];
				for(int j=0;j<ch.length-1;j++) {
					ch[j+1]=ch[j];
				}
				ch[ch.length-1]=temp;
				
				
			}
			
			
		}
	}
	
	

}

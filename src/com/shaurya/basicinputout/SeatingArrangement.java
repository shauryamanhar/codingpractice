package com.shaurya.basicinputout;

import java.util.Scanner;

public class SeatingArrangement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int q = 0 ;
		while(t-->0) {
			q = scan.nextInt();
			System.out.println(solve(q));
		}

	}

	static String solve(int q) {
		int compartment = q/12;
		int n = q%12;
		int i=1,j=11,ans=0;
//		System.out.println("q "+q);
//		System.out.println("n "+n);
//		System.out.println("com "+compartment);
		if(n==0) {
			ans = 0;
		}else if(n<7) {
			while(i<=n) {
				
				if(i==n) {
					ans = (i+j);
					break;
				}
				i++;
				j=j-2;
			}
		}else {
			i=7;
			j=1;
			while(i<=12) {
				if(i==n) {
					ans = (i-j);
					break;
				}
				i++;
				j=j+2;
			}
		}
		String str;
		if(n==1 || n==0 || n==6 || n==7) {
			str = "WS";
		}else if(n==4 || n==9 || n==3 || n==10) {
			str = "AS";
		}else {
			str="MS";
		}
		if(ans==0) {
			return (12*compartment-11)+" "+str;
		}
		return ans+12*compartment+" "+str;
	}
	
	
}

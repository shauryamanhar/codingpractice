package com.shaurya.codeforces;

import java.util.Scanner;

public class NextRound {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt()-1;
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int count=0;
		for(int i=n-1;i>=0;i--) {
			if(a[i]>=a[k] && a[i]>0) {
				count++;
			}
		}
		System.out.println(count);
	}

}

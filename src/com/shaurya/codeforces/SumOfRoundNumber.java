package com.shaurya.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfRoundNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		ArrayList<Integer> list;
		while(t-->0) {
			list  = new ArrayList<Integer>();
			int r,n;
			int mul=1;
			n = scan.nextInt();
			while(n>0) {
				r=n%10;
				r=r*mul;
				if(isRound(r)) {
					list.add(r);
				}
				mul=mul*10;
				n=n/10;
			}
			System.out.println(list.size());
			for(int j:list) {
				System.out.print(j+" ");
			}
			System.out.println();
		}

	}
	static boolean isRound(int n) {
		if(n<=0) {
			return false;
		}
		return true;
	}
}

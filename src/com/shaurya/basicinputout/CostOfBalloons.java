package com.shaurya.basicinputout;

import java.util.Scanner;

public class CostOfBalloons {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int costA,costB,n,p,q;
		int total=0;
		boolean flag=true;
		while(t-->0) {
			total=0;
			costA = s.nextInt();
			costB = s.nextInt();
			n = s.nextInt();
			for(int i=0;i<n;i++) {
				p=s.nextInt();
				q=s.nextInt();
				if(flag) {
					if(p==1 ) {
						total+=costA;
					}
					if(q==1) {
						total+=costB;
					}
				}else {
					if(p==1 ) {
						total+=costB;
					}
					if(q==1) {
						total+=costA;
					}
				}
			}
			flag=!flag;
			System.out.println(total);
		}
	}

}

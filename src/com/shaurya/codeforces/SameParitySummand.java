package com.shaurya.codeforces;

import java.util.Scanner;

public class SameParitySummand {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int t = scan.nextInt();
		int n,k;
		while(t-->0) {
			n=scan.nextInt();
			k=scan.nextInt();
			if(evenNumbers(n, k) || oddNumbers(n, k)) {
			}else {
				System.out.println("NO");
			}
		}

	}//main
	
	//fill k-1 with 2 and then check if last number[n-2(k-1)] is even or odd 
	//if n-(k-1) is odd then sum of even number not possible
	static boolean evenNumbers(int n,int k) {
		int reminder = n-2*(k-1);//eg 10 3->   2 2 (n-2(k-1))->6 answer
		if(reminder<=0) {
			return false;//because last number is not possible
		}
		if((reminder%2)==1) {
			return false;//because number is odd number
		}
		
		System.out.println("YES");
		for(int i=0;i<k-1;i++) {
			System.out.print("2 ");
		}
		System.out.println(reminder);
		return true;
	}
	//fill k-1 with 1 and then check if last number[n-(k-1)] is even or odd 
	//if n-(k-1) is even then sum of odd number not possible
	static boolean oddNumbers(int n,int k) {
		int reminder = n-(k-1);//eg 10 3->   1 1 (n-(k-1))->8 wrong answer 
		if(reminder<=0) {
			return false;//because last number is not possible
		}
		if((reminder%2)==0) {
			return false;//because number is odd number
		}
		
		System.out.println("YES");
		for(int i=0;i<k-1;i++) {
			System.out.print("1 ");
		}
		System.out.println(reminder);
		return true;
	}
	

}

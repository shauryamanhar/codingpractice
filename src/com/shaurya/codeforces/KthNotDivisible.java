package com.shaurya.codeforces;

import java.util.Scanner;

public class KthNotDivisible {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0) {
			long n=scan.nextLong(),k=scan.nextLong();
			System.out.println(findNthNumber(n,k));
		}

	}
	static long findNthNumber(long n,long k) {
		long low=1L,high=Long.MAX_VALUE,mid;
		while(low<high) {
			mid=low+(high-low)/2;
			long count=mid-(mid/n);//counting the numbers that are not divisible
			if(count<k) {
				low=mid+1;
			}else {
				high = mid;
			}
		}
		return low;
	}

}

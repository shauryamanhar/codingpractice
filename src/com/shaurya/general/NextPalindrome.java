package com.shaurya.general;

import java.util.*;

public class NextPalindrome
{
	public static void reverse(char num[], int i,
										int j)
	{
		while (i < j) {
			char temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void nextPalin(char num[], int n)
	{
		if (n <= 3) {
			System.out.println("Not Possible");
			return;
		}
		char temp;
		
		int mid = n / 2 - 1;
		int i, j;
	
		// Start from the (mid-1) th digit and
		// find the first digit that is
		// smaller than the digit next to it.
		for (i = mid - 1; i >= 0; i--)
			if (num[i] < num[i + 1])
				break;
		if (i < 0) {
			System.out.println("Not Possible");
			return;
		}
	
		// Find the smallest digit on right
		// side of ith digit which is greater
		// than num[i] up to index 'mid'
		int smallest = i + 1;
		for (j = i + 2; j <= mid; j++) {
			if (num[j] > num[i] && num[j] <= num[smallest]) {
				smallest = j;
			}
		}
		
		System.out.println("i "+i);
		System.out.println("smallest "+smallest);
		temp = num[i];
		num[i] = num[smallest];
		num[smallest] = temp;
		
		temp = num[n - i - 1];
		num[n - i - 1] = num[n - smallest - 1];
		num[n - smallest - 1] = temp;
		
		// reverse digits in the range (i+1)
		// to mid
		System.out.println("rev i "+(i+1));
		System.out.println("rev mid "+(mid));
		reverse(num, i + 1, mid);
	
		// if n is even, then reverse
		// digits in the range mid+1 to
		// n-i-2
		if (n % 2 == 0)
			reverse(num, mid + 1, n - i - 2);
	
		// else if n is odd, then reverse
		// digits in the range mid+2 to n-i-2
		else
			reverse(num, mid + 2, n - i - 2);
	
		String result=String.valueOf(num);
		System.out.println("Next Palindrome: "+
								result);
	}
	
	// Driver Code
	public static void main(String args[])
	{
		String str="4697557964";
		char num[]=str.toCharArray();
		int n=str.length();
		nextPalin(num,n);
	}
}
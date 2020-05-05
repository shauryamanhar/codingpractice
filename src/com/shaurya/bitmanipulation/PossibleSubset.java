package com.shaurya.bitmanipulation;

public class PossibleSubset {
	public static void main(String[] args) {
		char a[] = {'a','b','c'};
		printSubset(a, a.length);
	}
	
	static void printSubset(char a[],int n) {
		for(int i=0;i<(1<<n);i++) {
			for(int j=0;j<n;j++) {
				if((i&(1<<j))!=0) {//setting particular bit
					System.out.print(a[j]);
				}
			}
			System.out.println();
		}
	}
}

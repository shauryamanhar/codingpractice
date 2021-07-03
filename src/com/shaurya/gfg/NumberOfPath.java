package com.shaurya.gfg;

public class NumberOfPath {
	public static void main(String[] args) {
		int m =3,n=3;
		System.out.println(numberOfPaths(m-1, n-1));
	}
	static long numberOfPaths(int m, int n) {
		if(m==0 && n==0) {
			return 0;
		}
		if(m==0 || n==0){
            return 1;
        }
        return numberOfPaths(m,n-1)+numberOfPaths(m-1,n);
    }
	
}

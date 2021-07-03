package com.shaurya.gfg;

public class ReverseBit {
	public static void main(String[] args) {
		System.out.println(reverseBits(10));
	}
    static int reverseBits(int n){
        int rev=0;
        while(n>0){
        	rev = rev<<1;
            if((n&1)==1){
                rev = rev | 1;
            }
            n = n>>1;
        }
        return rev;
    }
}

package com.shaurya.gfg;

public class SumInt {

	public static void main(String[] args) {
		System.out.println(sum(5,3));
	}
	static int sum(int x,int y){
		int carry=0;
		while(y!=0) {
			carry = x & y;
			int sum = x ^ y;
			x = sum;
			y = carry<<1;
		}
		return x;
	}

}

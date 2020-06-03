package com.shaurya.bitmanipulation;

public class Add1ToBinary {

	public static void main(String[] args) {
		addOne(10);

	}
	
	//using right most zero-in this flip all bit after right most 0 including this zero also
	//ex. 011=(3+1)->100=4
	static void addOne(int x) {
		int m =1;
		while(((int)x&m)>=1) {//end when right most 0 reach
			x=x^m;//flip bits
			m<<=1;//power of 2 ->001 010 100
		}
		x=x^m;//flip last zero
		System.out.println("ans "+x);
	}

}

package com.shaurya.basicinputout;

import java.util.Scanner;

public class Zoo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String zoo = s.next();
		int nOfO = zoo.length()-zoo.lastIndexOf('z')-1;
		System.out.println(nOfO==2*(zoo.length()-nOfO)?"Yes":"No");
	}

}

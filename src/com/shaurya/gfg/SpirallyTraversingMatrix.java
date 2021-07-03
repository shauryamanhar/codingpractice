package com.shaurya.gfg;

import java.util.ArrayList;

public class SpirallyTraversingMatrix {

	public static void main(String[] args) {
		int a[][] = {{5,11,20},
				     {5,19,100}
		           };
		spiral(a);
	}
	static private void spiral(int a[][]) {
		int rowLow = 0,rowMax = a.length-1;
		int colLow = 0,colMax = a[0].length-1;
		ArrayList<Integer> print = new ArrayList<Integer>();
		int i=0;
		while(rowMax>=0 && colMax>=0 && rowLow<a.length && colLow<a[0].length) {
			switch (i%4) {
			case 0:
				for(int col=colLow;rowLow<=rowMax && col<=colMax;col++) {
					print.add(a[rowLow][col]);
				}
				rowLow++;
				break;
			case 1:
				for(int row=rowLow;colMax>=colLow && row<=rowMax;row++) {
					print.add(a[row][colMax]);
				}
				colMax--;
				break;
			case 2:
				for(int col=colMax;rowMax>=rowLow && col>=colLow;col--) {
					print.add(a[rowMax][col]);
				}
				rowMax--;
				break;
			case 3:
				for(int row=rowMax;colMax>=colLow && row>=rowLow;row--) {
					print.add(a[row][colLow]);
				}
				colLow++;
				
				break;
			}//case
			i++;
		}//while
		System.out.println(print);
	}
}

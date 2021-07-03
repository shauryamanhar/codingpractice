package com.shaurya.leetcode.amazon;

public class PrintPossibleMatrix {
	public static void main(String[] args) {
		int grid[][] = {
				{6,0,0,},
				{0,2,0},
				{4,0,5}
		};
		print(grid,0,0);
	}
	static void print(int grid[][],int x,int y) {
//		System.out.printf("x=%d,y=%d\n",x,y);
		int nextX=0;
		int nextY=0;
		if(x==grid.length) {
			p(grid);
			return;
		}
		if(y==grid[0].length-1) {
			nextX = x+1;
			nextY = 0;
		}else {
			nextX=x;
			nextY=y+1;
		}
		if(grid[x][y]!=0) {
			print(grid, nextX, nextY);
		}else {
			for(int i=1;i<=9;i++) {
				if(isValid(grid, i)) {
					grid[x][y]=i;
					print(grid, nextX, nextY);
					grid[x][y]=0;
				}
			}
		}
	}
	static void p(int grid[][]) {
		System.out.println("solution found");
		for(int a[]:grid) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static boolean isValid(int grid[][],int val) {
		for(int a[]:grid) {
			for(int b:a) {
				if(b==val) {
					return false;
				}
			}
		}
		return true;
	}
}

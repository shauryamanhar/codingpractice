package com.shaurya.leetcode.amazon;

public class NQueen {
	public static void main(String[] args) {
		int grid[][] = new int[4][4];
		nqueen(grid, 0);
	}
	static void nqueen(int grid[][],int row) {
		if(row==grid.length) {
			System.out.println("solution found");
			print(grid);
			return;
		}
		for(int col=0;col<grid[0].length;col++) {
			if(isValid(grid, row, col)) {
				grid[row][col]=1;
				nqueen(grid, row+1);
				grid[row][col]=0;
			}
		}
	}
	static void print(int grid[][]) {
		for(int a[]:grid) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	static boolean isValid(int grid[][],int row,int col) {
		//check row
		for(int i=0;i<grid[0].length;i++) {
			if(grid[row][i]==1) {
				return false;
			}
		}
		//check col
		for(int i=0;i<grid.length;i++) {
			if(grid[i][col]==1) {
				return false;
			}
		}
		//check dia
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(row+col==i+j) {
					if(grid[i][j]==1) {
						return false;
					}
				}
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(col-row==j-i) {
					if(grid[i][j]==1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

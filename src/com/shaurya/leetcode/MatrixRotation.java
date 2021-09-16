package com.shaurya.leetcode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MatrixRotation {
	static PrintStream out = System.out;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		int col = matrix[0].length;
		printOrder(matrix, row, col, list);
		return list;
	}

	public static void main(String[] args) {
		int row = 2;
		int col = 2;
		int matrix[][] = new int[row][col];
		int count = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = count++;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		out.println();
		MatrixRotation m = new MatrixRotation();
		out.println(m.spiralOrder(matrix));
	}

	void printOrder(int[][] matrix, int row, int col, List<Integer> list) {
		int rs = 0, re = row - 1;
		int cs = 0, ce = col - 1;
		while (rs <= re && cs <= ce) {
			// left to right
			for (int i = cs; i <= ce && rs <= re && cs <= ce; i++) {
				list.add(matrix[rs][i]);
			}
			rs++;
			// up to down
			for (int i = rs; i <= re && rs <= re && cs <= ce; i++) {
				list.add(matrix[i][ce]);
			}
			ce--;
			// right to left
			for (int i = ce; i >= cs && rs <= re && cs <= ce; i--) {
				list.add(matrix[re][i]);
			}
			re--;
			// down to up
			for (int i = re; i >= rs && rs <= re && cs <= ce; i--) {
				list.add(matrix[i][cs]);
			}
			cs++;
		}

	}
}

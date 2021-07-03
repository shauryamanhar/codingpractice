package com.shaurya.leetcode.amazon;

public class SodukoSolver {
	public static void main(String[] args) {
		int a[][] = {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}};
		 solveSudoku(a);
	}
	static void print(int[][]a) {
		for(int c[]:a) {
			 for(int d:c) {
				 System.out.print(d+" ");
			 }
			 System.out.println();
		 }
	}
	static public void solveSudoku(int[][] board) {
        sudoku(board,0,0);
        print(board);
    }
    static void sudoku(int [][]board,int row,int col){
    	if(row==board.length) {
    		System.out.println("solution found");
    		return;
    	}
        int nextRow=0;
        int nextCol=0;
        if(col==board[0].length-1){
            nextRow = row+1;
            nextCol=0;
        }else{
            nextRow = row;
            nextCol = col + 1 ;
        }
        if(board[row][col]!=0){
            sudoku(board,nextRow,nextCol);
        }else{
            for(int val=1;val<=9;val++){
                if(isValid(board,row,col,val)){
                    board[row][col]=val;
                    sudoku(board,nextRow,nextCol);
                    board[row][col]=0;
                }
            }
        }
    }//sudoku
    static boolean isValid(int[][] board,int row,int col,int val){
        //check the row
        for(int i=0;i<=8;i++){
        	if(board[row][i]==val){
        		return false;
        	}
        }
        //check the col
        for(int i=0;i<=8;i++){
            if(board[i][col]==val){
                return false;
            }
        }
        //check the submatrix
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[startRow+i][startCol+j]==val){
                    return false;
                }
            }
        }
        return true;
    }
}

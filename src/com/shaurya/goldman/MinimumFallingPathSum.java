package com.shaurya.goldman;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int mat[][] = {
			{-48}
		};
		System.out.println(minFallingPathSum(mat));
	}
    static int minFallingPathSum(int[][] matrix) {
    	int len = matrix.length;
    	int dp[][] = new int[len][len];
    	for(int row=0;row<len;row++) {
    		for(int col=0;col<len;col++) {
    			if(row==0) {
    				dp[row][col]=matrix[row][col];
    			}else {
    				int min = matrix[row][col]+ dp[row-1][col];
    				if(col>0) {
    					min = Math.min(min, matrix[row][col]+dp[row-1][col-1]);
    				}
    				if(col+1<len) {
    					min = Math.min(matrix[row][col]+dp[row-1][col+1], min);
    				}
    				dp[row][col]+=min;
    			}
    		}
    	}
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<len;i++) {
    		min = Math.min(min, dp[len-1][i]);
    	}
        return min;
    }
//    static int find(int mat[][],int row,int col,int sum) {
//    		if(row==mat.length-1) {
//    			return sum;
//    		}
//    		for(int i=0;i<mat.length;i++) {
//    			sum+=
//    		}
//    }

}

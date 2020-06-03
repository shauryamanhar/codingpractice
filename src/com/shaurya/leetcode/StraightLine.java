package com.shaurya.leetcode;

public class StraightLine {

	public static void main(String[] args) {
		int c[][]={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
//		int c[][]={{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
//		int c[][]={{0,0},{0,1},{0,-1}};
		System.out.println(checkStraightLine(c));
	}
	
	static public boolean checkStraightLine(int[][] c) {
		int n = c.length;
		if(n ==0 || n==1) {
			return true;
		}
		int x1,x2,y2,y1,x,y;
		x1=c[0][0];x2=c[1][0];
		y1=c[0][1];y2=c[1][1];
		int dx = x2-x1;
		int dy = y2-y1;
		for(int i=0;i<n;i++) {
			x=c[i][0];y=c[i][1];
			if(dx*(y-y2)!=dy*(x-x2)) {
				return false;
			}
		}
		return true;
    }
	
}

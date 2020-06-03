package com.shaurya.leetcode;

public class FloodFill {

	public static void main(String[] args) {
//		int a[][] = {{1,1,1},{1,1,0},{1,0,1}};
//		int a[][] = {{0,0,0},{0,0,0}};
		int a[][] = {{0,0,0},{0,1,1}};
//		int sr=1,sc=1,color=1;
		int sr=1,sc=1,color=1;
//		floodFill(a, sr, sc, color);
		floodFillDfs(a, sr, sc, color);
		for(int r[]:a) {
			for(int c:r) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}
	
	static public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean vis[][] = new boolean[image.length][image[0].length];
        fill(sr,sc,newColor,image,vis,image[sr][sc]);
        return image;
    }
	static public int[][] floodFillDfs(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
        if(color != newColor)
        	dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
	}
	
	static void dfs(int a[][],int x,int y,int newColor,int cellValue) {
		if(isSafe(x, y, a, newColor,cellValue)) {
			a[x][y]=newColor;
			dfs(a,x-1,y,newColor,cellValue);
			dfs(a,x+1,y,newColor,cellValue);
			dfs(a,x,y-1,newColor,cellValue);
			dfs(a,x,y+1,newColor,cellValue);
		}
	}
	
	
	private static boolean isSafe(int x, int y, int[][] a, int newColor, int cellValue) {
		return x>=0 && y>=0 && x<a.length && y<a[x].length && a[x][y]!=newColor && a[x][y]==cellValue;
	}

	static void fill(int x,int y,int color,int a[][],boolean [][]vis,int cellValue){
			a[x][y]=color;
			//up
			if(isSafe(x, y-1, a,vis,cellValue)) {
				vis[x][y-1]=true;
				fill(x,y-1,color,a,vis,cellValue);
			}
			//downa
			if(isSafe(x, y+1, a,vis,cellValue)) {
				vis[x][y+1]=true;
				fill(x,y+1,color,a,vis,cellValue);
			}
			//left
			if(isSafe(x-1, y, a,vis,cellValue)) {
				vis[x-1][y]=true;
				fill(x-1,y,color,a,vis,cellValue);
			}
			//right
			if(isSafe(x+1, y, a,vis,cellValue)) {
				vis[x+1][y]=true;
				fill(x+1,y,color,a,vis,cellValue);
			}
	}
	
	static boolean isSafe(int x,int y,int a[][],boolean vis[][],int cellValue) {
		return x>=0 && y>=0 && x<a.length && y<a[x].length && !vis[x][y] && a[x][y]==cellValue;
	}

}

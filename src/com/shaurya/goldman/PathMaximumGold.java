package com.shaurya.goldman;

public class PathMaximumGold {

	public static void main(String[] args) {
		int grid[][]= {
				{0 ,0 ,0 ,0 ,0 ,0 ,32,0 ,0 ,20},
				{0 ,0 ,2 ,0 ,0 ,0 ,0 ,40,0 ,32},
				{13,20,36,0 ,0 ,0 ,20,0 ,0 ,0},
				{0 ,31,27,0 ,19,0 ,0 ,25,18,0 },
				{0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
				{0 ,0 ,0 ,0 ,0 ,0 ,0 ,18,0 ,6},
				{0 ,0 ,0 ,25,0 ,0 ,0 ,0 ,0 ,0},
				{0 ,0 ,0 ,21,0 ,30,0 ,0 ,0 ,0},
				{19,10,0 ,0 ,34,0 ,2 ,0 ,0 ,27},
				{0 ,0 ,0 ,0 ,0 ,34,0 ,0 ,0 ,0}
				};
		System.out.println(getMaximumGold(grid));
	}
    static int getMaximumGold(int[][] grid) {
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j]!=0) {
    				vis =new boolean[grid.length][grid[0].length];
    				dfs(grid, i, j, 0);
    			}
    		}
    	}
    	return max;
    }
    static boolean vis[][];
    static int max=-1;
    static void dfs(int grid[][],int x,int y,int sum) {
    	if(x<0 || y<0 || x>grid.length || y> grid[0].length) {
    		return ;
    	}
    	sum+=grid[x][y];
    	vis[x][y]=true;
    	//go left
    	if(isSafe(grid, x, y-1)) {
    		dfs(grid, x, y-1, sum);
    	}
    	
    	//go right
    	if(isSafe(grid, x, y+1)) {
    		dfs(grid, x, y+1, sum);
    	}
    	
    	//go up
    	if(isSafe(grid, x-1, y)) {
    		dfs(grid, x-1, y, sum);
    	}
    	//go down
    	if(isSafe(grid, x+1, y)) {
    		dfs(grid, x+1, y, sum);
    	}
    	vis[x][y]=false;
    	max = Math.max(max, sum);
    }
    static boolean isSafe(int grid[][],int x,int y) {
    	return x>=0 && y>=0 && x<grid.length && y<grid[0].length && !vis[x][y] && grid[x][y]!=0;
    }
    

}

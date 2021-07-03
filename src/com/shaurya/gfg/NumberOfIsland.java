package com.shaurya.gfg;

public class NumberOfIsland {

	public static void main(String[] args) {
		int grid[][] =  {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
		System.out.println(numIslands(grid));
	}
    static int numIslands(int[][] grid){
    	int numberOfIsland = 0;
    	boolean vis[][] = new boolean[grid.length][grid[0].length];
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[0].length;j++) {
    			if(grid[i][j]==1 && !vis[i][j]) {
    				dfs(grid,i,j,vis);
    				numberOfIsland++;
    			}
    		}
    	}
        return numberOfIsland;
    }
	
    static void dfs(int grid[][],int x,int y,boolean vis[][]) {
    	vis[x][y]=true;
    	//up
    	if(isSafe(grid, x-1, y, vis)) {
    		dfs(grid, x-1, y, vis);
    	}
    	//down
    	if(isSafe(grid, x+1, y, vis)) {
    		dfs(grid, x+1, y, vis);
    	}
    	//left
    	if(isSafe(grid, x, y-1, vis)) {
    		dfs(grid, x, y-1, vis);
    	}
    	//right
    	if(isSafe(grid, x, y+1, vis)) {
    		dfs(grid, x, y+1, vis);
    	}
    	//diagonal
    	if(isSafe(grid, x-1, y-1, vis)) {
    		dfs(grid, x-1, y-1, vis);
    	}
    	
    	if(isSafe(grid, x-1, y+1, vis)) {
    		dfs(grid, x-1, y+1, vis);
    	}
    	
    	if(isSafe(grid, x+1, y-1, vis)) {
    		dfs(grid, x+1, y-1, vis);
    	}
    	if(isSafe(grid, x+1, y+1, vis)) {
    		dfs(grid, x+1, y+1, vis);
    	}
    }
    
    static boolean isSafe(int grid[][],int x,int y,boolean vis[][]) {
    	return x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!=0 && !vis[x][y];
    }
    static void print(boolean vis[][]) {
    	for(boolean a[]:vis) {
    		for(boolean b:a) {
    			System.out.print(b+" ");
    		}
    		System.out.println();
    	}
    }
	
}

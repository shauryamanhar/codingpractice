package com.shaurya.gfg;


public class MaxArea {
	public static void main(String[] args) {
		int grid[][] = {{ 1,1,1,0},
				         {0,0,1,0},
				         {0,0,0,1}};
		System.out.println(findMaxArea(grid));
	}
	static int max = 0;
	static int cc = 0;
	static int findMaxArea(int[][] grid){
		int r = grid.length;
		int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		cc=0;
        		if(!vis[i][j]) {
        			dfs(grid, i, j, vis, 0);
        		}
        		max = Math.max(max, c);;
        		
        	}
        }
		return max;
    }
	static void dfs(int grid[][],int x,int y,boolean vis[][],int count) {
		vis[x][y]=true;
		cc++;
		max = Math.max(max, cc);
		if(isSafe(grid, x-1, y, vis)) {
			dfs(grid, x-1, y, vis, count);
		}
		if(isSafe(grid, x+1, y, vis)) {
			dfs(grid, x+1, y, vis, count);
		}
		if(isSafe(grid, x, y+1, vis)) {
			dfs(grid, x, y+1, vis, count);
		}
		if(isSafe(grid, x, y-1, vis)) {
			dfs(grid, x, y-1, vis, count);
		}
		if(isSafe(grid, x-1, y-1, vis)) {
			dfs(grid, x-1, y-1, vis, count);
		}
		if(isSafe(grid, x-1, y+1, vis)) {
			dfs(grid, x-1, y+1, vis, count);
		}
		if(isSafe(grid, x+1, y-1, vis)) {
			dfs(grid, x+1, y-1, vis, count);
		}
		
		if(isSafe(grid, x+1, y+1, vis)) {
			dfs(grid, x+1, y+1, vis, count);
		}
	}
	static boolean isSafe(int grid[][],int x,int y,boolean vis[][]) {
		return x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y];
	}
}

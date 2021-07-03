package com.shaurya.gfg;

public class MinimumCostPath {

	public static void main(String[] args) {
		int grid[][] = { { 4, 4 }, { 3, 7 } };
		System.out.println(minimumCostPath(grid));
	}
	static int min = Integer.MAX_VALUE;
	static int minimumCostPath(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int srcCost = grid[0][0];
		boolean vis[][] = new boolean[row][col];
		dfs(grid, 0, 0, vis, srcCost);
		return min;
	}

	static void dfs(int grid[][], int x, int y, boolean vis[][], int cost) {
		if (x == grid.length - 1 && y == grid[0].length - 1) {
			min = Math.min(min, cost);
			return;
		}
		vis[x][y] = true;
		if (isSafe(grid, x - 1, y, vis)) {
			dfs(grid, x - 1, y, vis, cost + grid[x - 1][y]);
		}
		if (isSafe(grid, x + 1, y, vis)) {
			dfs(grid, x + 1, y, vis, cost + grid[x + 1][y]);
		}
		if (isSafe(grid, x, y - 1, vis)) {
			dfs(grid, x, y - 1, vis, cost + grid[x][y - 1]);
		}
		if (isSafe(grid, x, y + 1, vis)) {
			dfs(grid, x, y + 1, vis, cost + grid[x][y + 1]);
		}
		vis[x][y] = false;
	}

	static boolean isSafe(int grid[][], int x, int y, boolean vis[][]) {
		return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !vis[x][y];
	}
}

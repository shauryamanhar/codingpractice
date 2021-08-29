package com.shaurya.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

	public static void main(String[] args) {
		int grid[][] = {{1,0,0},{0,1,1},{1,1,1}};
		int ans = largestIsland(grid);
		System.out.println("ans "+ans);
	}
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	static int largestIsland(int[][] grid) {
		if(grid==null || grid.length==0) {
			return 0;
		}
		int max = 0,islandId = 2, R = grid.length , C = grid[0].length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(grid[i][j]==1) {
					int size = getIslandSize(grid,i,j,islandId);
					max = Math.max(max, size);
					map.put(islandId++, size);
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(grid[i][j]==0) {
					Set<Integer> set = new HashSet<Integer>();
					for(int[] d:dir) {
						int x = d[0]+i;
						int y = d[1]+j;
						if(x> -1 && y>-1 && x<R && y<C && grid[x][y]!=0) {
							set.add(grid[x][y]);
						}
					}
					int sum = 1;
					for(int num:set) {
						int value = map.get(num);
						sum+=value;
					}
					max = Math.max(max, sum);
				}
			}
		}
		
		return max;
    }
	
	private static int getIslandSize(int[][] grid, int i, int j, int islandId) {
		if(i< 0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1) {
			return 0;
		}
		grid[i][j] = islandId;
		int left = getIslandSize(grid, i, j-1, islandId);
		int right = getIslandSize(grid, i, j+1, islandId);
		int up = getIslandSize(grid, i-1, j, islandId);
		int down = getIslandSize(grid, i+1, j, islandId);
		return left+right+up+down+1;
	}

}

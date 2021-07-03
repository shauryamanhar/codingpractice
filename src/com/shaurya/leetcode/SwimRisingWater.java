package com.shaurya.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimRisingWater {

	public static void main(String[] args) {
		int grid[][] = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		System.out.println(swimInWater(grid));
	}
	static int swimInWater(int[][] grid) {
		int currTime=0;
		Comparator<Pair> comp = (a,b)->{return a.elevation-b.elevation;};
		PriorityQueue<Pair> pq = new PriorityQueue<SwimRisingWater.Pair>(comp);
		pq.add(new Pair(0,0,grid[0][0]));
		boolean vis[][] = new boolean[grid.length][grid[0].length];
		vis[0][0]=true;
		while(!pq.isEmpty()) {
			Pair pair = pq.poll();
			int x = pair.x;
			int y = pair.y;
			//add the child
			if(x==grid.length-1 && y==grid[0].length-1) {
				break;
			}
			
			if(grid[x][y]>=currTime) {
				currTime=grid[x][y];
			}			
			//up
			if(isSafe(grid, x-1, y, vis)) {
				vis[x-1][y]=true;
				pq.add(new Pair(x-1,y,grid[x-1][y]));
			}
			//down
			if(isSafe(grid, x+1, y, vis)) {
				vis[x+1][y]=true;
				pq.add(new Pair(x+1,y,grid[x+1][y]));
			}
			//left
			if(isSafe(grid, x, y-1, vis)) {
				vis[x][y-1]=true;
				pq.add(new Pair(x,y-1,grid[x][y-1]));
			}
			//right
			if(isSafe(grid, x, y+1, vis)) {
				vis[x][y+1]=true;
				pq.add(new Pair(x,y+1,grid[x][y+1]));
			}
		}//while
        return currTime;
    }
	static boolean isSafe(int grid[][],int x,int y,boolean vis[][]) {
		return x>=0 && y>=0 && x<grid.length && y<grid[0].length && !vis[x][y];
	}
	static class Pair{
		int x,y,elevation;
		Pair(int x,int y,int elevation){
			this.x=x;
			this.y=y;
			this.elevation=elevation;
		}
	}
}

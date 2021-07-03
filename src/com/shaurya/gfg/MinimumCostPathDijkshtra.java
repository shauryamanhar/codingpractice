package com.shaurya.gfg;

import java.util.PriorityQueue;

public class MinimumCostPathDijkshtra {

	public static void main(String[] args) {
		int grid[][] = { { 4, 4 }, { 3, 7 } };
		System.out.println(minimumCostPath(grid));
	}
	static int minimumCostPath(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int dist[][] = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		dist[0][0] = grid[0][0];
		PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
		pq.add(new Cell(0,0,dist[0][0]));
		int direction[][] = {
				{-1,0},{0,1},{1,0},{0,-1}
		};
		while(!pq.isEmpty()) {
			Cell currNode = pq.poll();
			for(int i=0;i<4;i++) {
				int nextX = currNode.x+direction[i][0];
				int nextY = currNode.y+direction[i][1];
				if(isSafe(grid, nextX, nextY)) {
					if(dist[nextX][nextY]>dist[currNode.x][currNode.y]+grid[nextX][nextY]) {
						if(dist[nextX][nextY]!=Integer.MAX_VALUE) {
							Cell adj = new Cell(nextX, nextY, dist[nextX][nextY]);
							pq.remove(adj);
						}
						dist[nextX][nextY]=dist[currNode.x][currNode.y]+grid[nextX][nextY];
						pq.add(new Cell(nextX,nextY,dist[nextX][nextY]));
					}
				}
			}//for
		}//while
		return dist[row-1][col-1];
	}

	static boolean isSafe(int grid[][], int x, int y) {
		return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
	}
	static class Cell implements Comparable<Cell>{
		int x,y,dist;
		Cell(int x,int y,int dist){
			this.x=x;
			this.y=y;
			this.dist=dist;
		}
		@Override
		public boolean equals(Object obj) {
			Cell b = (Cell)obj;
			return x==b.x && y==b.y;
		}
		@Override
		public int compareTo(Cell o) {
			return dist-o.dist;
		}
	}
}

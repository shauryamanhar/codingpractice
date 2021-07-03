package com.shaurya.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class CovidSpread {

	public static void main(String[] args) {
		int hospital[][]={
        {2, 1, 0, 2, 1},
		{1, 0, 1, 2, 1},
		{1, 0, 0, 2, 1 }};
		System.out.println(helpaterp(hospital));
	}
	
    static int helpaterp(int[][] bed) {
    	int row = bed.length;
    	int col = bed[0].length;
    	boolean vis[][] = new boolean[row][col];
    	Queue<int[]> queue = new LinkedList<int[]>();
    	
    	int unInfected=0;
    	//add initial infected bed
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(bed[i][j]==2) {
    				queue.add(new int[] {i,j});
    			}
    			if(bed[i][j]==1) {
    				unInfected++;
    			}
    		}
    	}
    	
    	int day=0;
    	//count how many level are present and that represent the number of days
    	while(!queue.isEmpty() && unInfected>0) {
    		int bedCount = queue.size();
    		System.out.println("printing queue ");
    		day++;
    		for(int i=0;i<bedCount;i++) {
    			int idx[] = queue.poll();
    			int x = idx[0];
    			int y = idx[1];
    			System.out.printf("processing (%d,%d)=%d\n",x,y,bed[x][y]);
    			//counting how many uninfected bed is infected now
    			if(bed[x][y]==1) {
    				unInfected--;
    			}
    			//up
    			if(isSafe(bed, x-1, y, vis)) {
    				queue.add(new int[] {x-1,y});
    				vis[x-1][y]=true;
    			}
    			//down
    			if(isSafe(bed, x+1, y, vis)) {
    				queue.add(new int[] {x+1,y});
    				vis[x+1][y]=true;
    			}
    			//left
    			if(isSafe(bed, x, y-1, vis)) {
    				queue.add(new int[] {x,y-1});
    				vis[x][y-1]=true;
    			}
    			//right
    			if(isSafe(bed, x, y+1, vis)) {
    				queue.add(new int[] {x,y+1});
    				vis[x][y+1]=true;
    			}
    		}//for
    	}
    	return unInfected==0?day-1:-1;
    }
    static boolean isSafe(int bed[][],int x,int y,boolean vis[][]) {
    	return x>=0 && y>=0 && x<bed.length && y<bed[0].length 
    			&& bed[x][y]==1
    			&& !vis[x][y];
    }
}

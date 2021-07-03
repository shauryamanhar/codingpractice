package com.shaurya.gfg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
	public static void main(String[] args) {
		int n=2;
		int arr[] = {19,25};
		System.out.println(">>>>>"+getMinDiceThrows(arr, arr.length));
	}
	static int getMinDiceThrows(int arr[],int n) {
	       int moves[] = new int[30];
	       Arrays.fill(moves,-1);
	       for(int i=0;i<n-1;i=i+2){
	           moves[arr[i]]=arr[i+1];
	       }
	       
	        Queue<int[]> queue = new LinkedList<int[]>();
			boolean vis[] = new boolean[moves.length];
			int qe[] = new int[] {0,0};
			queue.add(qe);
			vis[0]=true;
			while(!queue.isEmpty()) {
				qe = queue.poll();
				int v = qe[0]; 
				if(v==moves.length-1) {
					break;
				}
				//check all the child
				for(int j=(v+1);j<=(v+6) && j<moves.length;j++) {
					if(!vis[j]) {
						int temp[] = new int[2];
						temp[1]=qe[1]+1;
						vis[j]=true;
						if(moves[j]!=-1) {
							temp[0]=moves[j];
						}else {
							temp[0]=j;
						}
						queue.add(temp);
					}
				}//for
			}
			return qe[1];
	}
}

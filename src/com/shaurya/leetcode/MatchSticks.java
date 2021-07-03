package com.shaurya.leetcode;

import java.util.Arrays;

public class MatchSticks {
	static boolean rv = false;
	
	static boolean makesquare(int[] matchsticks) {
		int sum = 0;
		for(int a:matchsticks) {
			sum+=a;
		}
		if(sum%4!=0) {
			return false;
		}
		Arrays.sort(matchsticks);
		int target = sum/4;
		boolean vis[] = new boolean[matchsticks.length];
		for(int i=0;i<4;i++) {
			for(int j=matchsticks.length-1;j>=0;j--) {
				if(!vis[j]) {
					boolean sumFound = sum(matchsticks, j, 0, target, vis);
					if(!sumFound) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int mat[] = {1,1,2,2,2};
		System.out.println(makesquare(mat));
	}
	static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static boolean sum(int arr[],int idx,int currSum,int targetSum,boolean vis[]) {
		System.out.printf("idx %d,curr sum %d\n",idx,currSum);
		System.out.println(Arrays.toString(vis));
		if(currSum==targetSum) {
			System.out.println("sum found ");
			return true;
		}
		if(idx<0 || idx>=arr.length) {
			return false;
		}
		if(vis[idx]) {
			return false;
		}
		vis[idx]=true;
		boolean include = sum(arr, idx-1, currSum+arr[idx], targetSum, vis);
		vis[idx]=false;
		boolean exclude = sum(arr, idx-1, currSum, targetSum, vis);
		return include || exclude;
	}
	
	
}

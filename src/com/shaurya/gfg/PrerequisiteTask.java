package com.shaurya.gfg;

import java.util.ArrayList;
import java.util.List;

public class PrerequisiteTask {

	public static void main(String[] args) {
		int task = 7;
		ArrayList<int[]> prerequisite = new ArrayList<int[]>();
		prerequisite.add(new int[] {1,0});
//		prequisite.add(new int[] {1,6});
		prerequisite.add(new int[] {2,1});
		prerequisite.add(new int[] {3,2});
		prerequisite.add(new int[] {4,5});
		prerequisite.add(new int[] {4,3});
		prerequisite.add(new int[] {5,2});
		prerequisite.add(new int[] {6,4});
		System.out.println(isPossible(task, prerequisite));
	}
	
	static boolean isPossible(int task,List<int[]> prerequisite) {
		//make adjList 
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		for(int i=0;i<task;i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for(int pair[]:prerequisite) {
			adjList.get(pair[1]).add(pair[0]);
		}
		
		boolean path[] = new boolean[task];
		boolean vis[] = new boolean[task];
		for(int i=0;i<task;i++) {
			if(!vis[i]) {
				boolean cycle = cycleDetection(adjList, i, path, vis);
				if(cycle==true) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean cycleDetection(List<List<Integer>> adj,int currTask,boolean path[],boolean vis[]) {
		if(vis[currTask]) {
			return false;
		}
		vis[currTask]=true;
		path[currTask]=true;
		//find all the child
		for(int nextTask:adj.get(currTask)) {
			if(path[nextTask]==true) {
				return true;
			}
			boolean cycle = cycleDetection(adj, nextTask, path, vis);
			if(cycle==true) {
				return true;
			}
		}
		path[currTask]=false;
		return false;
	}

}

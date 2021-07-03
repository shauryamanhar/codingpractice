package com.shaurya.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		adj.add(Arrays.asList(1));//0
		adj.add(Arrays.asList(2));//1
		adj.add(Arrays.asList(0));//6
		stronglyConnectedComponent(adj);
	}
	
	static int stronglyConnectedComponent(List<List<Integer>> adj) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean vis[] = new boolean[adj.size()];
		for(int i=0;i<adj.size();i++) {
			if(!vis[i]) {
				dfsFillStack(adj, i, vis, stack);
			}
		}
		//reverse 
		adj = reverseGraph(adj);
		
		int count=0;
		vis = new boolean[adj.size()];
		
		while(!stack.isEmpty()) {
			int i = stack.pop();
			if(!vis[i]) {
				dfs(adj, i, vis);
				count++;
			}
		}
		System.out.println("component found "+count);
		return count;
	}
	
	static List<List<Integer>> reverseGraph(final List<List<Integer>> adjList) {
		List<List<Integer>> rev = new ArrayList<>();
		for(int v=0;v<adjList.size();v++) {
			rev.add(new ArrayList<Integer>());
		}
		for(int v=0;v<adjList.size();v++) {
			for(int neigh:adjList.get(v)) {
				rev.get(neigh).add(v);
			}
		}
		return rev;
	}
	
	static void dfsFillStack(List<List<Integer>> adj,int node,boolean vis[],Stack<Integer> stack) {
		vis[node]=true;
		for(int nextNode:adj.get(node)) {
			if(!vis[nextNode]) {
				dfsFillStack(adj, nextNode, vis, stack);
			}
		}
		stack.add(node);
	}
	static void dfs(List<List<Integer>> adj,int node,boolean vis[]) {
		vis[node]=true;
		for(int nextNode:adj.get(node)) {
			if(!vis[nextNode]) {
				dfs(adj, nextNode, vis);
			}
		}
	}
}

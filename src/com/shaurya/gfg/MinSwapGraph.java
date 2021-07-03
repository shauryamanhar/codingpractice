package com.shaurya.gfg;

import java.util.*;

public class MinSwapGraph {
	public static void main(String[] args){
		String[] a = { "for", "geek","rig", "kaf" };
		System.out.println(canBeChained(a, a.length));
	}
	
	static List<List<Integer>> adj;
	static int V;
 	static void dfs(int node,boolean vis[]) {
		vis[node]=true;
		for(int nextNode:adj.get(node)) {
			if(!vis[nextNode]) {
				dfs(nextNode, vis);
			}
		}
	}//dfs
 	static boolean isConnectedGraph() {
 		boolean vis[] = new boolean[V];
 		int node = -1;
 		for(int i=0;i<V;i++) {
 			if(adj.get(i).size()>0) {
 				node = i;
 				break;
 			}
 		}
 		if(node==-1) {
 			return true;//means all node have degree one and all are disconnected component
 		}
 		dfs(node, vis);
 		
 		//check if all non zero vertices are visited or not
 		for(int i=0;i<V;i++) {
 			if(!vis[i] && adj.get(i).size()>0) {
 				return false;
 			}
 		}
 		return true;
 	}
 	static boolean isEulerGraph() {
 		if(!isConnectedGraph()) {
 			return false;
 		}
 		//count the odd degree
 		int odd=0;
 		for(int i=0;i<V;i++) {
 			if(adj.get(i).size()%2==1) {
 				odd++;
 			}
 		}
 		return odd==0;//if odd is means it is Euler graph
 	}
 	static boolean canBeChained(String a[],final int n) {
 		int chars = 26;
 		adj = new ArrayList<List<Integer>>();
 		for(int i=0;i<chars;i++) {
 			adj.add(new ArrayList<Integer>());
 		}
 		for(String s:a) {
 			char first = s.charAt(0);
 			char second = s.charAt(s.length()-1);
 			adj.get(first-'a').add(second-'a');
 			adj.get(second-'a').add(first-'a');
 		}
 		V = adj.size();
 		return isEulerGraph();
 	}
}

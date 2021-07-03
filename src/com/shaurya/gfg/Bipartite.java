package com.shaurya.gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0].trim());
            int E = Integer.parseInt(S[1].trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean ans = check(adj,V);
            if(ans)
                System.out.println("True");
            else System.out.println("False");
       }
	}
	static boolean check(ArrayList<ArrayList<Integer>> adjList,int V) {
		int visited[] = new int[V];
		Arrays.fill(visited, -1);
		for(int v=0;v<V;v++) {
			if(visited[v]==-1) {
				boolean isComponentBipartite = isBipartite(adjList, V, v,visited); 
				if(isComponentBipartite==false) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList,int V,int src,int visited[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int color= 1;
		queue.add(src);
		visited[src]=color;
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int edge:adjList.get(curr)) {
			    if(visited[edge]==visited[curr]){
			        return false;
			    }
				if(visited[edge]==-1) {
					queue.add(edge);
					visited[edge]=1-visited[curr];
				}
			}
		}
		return true;
	}
}

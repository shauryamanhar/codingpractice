package com.shaurya.general;

import java.util.*;

public class FindKNodeFromLeaf {
	public static boolean isLeaf(Node node) {
		return (node.left == null && node.right == null);
	}

	public static void leafNodeDistance(Node node, List<Node> path, Set<Node> set, int dist) {
		if (node == null) {
			return;
		}
		if (isLeaf(node) && path.size() >= dist) {
			set.add(path.get(path.size() - dist));
			return;
		}
		path.add(node);

		leafNodeDistance(node.left, path, set, dist);
		leafNodeDistance(node.right, path, set, dist);
		path.remove(node);
	}

	public static void leafNodeDistance(Node node, int dist) {
		List<Node> path = new ArrayList<>();
		Set<Node> set = new TreeSet<>();
		leafNodeDistance(node, path, set, dist);
		for (Node e : set) {
			System.out.print(e.data + " ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		Node root = null;
		HashMap<Integer, Node> map = new HashMap<Integer, FindKNodeFromLeaf.Node>();
		for(int i=0;i<N-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(map.containsKey(a)==false) {
				map.put(a, new Node(a));
			}
			Node nodeA = map.get(a);
			Node nodeB = new Node(b);
			if(nodeA.left==null) {
				nodeA.left = nodeB;
			}else if(nodeA.right==null){
				nodeA.right = nodeB;
			}
			map.put(b, nodeB);
		}
		leafNodeDistance(map.get(1), k);
		
	}
	static void preordre(Node node) {
		if(node==null) {
			return;
		}
		System.out.println("node "+node.data);
		preordre(node.left);
		preordre(node.right);
	}

	static class Node implements Comparable<Node>{
		int data;
		Node left = null, right = null;

		Node(int data) {
			this.data = data;
		}
		@Override
		public int compareTo(Node o) {
			return data-o.data;
		}
	}
}

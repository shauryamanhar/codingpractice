package com.shaurya.gfg;

import java.util.*;

public class RatInMaze {

	public static void main(String[] args) {
		int N = 4;
		int m[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		System.out.println(findPath(m, N));
	}// main

	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> l = new ArrayList<String>();
		boolean vis[][] = new boolean[n][n];
		path(m, n, 0, 0, l, "", vis);
		return l;
	}

	static void path(int[][] m, int n, int x, int y, ArrayList<String> list, String path, boolean vis[][]) {
		if (x == n - 1 && y == n - 1) {
			list.add(path);
			return;
		}
		vis[x][y] = true;
		// up
		if (isSafe(m, n, x - 1, y, vis)) {
			path(m, n, x - 1, y, list, path + "U", vis);
		}
		// down
		if (isSafe(m, n, x + 1, y, vis)) {
			path(m, n, x + 1, y, list, path + "D", vis);
		}
		// left
		if (isSafe(m, n, x, y - 1, vis)) {
			path(m, n, x, y - 1, list, path + "L", vis);
		}
		// right
		if (isSafe(m, n, x, y + 1, vis)) {
			path(m, n, x, y + 1, list, path + "R", vis);
		}
		vis[x][y]=false;
	}

	static boolean isSafe(int m[][], int n, int x, int y, boolean vis[][]) {
		return x >= 0 && y >= 0 && x < n && y < n && !vis[x][y] && m[x][y] == 1;
	}

}

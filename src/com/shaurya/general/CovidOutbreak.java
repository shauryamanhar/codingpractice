package com.shaurya.general;

import java.util.ArrayList;
import java.util.Scanner;

public class CovidOutbreak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList[] graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int r = sc.nextInt();

		}

	}

}

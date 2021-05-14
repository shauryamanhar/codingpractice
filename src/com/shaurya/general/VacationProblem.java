package com.shaurya.general;

import java.util.Scanner;

public class VacationProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int cost[][] = new int[n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=2;j++) {
				cost[i][j]=sc.nextInt();
			}
		}
		solution(cost,n);
	}
	
	static void solution(int cost[][],int n) {
		int dp[][] = new int[n+1][n+1];
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		for(int i=1;i<n;i++) {
			dp[i][0]=cost[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]=cost[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2]=cost[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
		}
		int ans = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(ans);
	}
}



package com.shaurya.cses;

public class DiceCombinations {

	public static void main(String[] args) {
		int target = 999997;
		System.out.println("no of ways:" + diceDp(target));
	}

	static int dice(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			if (n - i < 0) {
				break;
			}
			count += dice(n - i);
		}
		return count;
	}

	static long diceDp(int n) {
		long dp[] = new long[n + 1];
		dp[0] = 1;
		long mod = 1_000_000_007;
		for (int i = 1; i < n + 1; i++) {
			for (int x = 1; x <= 6; x++) {
				if (x > i) {
					break;
				}
				dp[i] = (dp[i] + dp[i - x]) % mod;
			}
		}
		return dp[n];
	}

}

package com.shaurya.gfg.string;

public class MinimumInsertionsFormPalindrome {

	public static void main(String[] args) {
		String str = "abcb";
		int ans = countInsertion(str, 0, str.length()-1);
		ans = countInsertionDp(str);
		System.out.println(ans);

	}
	
	
	static int countInsertion(String str,int l,int r) {
		if(l>r) {
			return 0;
		}
		if(str.charAt(l)==str.charAt(r)) {
			return countInsertion(str, l+1, r-1);
		}else {
			int left = 1 + countInsertion(str, l+1, r);
			int right = 1 + countInsertion(str, l, r-1);
			return Math.min(left, right);
		}
	}
	static int countInsertionDp(String str) {
		int len = str.length();
		int dp[][] = new int[len+1][len+1];
		for(int i=len-1;i>=0;i--) {
			for(int j=0;j<len;j++) {
				if(i==0 || j==0) {
					continue;
				}
				if(str.charAt(i)==str.charAt(j)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
				}
			}
		}
		print(dp);
		return dp[len][len];
	}
	static void print(int dp[][]) {
		System.out.println("dp print");
		for(int a[]:dp) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}

}

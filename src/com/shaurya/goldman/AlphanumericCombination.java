package com.shaurya.goldman;

import java.util.Arrays;

public class AlphanumericCombination {
	public static void main(String[] args) {
		String str = "2112";
		System.out.println(calculatePOssibleSum(str));
	}
	static long calculatePOssibleSum(String str) {
		char digit[] = str.toCharArray();
		int n = digit.length;
		long count[] = new long[n+1];
		count[0]=1;
		count[1]=1;
		if(digit[0]=='0') {
			return 0;
		}
		for(int i=2;i<=n;i++) {
			count[i]=0;
			if(digit[i-1]>'0') {
				count[i]=count[i-1];
			}
			if(digit[i-2]=='1' || digit[i-2]=='2' && digit[i-1]<'7') {
				count[i]+=count[i-2];
			}
		}
		System.out.println(Arrays.toString(count));
		return count[n];
	}
	
}

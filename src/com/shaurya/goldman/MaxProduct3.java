package com.shaurya.goldman;

public class MaxProduct3 {
	public static void main(String[] args) {
		int a[] = {-100,-98,-1,2,3,4};
		maxProductOf3(a);
	}
	static int maxProductOf3(int a[]) {
		int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		for(int n:a) {
			if(n<min1) {
				min2=min1;
				min1=n;
			}else if(n<min2) {
				min2=n;
			}
			if(n>max1) {
				max3=max2;
				max2=max1;
				max1=n;
			}else if(n>max2) {
				max3=max2;
				max2=n;
			}else if(n>max3) {
				max3=n;
			}
		}
		System.out.println("min1 "+min1);
		System.out.println("min2 "+min2);
		System.out.println("max1 "+max1);
		System.out.println("max2 "+max2);
		System.out.println("max3 "+max3);
		return Math.max(min1*min2*max1,max1*max2*max3);
	}
}

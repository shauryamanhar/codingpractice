package com.shaurya.leetcode.amazon;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int a[] = {1,3};
		int b[] = {2};
		System.out.println(findMedianSortedArrays(a, b));
	}
    static public double findMedianSortedArrays(int[] a, int[] b) {
        int len = a.length+b.length;
        boolean even = len%2==0?true:false;
        int temp[] = new int[len];
        int m=0,n=0,k=0;
        while(k<len && m<a.length && n<b.length) {
        	if(a[m]<b[n]) {
        		temp[k]=a[m++];
        	}else {
        		temp[k]=b[n++];
        	}
        	k++;
        }
        while(m<a.length) {
        	temp[k++]=a[m++];
        }
        while(n<b.length) {
        	temp[k++]=b[n++];
        }
        System.out.println(Arrays.toString(temp));
        if(even) {
        	int index = len/2;
        	return (temp[index-1]+temp[index])/2.0;
        }else {
        	return temp[len/2];
        }
    }

}

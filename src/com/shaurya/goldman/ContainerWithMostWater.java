package com.shaurya.goldman;

import java.util.Stack;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int height[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
    static public int maxArea(int[] height) {
    	int l=0,r=height.length-1;
    	int max = -1;
    	while(l<r) {
    		int dist = r -l;
    		int h = Math.min(height[l], height[r]);
    		max = Math.max(max, h*dist);
    		if(height[l]<height[r]) {
    			l++;
    		}else {
    			r--;
    		}
    	}
        return max;
    }
}

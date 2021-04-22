package com.shaurya.goldman;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		

	}
    static public int trap(int[] height) {
        int len=height.length;
        if(height==null || height.length==0){
            return 0;
        }
        int maxLeft=height[0],maxRight=height[len-1];
        int l=0,r=len-1;
        int ans=0;
        while(l<r){
            if(maxLeft<maxRight){
                l++;
                maxLeft = Math.max(maxLeft,height[l]);
                ans+=(maxLeft-height[l]);
            }else{
                r--;
                maxRight = Math.max(maxRight,height[r]);
                ans+=(maxRight-height[r]);
            }
        }
        return ans;
    }
    static public int trapUsingStack(int[] height) {
        if(height==null || height.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int ans = 0;
        while(i<height.length) {
        	while(stack.isEmpty()!=false && height[i]>height[stack.peek()]) {
        		int top = stack.pop();
        		if(stack.empty()) {
        			break;
        		}
        		int distanceBetween = i-stack.peek()-1;
        		int boundaryHeight = Math.min(height[i], height[stack.peek()])-height[top];
        		ans = ans + (distanceBetween*boundaryHeight);
        	}
        	stack.push(i);
        	i++;
        }
        return ans;
    }

}

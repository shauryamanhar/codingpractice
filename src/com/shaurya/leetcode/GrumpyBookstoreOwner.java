package com.shaurya.leetcode;

public class GrumpyBookstoreOwner {

	public static void main(String[] args) {
		int cust[] = {1,0,1,2,1,1,7,5};
		int gmy[] =  {0,1,0,1,0,1,0,1};
		int x=3;
		int maxCust = maxSatisfied(cust, gmy, x);
		System.out.println("max customer "+maxCust);
	}
    static public int maxSatisfied(int[] cust, int[] gmy, int X) {
    	int sum = 0;
    	for(int i=0;i<cust.length;i++) {
    		if(gmy[i]==0) {
    			sum+=cust[i];
    		}
    	}
    	int i=0,j=0;
    	int max=-1;
    	while(j<cust.length) {
    		if(j<i+X) {
    			if(gmy[j]==1)
    				sum+=cust[j];
    			j++;
    		}else {
    			if(gmy[i]==1)
    				sum-=cust[i];
    			i++;
    		}
    		max = Math.max(max, sum);
    	}
        return max;
    }
}

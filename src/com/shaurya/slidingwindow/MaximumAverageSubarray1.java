package com.shaurya.slidingwindow;

public class MaximumAverageSubarray1 {

    public double findMaxAverage(int[] nums, int k) {
    	if(nums.length==1) {
    		return (double)(nums[0]);
    	}
    	double sum = 0;
    	for(int i=0;i<k;i++) {
    		sum+=nums[i];
    	}
    	double avg = sum/k;
    	if(k==nums.length) {
    		return avg;
    	}
    	for(int i=k;i<nums.length;i++) {
    		//remove from front
    		sum-=nums[i-k];
    		//add from end
    		sum+=nums[i];
    		//max avg
    		avg = Math.max(avg, sum/k);
    	}
    	return avg;
    }
	
	public static void main(String[] args) {
		MaximumAverageSubarray1 o = new MaximumAverageSubarray1();
		int nums[] = {-1};
		int k = 1;
		double ans = o.findMaxAverage(nums, k);
		System.out.println(ans);
	}
	

}

package com.shaurya.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class MedianFinder {
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
    	int minHeapSize = minHeap.size();
    	int maxHeapSize = maxHeap.size();
    	if(maxHeapSize==0) {
    		maxHeap.add(num);
    	}else if(minHeapSize==maxHeapSize){
    		if(num<minHeap.peek()) {
    			maxHeap.add(num);
    		}else {
    			int temp = minHeap.poll();
    			minHeap.add(num);
    			maxHeap.add(temp);
    		}
    	}else {
    		if(minHeap.size()==0) {
    			if(num>maxHeap.peek()) {
    				minHeap.add(num);
    			}else {
    				int temp = maxHeap.poll();
    				maxHeap.add(num);
    				minHeap.add(temp);
    			}
    		}else if(num>=minHeap.peek()){
    			minHeap.add(num);
    		}else {
    			if(num<maxHeap.peek()) {
    				int temp = maxHeap.poll();
    				minHeap.add(num);
    				maxHeap.add(temp);
    			}else {
    				minHeap.add(num);
    			}
    		}
    	}
    }
    
    public double findMedian() {
    	if(maxHeap.size()>minHeap.size()) {
    		return (double)maxHeap.peek();
    	}else {
    		return (double)(minHeap.peek()+maxHeap.peek())/2;
    	}
    }
}

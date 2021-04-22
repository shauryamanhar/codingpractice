package com.shaurya.goldman;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	public static void main(String[] args) {
		subsets(new int[] {1,2,3});
	}
    static List<List<Integer>> subsets(int[] n) {
    	int len = n.length;
    	List<List<Integer>> list = new ArrayList<>(); 
    	List<Integer> temp = new ArrayList<Integer>();
    	for(int i=0;i<(1<<len);i++) {
    		temp = new ArrayList<Integer>();
    		for(int j=0;j<n.length;j++) {
    			if((i & (1<<j))!=0) {
    				temp.add(n[j]);
    			}
    		}
    		list.add(temp);
    	}
		return list;
    }
	
}

package com.shaurya.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsTruck {

	public static void main(String[] args) {
		int boxTypse[][] = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		maximumUnits(boxTypse, truckSize);
	}
    static int maximumUnits(int[][] boxTypes, int truckSize) {
    	Comparator<int[]> comparatror =  (a,b)->{return -(a[1]-b[1]);};
    	Arrays.sort(boxTypes,comparatror);
    	int totalUnit = 0;
    	for(int i=0;i<boxTypes.length;i++) {
    		if(truckSize>0 && truckSize>=boxTypes[i][0]) {
    			truckSize-=boxTypes[i][0];
    			totalUnit+= (boxTypes[i][0]*boxTypes[i][1]);
    		}else {
    			if(truckSize>0) {
    				totalUnit+= (truckSize*boxTypes[i][1]);
    				truckSize=0;
    			}
    		}
    	}
        return totalUnit;
    }
}

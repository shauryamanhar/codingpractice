package com.shaurya.goldman;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
	public static void main(String[] args) {
		int in[][] = {{1,4},{2,3}};
		merge(in);
	}
    static int[][] merge(int[][] in) {
    	ArrayList<Pair> l = new ArrayList<Pair>();
        Arrays.sort(in,
    			(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]
    			);
    	int start = in[0][0];
    	int end = in[0][1];
    	for(int i=1;i<in.length;i++) {
    		if(end>=in[i][0]) {
    			end = Math.max(end, in[i][1]);
    		}else {
    			l.add(new Pair(start,end));
    			start=in[i][0];
    			end=in[i][1];
    		}
    	}
    	l.add(new Pair(start,end));
    	int len = l.size();
    	int a[][] = new int[len][2];
    	for(int i=0;i<len;i++) {
    		a[i][0]=l.get(i).start;
    		a[i][1]=l.get(i).end;
    	}
    	return a;
    }
    static class Pair{
    	int start,end;
    	Pair(int s,int e){
    		this.start=s;
    		this.end=e;
    	}
    }
}

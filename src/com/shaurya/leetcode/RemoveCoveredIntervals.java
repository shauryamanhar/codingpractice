package com.shaurya.leetcode;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        int val[][] = {{1,2},{1,4},{3,4}};
        System.out.println(removeCoveredIntervals(val));
    }   
    static public int removeCoveredIntervals(int[][] val) {
        int n=val.length;
        boolean vis[] = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(val[i][0]>=val[j][0] && val[i][1]<=val[j][1]){
                    System.out.println("count found");
                    count++;
                }
            }
        }
        return n-count;   
    }
}

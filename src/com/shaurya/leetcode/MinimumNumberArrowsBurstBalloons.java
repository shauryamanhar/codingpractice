package com.shaurya.leetcode;

import java.util.*;

//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3490/
public class MinimumNumberArrowsBurstBalloons {
    public static void main(String[] args) {
        // int a[][] = { { 1, 6 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int a[][] = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(a));

    }

    static public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //if we use a[]-b[] -> this leads to overflow 
        //if a and b is very large negative value->overflow 
        //so use normal compare a>b?a:b like that
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
                if (o1[1] == o2[1]) {
                    return o1[0] > o2[0]? 1: o1[0] < o2[0]? -1: 0;
                }
                return 1;
            }
          });
        //count=1 
        //all the baloon can be merge into one
        //now find out the how many can not be merge
        //the idea is now to not to found how many can be merge
        //it is about how many can not merge
        //if all get merge the count will be 1
        //else count is getting incremented.
        int count=1;        
        int end = points[0][1];
        for(int p[]:points){
            if(end<p[0]){
                count++;
                end = p[1];
            }
        }
        return count;
    }
}

package com.shaurya.leetcode;

import java.util.*;
//link: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3482
public class KdiffPairsInArray {
    public static void main(String[] args) {
        int nums[] = {-1,-2,-3};
        int k = 1;
        countPairsWithDiffK(nums, nums.length, k);
    }

    
    static int countPairsWithDiffK(int arr[], int n, int k){
        //first sort the array so easy can use binary search
        Arrays.sort(arr);
        //set for storing the minimun value of pair and also avoid duplicate values
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            //binary search for [i+1,n-] in the rest of array
            if(binarySearch(arr, i+1, n-1, arr[i]+k)!=-1){
                set.add(arr[i]);
            }
        }
        System.out.println(set.toString());
        return set.size();
    }

    static int binarySearch(int a[],int l,int r,int x){
        //l==r for corner case
        if(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]==x){
                return mid;
            }
            //go right
            if(a[mid]<x){
                return binarySearch(a, mid+1, r, x);
            }else if(a[mid]>x){
                return binarySearch(a, l, mid-1, x);
            }
        }
        //not found the answer
        return -1;
    }


}

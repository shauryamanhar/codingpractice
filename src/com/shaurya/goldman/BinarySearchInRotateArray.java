package com.shaurya.goldman;

public class BinarySearchInRotateArray {

	public static void main(String[] args) {
		int a[] = { 4,5,6,2,3};
		System.out.println(findMin(a));
	}
    static public int findMin(int[] a) {
        if(a.length==1){
            return a[0];
        }
        int l=0,r=a.length-1;
        if(a[r]>a[0]){
            return a[0];
        }
        while(l<r){
            int mid = l+(r-l)/2;
            
            if(a[mid]>a[mid+1]){
                return a[mid+1];
            }
            if(a[mid-1]>a[mid]){
                return a[mid];
            }
            if(a[mid]>a[0]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }

}

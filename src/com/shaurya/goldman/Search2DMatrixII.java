package com.shaurya.goldman;

public class Search2DMatrixII {

	public static void main1(String[] args) {
		int mat[][] = {{3}};
		int target = 3;
		System.out.println(binarySearch(mat[0], target));
		System.out.println(searchMatrix(mat, target));
	}
	public static void main(String[] args) {
		int a=20,b=30;
		System.out.println(++a);
		System.out.println(a++);
		b=a++;
		System.out.println(b);
		System.out.println(++b);
		System.out.println(b+a);
	}
    static boolean searchMatrix(int[][] matrix, int target) {
    	for(int i=0;i<matrix.length;i++) {
    		if(bsRow(matrix[i], target, i)!=-1) {
    			return true;
    		}
    	}
    	return false;
    }
    static int bsRow(int []mat,int target,int row) {
    	int l=0,r=mat.length-1;
    	while(l<=r) {
    		int mid = l + (r-l)/2;
    		if(mat[mid]==target) {
    			return mid;
    		}
    		if(mat[mid]<target) {
    			l = mid+1;
    		}else {
    			r = mid-1;
    		}
    	}
    	return -1;
    }
    static int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
  
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
  
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
  
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
  
        // if we reach here, then element was
        // not present
        return -1;
    }
    

}

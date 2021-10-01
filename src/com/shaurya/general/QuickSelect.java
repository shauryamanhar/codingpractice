package com.shaurya.general;

import java.util.Arrays;

public class QuickSelect {

	public static void main(String[] args) {
		QuickSelect o = new QuickSelect();
		int arr[] = {3,6,2,5,1,4};
		System.out.println(Arrays.toString(arr));
		
		//quick select part
		o.quickSelect(arr, 4);
		o.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
 	}
	
	void quickSelect(int arr[],int k) {
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int pivot = partition(arr, low, high);
			if(pivot==k) {
				System.out.println("found "+arr[pivot]);
				return;
			}
			if(k<pivot) {
				high = pivot - 1 ;
			}else {
				low = pivot + 1;
			}
		}
		System.out.println("not found ");
	}
	
	int partition(int arr[],int low,int high) {
		int pivot = arr[high];
		int i=low-1;
		int j=low;
		while(j<high) {
			if(arr[j]<pivot) {
				i++;
				//swap
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			j++;
		}
		//swap i+1 and pivot, place pivot in right position
		int temp = arr[high];
		arr[high] = arr[i+1];
		arr[i+1] = temp;
		return i+1;
	}
	
	void quickSort(int arr[],int low,int high) {
		if(low<high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex-1);
			quickSort(arr, pivotIndex+1, high);
		}
	}

}

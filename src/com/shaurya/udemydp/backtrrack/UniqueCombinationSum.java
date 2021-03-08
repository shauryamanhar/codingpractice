package com.shaurya.udemydp.backtrrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinationSum {

	public static void main(String[] args) {
		int a[] = {10,1,2,7,6,1,5};
		int t=8;
		//sort to remove duplicate
		Arrays.sort(a);
		comSum(a, t, 0, new ArrayList<Integer>(), 0);

	}

	static void comSum(int a[],int target,int sum,List<Integer> partial,int start) {
		if(sum==target) {
			System.out.println(Arrays.toString(partial.toArray()));
			return;
		}
		for(int i=start;i<a.length;i++) {
			int c = a[i];
			if(sum+c>target || i>start && a[i]==a[i-1]) {
				continue;
			}
			partial.add(c);
			comSum(a, target, sum+c,partial,i+1);
			partial.remove(partial.size()-1);
		}
	}

}

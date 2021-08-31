package com.shaurya.general;

import java.util.Arrays;
import java.util.List;
public class MathHomework {

	static void binarySearch(List<Integer> points, int low, int high, int key, int ans) {
	    if(low<high){
			int mid = low + ((high - low) / 2);
			if (points.get(mid) == key) {
	            ans = mid;
	            return;
			} else if (points.get(mid) >= key) {
				ans = Math.min(ans, mid);
				binarySearch(points, low, mid - 1, key, ans);
	        }else{
				binarySearch(points, mid + 1, high, key, ans);
	        }
	    }
	}

	static int minNum(int threshold, List<Integer> points) {
	    if(threshold + points.get(0) > points.get( (points.size()-1))){
	        return points.size();
	    }
	    int key = threshold + points.get(0);
	    int ans = points.size()-1;
		binarySearch(points, 0, points.size() - 1, key, ans);
	    ans = ans + 1;
	    int _ans = (ans + 2)/2;
	    return _ans;
	}

	public static void main(String[] args) {
		int t = 2;
		List<Integer> points = Arrays.asList(1, 2, 3);
		System.out.println(points);
		System.out.println(minNum(t, points));
	}
}

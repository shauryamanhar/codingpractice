package com.shaurya.gfg.dp;

import java.util.HashMap;

public class ArrayPairDivisibleByK {

	public static void main(String[] args) {
//		int a[] = {9,56,25,52,72,44,80,36,96,11};
//		System.out.println(checkPairExists(a, 8));
//		int b[] = {77,22,56,11,45,34,78,29,23,55};
//		System.out.println(checkPairExists(b, 10));
		int c[] = {10,12};
//		System.out.println(checkPairExists(c, 13));
		int n=-10,k=3;
//		System.out.println(n%k);
		System.out.println( ((n % k) + k) % k);
	}
	static boolean checkPairExists(final int a[],final int k) {
		if(a.length==1) {
			return false;
		}
		HashMap<Integer, Integer> reminderFrqMap = new HashMap<Integer, Integer>();
		for(int n:a) {
			int rem =  ((n % k) + k) % k;
			if(!reminderFrqMap.containsKey(rem)) {
				reminderFrqMap.put(rem, 0);
			}
			reminderFrqMap.put(rem, reminderFrqMap.get(rem)+1);
		}
		for(int n:a) {
			int rem =  ((n % k) + k) % k;
			if(2*rem==0) {
				if(reminderFrqMap.get(rem)%2==1) {
					return false;
				}
			}else if(rem==0){
				if(reminderFrqMap.get(rem)%2==1) {
					return false;
				}
			}else {
				if(reminderFrqMap.get(rem)!=reminderFrqMap.get(k-rem)) {
					return false;
				}
			}
		}
		return true;
	}

}

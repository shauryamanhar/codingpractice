package com.shaurya.general;

import java.util.ArrayList;
import java.util.HashMap;

public class GoldmanBookOfCricketGame {

	public static void main(String[] args) {
		numOfWay(50);
	}
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int numOfWay(int n) {
		score(0, n);
		System.out.println(count);
		return count;
		
	}//num of wayA
	static int count=0;
	static void score(int sum,int t) {
		if(sum==t) {
			count++;
			return;
		}
		if(sum>t) {
			return;
		}
		if(map.containsKey(sum)) {
			count+=map.get(sum);
			return;
		}
		for(int i=1;i<8;i++) {
			if(i%2==0) {
				sum=sum+i;
				score(sum, t);
				sum=sum-i;
			}
		}
		map.put(sum, count);
	}//score
}

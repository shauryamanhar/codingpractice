package com.shaurya.general;
import java.util.*;

public class DistanceMatrics {
	public static void main(String[] args) {
		
	}
	static List<Long> getDistanceMatrics(List<Integer> arr){
		int len = arr.size();
		HashMap<Integer,ArrayList<Integer[]>> map = new HashMap<Integer, ArrayList<Integer[]>>();
		for(int i=0;i<len;i++) {
			if(map.containsKey(arr.get(i))) {
				ArrayList<Integer[]> temp = map.get(i);
				Integer a[] = {arr.get(i),i};
				temp.add(a);
				map.put(arr.get(i), temp);
			}else {
				ArrayList<Integer[]> temp = new ArrayList<Integer[]>();
				Integer a[] = {arr.get(i),i};
				temp.add(a);
				map.put(arr.get(i), temp);
			}
			
		}
		return null;
	}
}

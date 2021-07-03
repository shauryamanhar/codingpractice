package com.shaurya.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CatTroop {

	public static void main(String[] args) {
		List<Integer> h = new ArrayList<Integer>();
		h.addAll(Arrays.asList(1,2,3));
		int height = 5;
		int u=2;
		int v=3;
		getMinimunSecond(h, height, u, v);
	}
	static int getMinimunSecond(List<Integer> height,int h,int u,int v) {
		Collections.sort(height);
		int l =0 ,r = height.size()-1;
		while(l<r) {
			if(height.get(l)+height.get(r)<h) {
				System.out.printf("found pair %d+%d=%d\n",height.get(l),height.get(r),(height.get(l)+height.get(r)));
				l++;
				r--;
			}else {
				r--;
			}
		}
		return 0;
	}

}

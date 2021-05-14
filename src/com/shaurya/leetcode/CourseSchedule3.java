package com.shaurya.leetcode;

import java.util.Arrays;

public class CourseSchedule3 {

	public static void main(String[] args) {
		int c[][] = {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
		System.out.println(scheduleCourse(c));
	}

	static int scheduleCourse(int[][] c) {
		int curr = 0;
		int count = 0;
		Arrays.sort(c, (a, b) -> {
			if (a[1] != b[1]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});
		
		for(int end=0;end<c.length;end++) {
			if(curr+c[end][0]<=c[end][1]) {
				curr+=c[end][0];
				count++;
			}else {
                int max_i = end;
                for (int j = 0; j < end; j++) {
                    if (c[j][0] > c[max_i][0])
                        max_i = j;
                }
                if (c[max_i][0] > c[end][0]) {
                    curr += c[end][0] - c[max_i][0];
                }
                c[max_i][0] = -1;
			}
		}
		return count;
	}
}

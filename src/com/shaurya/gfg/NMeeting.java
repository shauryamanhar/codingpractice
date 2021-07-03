package com.shaurya.gfg;

import java.util.ArrayList;
import java.util.Collections;

public class NMeeting {
	public static int maxMeetings(int start[], int end[], int n) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(start[i], end[i]));
		}
		Collections.sort(list, (a, b) -> a.end - b.end);
		ArrayList<Pair> ans = new ArrayList<Pair>();
		ans.add(list.get(0));
		for (int i = 1; i < n; i++) {
			int size = ans.size();
			if (ans.get(size - 1).end < list.get(i).start) {
				ans.add(list.get(i));
			}
		}
		return ans.size();
	}// max

	static class Pair {
		int start, end;
		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}

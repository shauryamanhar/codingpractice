package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ConvexHull {

	public static void main(String[] args) {
		int x[][] = { { 0, 3 }, { 1, 1 }, { 2, 2 }, { 4, 4 }, { 0, 0 }, { 1, 2 }, { 3, 1 }, { 3, 3 } };
		int len = x.length;
		ConvexHull c = new ConvexHull();
		c.grahamScan(x, len);
	}

	void grahamScan(int[][] p, int size) {
		List<Point> points = new ArrayList<>();
		fillPoints(p, size, points);
		// find the bottom most point
		int yAxixMin = points.get(0).y;
		int min = 0;
		for (int i = 1; i < size; i++) {
			int y = points.get(i).y;
			if ((y < yAxixMin) || (y == yAxixMin && points.get(i).x < points.get(min).x)) {
				yAxixMin = y;
				min = i;
			}
		}
		System.out.println("Bottom Left point found is " + points.get(min));
		// now place minimum point in front
		Point minPoint = points.get(min);
		points.remove(min);
		size--;
		// sort point according to slope
		System.out.println("Before Sorting " + points);
		Comparator<Point> comp = (a,b)->{
			int orintation = orientation(minPoint, a, b);
			if (orintation == 0) {
				int distB = distSq(minPoint, b);
				int distA = distSq(minPoint, a);

				return distB > distA ? -1 : 1;
			}
			return orintation == 2 ? -1 : 1;
		};
		Collections.sort(points, comp);

		System.out.println("After sorting " + points);
		Set<Point> tobeRemove = new HashSet<Point>();
		for (int i = 0; i < points.size() - 1; i++) {
			System.out.println("working on " + points.get(i) + " " + points.get(i + 1) + " "
					+ orientation(minPoint, points.get(i), points.get(i + 1)));
			while (i < points.size() - 1 && orientation(minPoint, points.get(i), points.get(i + 1)) == 0) {
				System.out.println("Removed " + points.get(i));
				System.out.println("i " + i);
				tobeRemove.add(points.get(i));
				i++;
			}
		}
		for (Point temp : tobeRemove) {
			points.remove(temp);
		}
		if (points.size() < 3) {
			return;
		}

		Stack<Point> stack = new Stack<ConvexHull.Point>();
		stack.push(minPoint);
		stack.push(points.get(0));
		stack.push(points.get(1));
		System.out.println("Points " + points);
		System.out.println("Stack " + stack);
		System.out.println("=======");
		for (int i = 2; i < points.size(); i++) {
			Point temp = nextToTop(stack);
			System.out.println("Prcessing " + temp + " " + stack.peek() + " " + points.get(i) + " ori "
					+ orientation(temp, stack.peek(), points.get(i)));
			while (stack.size() > 1 && orientation(temp, stack.peek(), points.get(i)) != 2) {
				System.out.println("Poped " + stack.pop());
			}
			System.out.println("Stack " + stack);
			stack.push(points.get(i));
		}

		System.out.println("Printing all the points");
		while (!stack.isEmpty()) {
			Point point = stack.pop();
			System.out.println(point);
		}

	}

	Point nextToTop(Stack<Point> stack) {
		Point p = stack.pop();
		Point res = stack.peek();
		stack.push(p);
		return res;
	}

	int orientation(Point p, Point q, Point r) {
		int val = ((q.y - p.y) * (r.x - q.x)) - ((r.y - q.y) * (q.x - p.x));
		if (val == 0) {// straight line
			return 0;
		}
		if(val>0) {
			return 1;
		}else {
			return 2;
		}
	}

	int distSq(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	void fillPoints(int[][] p, int size, List<Point> points) {
		for (int i = 0; i < size; i++) {
			points.add(new Point(p[i][0], p[i][1]));
		}
	}

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "{" + x + "," + y + "}";
		}

	}
}

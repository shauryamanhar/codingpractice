package com.shaurya.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {
		int people[][] = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		Node p[] = new Node[people.length];
		for(int i=0;i<people.length;i++) {
			p[i] = new Node(people[i][0],people[i][1]);
		}
		Arrays.sort(p);
		int n = people.length;
		//rearrange
		int count=0;
		Node ans[] = new Node[n];
		for(int i=0;i<n;i++) {
			count=p[i].inFront;
			for(int j=0;j<n && count>=0;j++) {
				if(count==0 && ans[j]==null) {
					ans[j]=p[i];
					break;
				}
				if(ans[j]==null || (ans[j]!=null && ans[j].heigth>=p[i].heigth)) {
					count--;
				}else {
					continue;
				}
			}
		}
		for(int i=0;i<n;i++) {
			people[i]= ans[i].get();
		}
		print(ans);
	}
	
	public int[][] reconstructQueue(int[][] people) {
		Node p[] = new Node[people.length];
		for(int i=0;i<people.length;i++) {
			p[i] = new Node(people[i][0],people[i][1]);
		}
		Arrays.sort(p);
		int n = people.length;
		//rearrange
		int count=0;
		Node ans[] = new Node[n];
		for(int i=0;i<n;i++) {
			count=p[i].inFront;
			for(int j=0;j<n && count>=0;j++) {
				if(count==0 && ans[j]==null) {
					ans[j]=p[i];
					break;
				}
				if(ans[j]==null || (ans[j]!=null && ans[j].heigth>=p[i].heigth)) {
					count--;
				}else {
					continue;
				}
			}
		}
		for(int i=0;i<n;i++) {
			people[i]=ans[i].get();
		}
        return people;
    }
	
	
	static class Node implements Comparable<Node>{
		int heigth;
		int inFront;
		Node(int h,int in){
			this.heigth=h;
			this.inFront=in;
		}
		@Override
		public int compareTo(Node node) {
			if(heigth<node.heigth) {
				return -1;
			}else if(heigth>node.heigth) {
				return 1;
			}else {
				if(inFront<node.inFront) {
					return -1;
				}else if(inFront>node.inFront) {
					return 1;
				}else {
					return 0;
				}
			}
		}
		
		int[] get() {
			int a[] = {heigth,inFront};
			return a;
		}
	}
	
	static void print(Node a[]) {
		System.out.print("{");
		for(Node r:a) {
			System.out.print("{");
			if(r==null) {
				System.out.print("null");
				System.out.print("}");
				continue;
			}
			System.out.print(r.heigth+","+r.inFront);
			System.out.print("}");
		}
		System.out.println("}");
	}
}

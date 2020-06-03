package com.shaurya.leetcode;
//complete this
public class CousinsTree {
	public static void main(String[] args) {
		int parenty=0;
		int parentx=0;
		Integer a[] = {1,2,3,null,4,null,5};
		int parent[] = new int[2];
		System.out.println(depth(a,0,4,0));
		System.out.println(depth(a,0,5,0));
	}
	
	static class Pair{
		int parent;
		int level;
		Pair(int parent,int level){
			this.parent=parent;
			this.level=level;
		}
	}
	
	static Pair depth(Integer a[],int index,int find,int parent) {
		Pair  pair;
		if(index<0 || index>a.length) {
			return null;
		}
		if(a[index]==null) {
			return null;
		}
		if(a[index]==find) {
			pair = new Pair(a[index],1);
			return pair;
		}
		int left = 2*index+1;
		int right = left+1;
		int depth=Math.max(depth(a,left,find,index).level, depth(a,right,find,index).level)+1;
		return null;
	}
}

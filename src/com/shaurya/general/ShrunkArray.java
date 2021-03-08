package com.shaurya.general;

import java.util.*;
public class ShrunkArray {

	public static void main(String[] args) {
//		String a = "abcdeeeddcbfgf";
		String a = "abcd";
		List<String> l = new ArrayList<String>();
		for(char c:a.toCharArray()) {
			l.add(c+"");
		}
		System.out.println(l.toString());
		getShrunkArray(l, 1);
	}
	static List<String> getShrunkArray(List<String> ip,int bl){
		Stack<String> s = new Stack<String>();
		int count=1;
		s.add(ip.get(0));
		int i=0;
		while(i<ip.size()) {
			String top = s.peek();
			System.out.println("top "+top+" i "+ip.get(i)+" count "+count);
			if(top.equals(ip.get(i))) {
				count++;
			}
			if(!top.equals(ip.get(i))) {
				if(count>=bl) {
					for(int k=0;k<count;k++) {
						System.out.println("Pop "+s.pop());
					}
				}
				if(!s.isEmpty() && s.peek().equals(ip.get(i))) {
					count=2;
				}else {
					count=1;
				}
			}
			s.push(ip.get(i));
			i++;
		}
		System.out.println(s.toString());
		return null;
	}
	static void remove(List<String> ip,int s,int e) {
		for(int i=s;i<=e;i++) {
			ip.remove(i);
		}
	}

	

}

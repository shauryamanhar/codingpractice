package com.shaurya;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		reverse(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	static void reverse(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int data = s.pop();
		reverse(s);
		s.push(data);
	}

}

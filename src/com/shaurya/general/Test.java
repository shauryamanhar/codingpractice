package com.shaurya.general;
import java.util.*;
class Pair {
	char chars;
	int count;

	Pair(char chars, int count) {
		this.chars = chars;
		this.count = count;
	}
}

public class Test {
	public static void main(String[] args) {
		String s = "abcccdee";
		int k=3;
		System.out.println("input "+s);
		System.out.println("output: "+removeDuplicates(s, k));
	}
	public static String removeDuplicates(String s, int k) {
		if (k >= s.length())
			return s;
		if (k == 1)
			return "";
		char remove = ' ';
		Stack<Pair> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty())
				stack.push(new Pair(ch, 1));
			else {
				if (stack.peek().chars != ch && stack.peek().count >= k && remove == stack.peek().chars) {
					while (!stack.isEmpty() && stack.peek().chars == remove) {
						stack.pop();
					}
				}
				if (!stack.isEmpty() && ch == stack.peek().chars) {
					stack.push(new Pair(ch, stack.peek().count + 1));
					if (stack.peek().count >= k) {
						remove = stack.peek().chars;
					}
				} else
					stack.push(new Pair(ch, 1));
			}
		}
		StringBuilder str = new StringBuilder();
		while (!stack.isEmpty()) {
			str.append(stack.pop().chars);
		}
		return str.reverse().toString();
	}
}
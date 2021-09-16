package com.shaurya.leetcode;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		BasicCalculator b = new BasicCalculator();
		String eq = "1+1";
		int val = b.calculate(eq);
		System.out.println("val " + val);
	}

	public int calculate(String s) {
		Stack<Token> stack = new Stack<Token>();
		for (int i = 0; i < s.length(); i++) {
			System.out.println(stack);
			char c = s.charAt(i);
			if (c == '-') {
				stack.push(new Minus());
			} else if (c == '(') {
				stack.push(new Open());
			} else if (c == ')') {
				Token last = stack.pop();
				if (isTopOpen(stack)) {
					stack.pop();
					last.val = sumWithPrev(stack, last.val);
				}
				stack.push(last);
			} else if (isNumber(c)) {
				System.out.println("number");
				int num = c - '0';
				for (int j = i + 1; j < s.length(); j++) {
					char ch = s.charAt(j);
					if (!isNumber(ch)) {
						break;
					}
					num = num * 10 + (ch - '0');
					i = j;
				}
				num = sumWithPrev(stack, num);
				stack.push(new Number(num));
			}
		}
		return stack.peek().val;
	}

	boolean isOperator(char c) {
		return c == '+' || c == '-';
	}

	boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	class Token {
		boolean isOpen;
		boolean isNumber;
		boolean isMinus;
		int val;

		@Override
		public String toString() {
			return val + "";
		}

	}

	class Open extends Token {
		Open() {
			this.isOpen = true;
		}
	}

	class Minus extends Token {
		Minus() {
			this.isMinus = true;
		}
	}

	class Number extends Token {
		Number(int val) {
			this.val = val;
		}
	}

	boolean isTopOpen(Stack<Token> stack) {
		return !stack.isEmpty() && stack.peek().isOpen;
	}

	boolean isTopMinus(Stack<Token> stack) {
		return !stack.isEmpty() && stack.peek().isMinus;
	}

	boolean isTopNumber(Stack<Token> stack) {
		return !stack.isEmpty() && stack.peek().isNumber;
	}

	int sumWithPrev(Stack<Token> stack, int num) {
		if (isTopMinus(stack)) {
			stack.pop();
			num = -num;
		}
		if (isTopNumber(stack)) {
			num += stack.pop().val;
		}
		System.out.println("sum with prev " + num);
		return num;
	}

}

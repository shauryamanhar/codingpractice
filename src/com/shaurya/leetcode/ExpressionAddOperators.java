package com.shaurya.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionAddOperators {
	public static void main(String[] args) {
		String nums = "123";
		String op = "+-*";
		combination(nums, op, 0, "");
	}

	static Set<String> exp = new HashSet<String>();

	static void combination(String nums, String op, int curr, String partial) {
		if (curr == nums.length()) {
			if (!exp.contains(partial)) {
				System.out.println(partial);
				exp.add(partial);
			}
			return;
		}
		for (int i = 0; i < op.length(); i++) {
			if (curr == nums.length() - 1) {
				combination(nums, op, curr + 1, partial + nums.charAt(curr));
			} else {
				combination(nums, op, curr + 1, partial + nums.charAt(curr) + op.charAt(i));
			}
		}
	}

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList();
        addOperators(num, target, result, 0, 0, 0, "");
        return result;
    }

	private void addOperators(String num, int target, List<String> result, int index, long value, long previous,
			String current) {
		if (index == num.length()) {
			if (value + previous == target) {
				result.add(current);
			}
			return;
		}

		int end = num.length();
		if (num.charAt(index) == '0') {
			end = index + 1;
		}

		for (int i = index + 1; i <= end; i++) {
			long currentValue = Long.valueOf(num.substring(index, i));

			if (index == 0) {
				addOperators(num, target, result, i, 0, currentValue, String.valueOf(currentValue));
				continue;
			}

			// Add +
			addOperators(num, target, result, i, value + previous, currentValue, current + "+" + currentValue);
			// Add -
			addOperators(num, target, result, i, value + previous, -currentValue, current + "-" + currentValue);
			// Add *
			addOperators(num, target, result, i, value, previous * currentValue, current + "*" + currentValue);
		}
	}

}

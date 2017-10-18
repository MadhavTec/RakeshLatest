package com.techolution;

import java.util.Stack;

public class BalancedOrNot {

	static int countMinReversals(String expr) {
		int len = expr.length();
		if (len % 2 != 0) {
				expr = "<" + expr;
				len++;
		}
		Stack<Character> stck = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = expr.charAt(i);
			if (c == '>' && !stck.empty()) {
				if (stck.peek() == '<')
					stck.pop();
				else
					stck.push(c);
			} else
				stck.push(c);
		}

		int red_len = stck.size();
		int n = 0;
		while (!stck.empty() && stck.peek() == '<') {
			stck.pop();
			n++;
		}
		return (red_len / 2 + n % 2);
	}

	static int[] balancedOrNot(String[] expression, int[] maxReplacement) {
		int[] balancedOrNot = new int[maxReplacement.length];
		int i = 0;
		for (String exp : expression) {
			int val = countMinReversals(exp);
			if (val < 0)
				balancedOrNot[i] = 0;
			else {
				if (val > maxReplacement[i])
					balancedOrNot[i] = 0;
				else
					balancedOrNot[i] = 1;
			}
		}
		return balancedOrNot;
	}

	public static void main(String[] args) {
		String[] expr = { ">>" };
		int[] maxReplacement = { 2 };
		for (Integer res : balancedOrNot(expr, maxReplacement)) {
			System.out.println(res);
		}

	}

}

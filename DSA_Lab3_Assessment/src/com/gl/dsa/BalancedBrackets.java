package com.gl.dsa;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> bracketMap = new HashMap<>();
		bracketMap.put(')', '(');
		bracketMap.put('}', '{');
		bracketMap.put(']', '[');

		for (char ch : expression.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty() || bracketMap.get(ch) != stack.pop()) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string containing brackets: ");
		String inputString = sc.nextLine();

		if (isBalanced(inputString)) {
			System.out.println("The string contains balanced brackets.");
		} else {
			System.out.println("The string contains unbalanced brackets.");
		}
		
		sc.close();
	}
}

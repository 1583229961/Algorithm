package i.algorithm.dynamic;

import java.util.*;

public class MaxCommonArray {

	public static void Common(String a, String b) {
		int[][] dp = new int[a.length() + 1][b.length() + 1];
		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {

				if (b.charAt(j - 1) == a.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);

		Stack<Character> stack = new Stack<Character>();
		int i = a.length() - 1;
		int j = b.length() - 1;
		while ((i >= 0) && (j >= 0)) {
			if (b.charAt(j) == a.charAt(i)) {
				char temp = b.charAt(j);
				stack.push(temp);
				i--;
				j--;
			} 
			else {
				if (dp[i + 1][j] > dp[i][j + 1]) {
					j--;
				} else {
					i--;
				}
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}

	public static void main(String[] args) {
		String a = "abcfdef";
		String b = "bkgdcfe";
		Common(a, b);
	}

}

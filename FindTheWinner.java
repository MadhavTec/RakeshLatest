package com.techolution;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinner {

	public static void main(String[] args) {
		int[] andria = { 1, 2, 3 };
		int[] maria = { 2, 1, 3 };
		String game = "Even";
		String res = winner(andria, maria, game);
		System.out.println(res);
	}

	static String winner(int[] andria, int[] maria, String game) {
		int n = andria.length > maria.length ? maria.length : andria.length;
		List<Integer> permissibleIndex = new ArrayList<Integer>();
		boolean isOdd = game.equalsIgnoreCase("ODD");
		
		for (int i = 0; i < n; i++) {
			if (i % 2 != 0 && isOdd) {
				permissibleIndex.add(i);
			} else if (!isOdd && i % 2 == 0)
				permissibleIndex.add(i);
		}
		int andriaSum=0,mariaSum=0;
		for (Integer val : permissibleIndex) {
			andriaSum+=andria[val]-maria[val];
			mariaSum+=maria[val]-andria[val];
		}
		if(andriaSum==mariaSum)
			return "Tie";
		return (andriaSum>mariaSum)?"Andria":"Maria";
		
	}
}

package com.techolution;

import java.util.ArrayList;

//TODO incomplete Code
public class CountingGroups {
	public static void main(String[] args) {
		int[][] ar = { { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 } };
		int n = 5;
		ArrayList<Integer> grps = new ArrayList<Integer>();
		grps.add(1);
		grps.add(2);
		grps.add(3);
		grps.add(4);
		grps.add(5);
		for (int k = 0; k < grps.size(); k++) {
			int count = 0, grpCount = 0;
			boolean flag = false;
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (ar[i][j] == 1) {
						if (ar[i + 1][j] == 1) {
							count++;
						}
						if (ar[i][j + 1] == 1) {
							count++;
						}
					}
					if (count == grps.get(k)) {
						grpCount++;
						count = 0;
						flag = true;
					}
				}
				
			}
			System.out.println(" Count "+count);
			if (grpCount > 0)
				System.out.println("k--> " + grpCount);
			else
				System.out.println("k--> " + 0);
		}
	}

}

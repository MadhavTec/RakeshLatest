package com.techolution;

import java.util.ArrayList;
import java.util.List;

public class LargestSubsetSum {

	public static void main(String[] args) {
		int[] k = {2,36};
		long []res=maxSubsetSum(k);
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
		
	}

	public static long[] maxSubsetSum(int[] k) {
		long[] res = new long[k.length];
		for (int i = 0; i < k.length; i++) {
			int m=k[i];
			List<Integer> setNum = new ArrayList<Integer>();
			setNum.add(1);
			for (int j = 2; j < m; j++) {
				if (m % j == 0)
					setNum.add(j);
			}
			setNum.add(m);
			int sum = 0;//setNum.stream().mapToInt(r -> r.intValue()).sum();//java 8 lambda used
			for(Integer val:setNum){
				sum=sum+val;
			}
			res[i]=sum;
		}
		return res;
	}

}
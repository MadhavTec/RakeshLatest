package com.techolution;

public class ConsecutiveSum {

	public static void main(String[] args) {
		long num=10;
		System.out.println(consecutive(num));
	}

	static int consecutive(long num){
		 long start = 1, end = 1;
		    long sum = 1;
		    int res=0;
		    while (start <= num/2)
		    {
		        if (sum < num)
		        {
		            end += 1;
		            sum += end;
		        }
		        else if (sum > num)
		        {
		            sum -= start;
		            start += 1;
		        }
		        else if (sum == num)
		        {
		            sum -= start;
		            start += 1;
		            res++;
		        }
		    }
		    return res;

	}
	
}

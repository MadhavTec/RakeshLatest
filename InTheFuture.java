package com.techolution;

public class InTheFuture {

	public static void main(String[] args) {
		int A=1;
		int K=3;
		int P=100;
		System.out.println(minNum(A,K,P));
	}
	static int minNum(int A,int K,int P){
		if(A>K)
			return -1;
		int numOfProblemsByA=A+P;
		int day=1;
		int kFreq=K;
		while(numOfProblemsByA>=K){
			numOfProblemsByA+=A;
			K+=kFreq;
			day++;
		}
		return day;
	}
}

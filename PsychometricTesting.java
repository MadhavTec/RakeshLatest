package com.techolution;

public class PsychometricTesting {

	public static void main(String[] args) {
		int []scores={4,8,7};
		int []lowerLimits={2,4};
		int []upperLimits={8,4};
		int []offers=jobOffers(scores, lowerLimits, upperLimits);
		System.out.println();
		for(int i=0;i<offers.length;i++)
			System.out.printf("%d ",offers[i]);
		System.out.println();

	}
	public static int[] jobOffers(int []scores,int []lowerLimit,int []upperLimits){
		int []numOfCandidate=new int[lowerLimit.length];
		for(int i=0;i<lowerLimit.length;i++){
			int numOfCand=0;
			int low=lowerLimit[i];int high=upperLimits[i];
			for(int j=0;j<scores.length;j++){
				if(scores[j]<=high&&scores[j]>=low)
					numOfCand++;
			}
			numOfCandidate[i]=numOfCand;
		}
		return numOfCandidate;
	}

}

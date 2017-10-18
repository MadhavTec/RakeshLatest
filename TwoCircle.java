package com.techolution;

import java.util.HashMap;
import java.util.Map;

public class TwoCircle {
	private static Map<Integer, String> state = new HashMap<Integer, String>();
	static {
		state.put(1, "Touching");
		state.put(2, "Concentric");
		state.put(3, "Intersecting");
		state.put(4, "Disjoint-Outside");
		state.put(5, "Disjoint-Inside");
	}

	public static void main(String[] args) {
		String[] info = { 
						  "0 5 9 0 2 2",
						  "0 5 9 0 9 7",
						  "0 15 11 0 20 16", 
						  "26 0 10 39 0 23", 
						  "37 0 5 30 0 11", 
						  "107 0 5 30 0 11", 
					      "41 0 0 28 0 13", 
					     };
		String[] res = circles(info, info.length);
		for (String val : res) {
			System.out.println(val);
		}
	}

	public static String[] circles(String[] info, int n) {
		String[] res = new String[n];
		int i = 0;
		for (String s : info) {
			String[] inp = s.split(" ");
			int cX = Integer.parseInt(inp[0]);
			int cY = Integer.parseInt(inp[1]);
			int cR = Integer.parseInt(inp[2]);
			int dX = Integer.parseInt(inp[3]);
			int dY = Integer.parseInt(inp[4]);
			int dR = Integer.parseInt(inp[5]);
			res[i] = state.get(getRes(cX, cY, cR, dX, dY, dR));
			i++;
		}
		return res;
	}
	
	private static Integer getRes(int cX, int cY, int cR, int dX, int dY, int dR) {
		int distance = (int)Math.sqrt((cX - dX) * (cX - dX) + (cY - dY) * (cY - dY));
		int circleDist = Math.abs(dR + cR);
		if(distance==0&&Math.abs(dR-cR)>0)
			return 2;
		int smallCircleRadius=0;//cR>dR?dR:cR;
		int largeCircleRadius=0;
		if(cR>dR){
			smallCircleRadius=dR;
			largeCircleRadius=cR;
		}
		else{
			smallCircleRadius=cR;
			largeCircleRadius=dR;
		}
		if((distance+smallCircleRadius)<largeCircleRadius)
			return 5;
		if (distance == circleDist||distance==(Math.abs(dR-cR)))
			return 1;
		if(distance<circleDist)
			return 3;
		else
			return 4;
		
		
	}
}

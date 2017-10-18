package com.techolution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class LargeResponses {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		String fileNameFullPath = LargeResponses.class.getResource(fileName + ".txt").getFile();
		File file = new File(fileNameFullPath);
		BigInteger res = BigInteger.valueOf(0L);
		int cnt = 0;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] lineComp = line.split(" ");
				long sizeResp = 0L;
				try {
					sizeResp = Long.parseLong(lineComp[lineComp.length - 1]);
					if (sizeResp > 5000) {
						cnt++;
						res = res.add(BigInteger.valueOf(sizeResp));
					}
				} catch (NumberFormatException exp) {

				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String outputFileName = "bytes_" + fileName + ".txt";
		File opFile=new File(outputFileName);
		opFile.createNewFile();
		BufferedWriter out = new BufferedWriter(new FileWriter(opFile));
		out.write(String.valueOf(cnt));
		out.newLine();
		out.write(res.toString());
		out.flush();
		System.out.println("Generated File Location is "+opFile.getAbsolutePath());
	}

}

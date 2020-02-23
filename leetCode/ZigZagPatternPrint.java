package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZigZagPatternPrint {
	
	private static String getZigZagString(String str, int rowNum) {
		
		int row = 0; boolean down = true;
		
		if(rowNum == 1)
			return str;
		
		String arr[] = new String[rowNum];
		Arrays.fill(arr, "");
		
		String result = "";
		
		for(int i=0; i < str.length(); i++) {
			arr[row] += str.charAt(i);
			
			if(row == rowNum -1)
				down = false;
			else if(row == 0)
				down = true;
			
			if(down)
				row++;
			else
				row--;
		}
		
		for(int i=0; i<rowNum; i++) {
			result += arr[i];
		}
		
		return result;	
	}	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int rowNum = Integer.parseInt(br.readLine());
		
		String zigZagStr = getZigZagString(str, rowNum);
		System.out.println("String in zig zag form = "+zigZagStr);
		
	}


}

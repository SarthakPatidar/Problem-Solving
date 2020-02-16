package leetCode;

import java.util.*;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length <= 0) 
			return "";
		
		return LCP(strs, 0, strs.length-1);
	}
	
	public static String LCP(String[] strs, int l, int r) {
		if(l == r)
			return strs[l];
		else {
			int mid = l+(r-l)/2;
			
			String lcpLeft = LCP(strs, l, mid);
			String lcpRight = LCP(strs, mid+1, r);
			
			return commonPrefix(lcpLeft,lcpRight);
			
		}
	}
	
	private static String commonPrefix(String lcpLeft, String lcpRight) {
		int minimum = Math.min(lcpLeft.length(), lcpRight.length());
		
		for(int i=0; i<minimum; i++) {
			if(lcpRight.charAt(i) != lcpLeft.charAt(i)) {
				return lcpRight.substring(0, i);
			}
		}
		
		return lcpRight.substring(0, minimum);
	}

	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		
		for(int i=0;i<n;i++)
			strs[i] = sc.nextLine();
		
		String result = longestCommonPrefix(strs);
		System.out.println("Longest Common Prefix = "+ result);
		sc.close();
		
	}
}

package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String palindrome = longestPalindromicSubstring(str);
		System.out.println("Longest Palindromic Substring = "+ palindrome);
	}

	private static String longestPalindromicSubstring(String str) {
		int len = str.length();
		boolean dp[][] = new boolean[len][len];
		int maxLength = 0;
		String ans = "";
		
		for(int j=0; j < len; j++) {
			for(int i=0; i <= j; i++) {
				boolean judge = str.charAt(i) == str.charAt(j);
				
				dp[i][j] = (j-i) > 2 ? dp[i+1][j-1] && judge : judge;
				
				if(dp[i][j] && maxLength < j-i+1) {
					maxLength = j-i+1;
					ans = str.substring(i,j+1);
				}
			}
		}
		return ans;
	}
}

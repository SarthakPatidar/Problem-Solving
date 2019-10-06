package spoj.classical;

import java.util.*;

public class NextPalindromeNumber {

	public static boolean isPalindrome(String str) {

		int l = 0;
		int r = str.length() - 1;

		while (r > l) {
			if (str.charAt(l) == str.charAt(r)) {
				r--;
				l++;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t, input;
		t = s.nextInt();

		while (t > 0) {
			input = s.nextInt();
			input += 1;
			while (!isPalindrome(Integer.toString(input))) {
				input += 1;
			}

			System.out.println(input);
			t--;
		}

		s.close();
	}

}

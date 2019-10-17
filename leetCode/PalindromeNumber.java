package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FindSolution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;

		int reverse = 0;

		while (x > reverse) {
			reverse = 10 * reverse + x % 10;
			x = x / 10;
		}

		return x == reverse || x == reverse / 10;
	}
}

public class PalindromeNumber {
	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int x = Integer.parseInt(line);

			boolean ret = new FindSolution().isPalindrome(x);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}
}
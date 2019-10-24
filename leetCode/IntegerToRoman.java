package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerToRoman {

	public static String intToRoman(int num) {
		int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] codes = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		String res = "";
		int i = 0;

		while (num > 0) {
			int quotient = num / values[i];

			while (quotient > 0) {
				res += codes[i];
				quotient--;
			}

			num = num % values[i];
			i++;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int num = Integer.parseInt(line);
			String ret = intToRoman(num);
			String out = (ret);
			System.out.print(out);
		}
	}
}
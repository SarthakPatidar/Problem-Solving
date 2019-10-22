package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestSubStrWithoutRepChars {
	public static String stringToString(String input) {
		return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}

	/*
	 * Implement this method
	 */
	public static int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, window_size = 0, size = s.length(), max_size = 0;
		ArrayList<Character> hs = new ArrayList<Character>();

		while (right < size) {
			if (hs.contains(s.charAt(right))) {
				int index = hs.indexOf(s.charAt(right));
				hs.subList(0, index + 1).clear();
				left = left + index + 1;
			}

			hs.add(s.charAt(right));
			right++;

			window_size = right - left;
			max_size = (max_size < window_size) ? window_size : max_size;
		}
		
		return max_size;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String s = stringToString(line);

			int ret = lengthOfLongestSubstring(s);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
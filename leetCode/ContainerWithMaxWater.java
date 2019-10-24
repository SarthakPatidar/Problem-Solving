package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainerWithMaxWater {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	/*
	 * Implement this method
	 */
	public static int maxArea(int[] height) {
		int l = 0, r = height.length - 1, area = 0, max_area = 0;
		while (r > l) {
			area = (r - l) * Math.min(height[r], height[l]);
			max_area = (area > max_area) ? area : max_area;

			if (height[r] > height[l])
				l++;
			else
				r--;
		}
		return max_area;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] height = stringToIntegerArray(line);

			int ret = maxArea(height);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
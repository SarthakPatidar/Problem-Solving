package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ParanthesisBalancing {

	public static boolean isValid(String s) {
		int n = s.length();
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
				st.push(s.charAt(i));

			else if (st.size() <= 0)
				return false;

			else {
				char top = st.peek();

				if ((top == '(' && s.charAt(i) == ')') || (top == '{' && s.charAt(i) == '}')
						|| (top == '[' && s.charAt(i) == ']')) {
					st.pop();
				} else
					return false;
			}
		}

		if (st.size() <= 0)
			return true;

		return false;
	}

	public static String stringToString(String input) {
		return JsonArray.readFrom("[" + input + "]").get(0).asString();
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			String s = stringToString(line);

			boolean ret = isValid(s);

			String out = booleanToString(ret);

			System.out.print(out);
		}
	}
}
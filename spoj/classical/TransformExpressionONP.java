package spoj.classical;

import java.util.*;

public class TransformExpressionONP {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String str;
		int t;

		t = sc.nextInt();

		while (t > 0) {
			str = sc.next();
			String sol = new String();
			Stack<Character> st = new Stack<Character>();

			for (int i = 0; i < str.length(); i++) {
				char currChar = str.charAt(i);

				if (currChar == '(') {
					continue;
				} else if (currChar == '+' || currChar == '-' || currChar == '*' || currChar == '/' || currChar == '^') {
					st.push(currChar);
				} else if (currChar == ')') {
					sol += st.pop();
				} else {
					sol += currChar;
				}

			}

			System.out.println(sol);
			t -= 1;
		}

		sc.close();
	}
}

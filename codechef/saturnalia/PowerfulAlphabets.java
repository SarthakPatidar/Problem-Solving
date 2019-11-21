package codechef.saturnalia;

import java.util.*;

public class PowerfulAlphabets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		String str;

		while (n > 0) {
			int first[] = new int[32];
			for (int i = 0; i < 32; i++) {
				first[i] = -1;
			}

			int last[] = new int[32];

			str = sc.nextLine();

			for (int i = 0; i < str.length(); i++) {
				if (first[(int) str.charAt(i) - 97] == -1) {
					first[(int) str.charAt(i) - 97] = i;
				} else {
					last[(int) str.charAt(i) - 97] = i;
				}
			}

			int max = last[0] - first[0];
			char c = 'a';

			for (int i = 1; i < 32; i++) {
				if (max < (last[i] - first[i])) {
					max = (last[i] - first[i]);
					c = (char) (i + 97);
				}
			}

			System.out.println(c + " " + max);
			n--;
		}
		sc.close();
	}
}

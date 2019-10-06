package spoj.classical;

import java.util.*;

public class PrimeGenerator {

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		if (n <= 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t, start, end;

		t = s.nextInt();
		while (t > 0) {
			start = s.nextInt();
			end = s.nextInt();

			for (int i = start; i <= end; i++) {
				if (isPrime(i)) {
					System.out.println(i);
				}
			}

			t -= 1;
			System.out.println();
		}

		s.close();
	}

}

package generalMaths;

import java.util.*;

public class XorPairs {
	public static void main(String args[]) {
		int n, x, result, curr_xor;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		result = 0;
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {

			curr_xor = arr[i] ^ x;

			if (hp.containsKey(curr_xor)) {
				result += hp.get(curr_xor);
			}

			if (hp.containsKey(arr[i])) {
				hp.put(arr[i], hp.get(arr[i]) + 1);
			} else {
				hp.put(arr[i], 1);
			}
		}

		System.out.println(result);
		sc.close();
	}
}

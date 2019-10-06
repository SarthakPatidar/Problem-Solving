package hackerEarth.augustEasy19.splitHouses;

import java.util.*;

class splitHouse {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int n, num = 0;
		n = s.nextInt();
		char arr[] = s.next().toCharArray();

		s.close();

		for(int i=0;i<n;i++) {
			if(arr[i] == '.') {
				arr[i] = 'B';
				num = 0;
			}
			if(arr[i] == 'H' && num > 0) {
				System.out.print("NO");
				return;
			}
			if(arr[i] == 'H' && num <= 0) {
				num += 1;
			}
		}

		System.out.println("YES");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]);
		}
	}
}

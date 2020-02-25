package geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletWithZeroSum {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int arr[] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		boolean found = false;
		
		int n = arr.length;
		
		for(int i=0; i< n; i++) {
			int x = arr[i];
			int left = i+1;
			int right = n - 1;
			
			while(left < right) {
				if(x + arr[left] + arr[right] == 0) {
					System.out.print(arr[left] + " ");
					System.out.print(x + " ");
					System.out.println(arr[right]);
					
					left++;
					right--;
					found = true;
				}
				else if(x + arr[left] + arr[right] < 0)
					left++;
				else if(x + arr[left] + arr[right] > 0)
					right--;
			}
			if(!found)
				System.out.println("No Such Triplet");
		}
	}
}

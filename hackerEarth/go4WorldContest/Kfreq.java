package hackerEarth.go4WorldContest;

import java.util.*;

public class Kfreq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		
		while(t > 0)
		{
			sc.nextLine();
			String s = sc.nextLine();
			int k = sc.nextInt();
			
			int[] arr = new int[32];
			for(int i=0;i<s.length();i++)
			{
				arr[s.charAt(i) - 97] += 1;
			}	
			
			ArrayList<Integer> freq = new ArrayList<Integer>();
			for(int i=0;i<arr.length;i++)
			{
				if(!freq.contains(arr[i]) && arr[i] > 0)
					freq.add(arr[i]);
			}
			
			Collections.sort(freq, Collections.reverseOrder());
			
			if(k > freq.size())
			{
				System.out.println("-1");
			}
			else
			{
				int reqFreq = freq.get(k-1);
				for(int i=0;i<arr.length;i++)
				{
					if(arr[i] == reqFreq)
					{
						System.out.println((char)(arr[i] + 97));
						break;					
					}
				}					
			}
						
			t--;
		}
		
		sc.close();
		
	}

}

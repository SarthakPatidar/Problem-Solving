package codechef.ispc2019;

import java.util.*;

public class MinGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t,n,i,d,b;
		t = sc.nextInt();
		
		while(t > 0)
		{
			n = sc.nextInt();
			i = 0; d = 0; b = 0;
			while(i<n)
			{
			  d += sc.nextInt();
				i++;
				
				if(i<n)
				{
				  b += sc.nextInt();	
				  i++;
				}
			}
			
			if(b > d)
				System.out.println("Boots");
			else if (d > b)
				System.out.println("Dora");
			else
			{
				if(n % 2 == 0)
					System.out.println("Boots");
				else
					System.out.println("Dora");
			}		
			t--;
		}
		sc.close();
	}

}

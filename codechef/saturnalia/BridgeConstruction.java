package codechef.saturnalia;

import java.util.*;

public class BridgeConstruction {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int total,visited;
		
		while(t > 0)
		{
			total = sc.nextInt();
			visited = sc.nextInt();
			
			ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
			ArrayList<Integer> remNodes = new ArrayList<Integer>();
			
			for(int i=0;i<visited;i++)
			{
				int src = sc.nextInt();
				int dest = sc.nextInt();
				
				if(!visitedNodes.contains(src))
					visitedNodes.add(src);
				
				if(!visitedNodes.contains(dest))
					visitedNodes.add(dest);				
			}
			
			for(int i=1;i<=total;i++)
			{
				if(!visitedNodes.contains(i)) {
					remNodes.add(i);
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0;i<visited;i++)
			{
					min = Math.min(min, visitedNodes.get(i));				
			}			
			
			int sum = 0;
			for(int i=0;i<remNodes.size();i++)
			{
					sum += min*remNodes.get(i);			
			}
			
			System.out.println(sum);
			
			t--;
		}
		sc.close();
	}
}

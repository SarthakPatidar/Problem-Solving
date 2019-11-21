package codechef.zcoPractice;

import java.util.*;

public class VideoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width, height;
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		
		int arr[] = new int[width];
		
		for(int i=0;i<width;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int command = sc.nextInt();
		int inHand = 0, index = 0;
		
		while(command != 0)
		{
			// 1 -> Left, 2 -> Right, 3 -> Pick, 4 -> Drop, 0 -> Quit 
			if(command == 3 && inHand <= 0 && arr[index] > 0)
			{
				inHand = 1;
				arr[index] -= 1;
			}
			
			else if(command == 2 && index+1 < width)
				index++;

			else if(command == 1 && index-1 >= 0)
				index--;
			
			else if(command == 4 && arr[index] < height && inHand > 0)
			{
				inHand = 0;
				arr[index] += 1;
			}
			
			command = sc.nextInt();
		}
		
		for(int i=0;i<width;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		sc.close();
	}

}

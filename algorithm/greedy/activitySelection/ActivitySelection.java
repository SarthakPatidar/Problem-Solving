/*
 * EXAMPLE 
 *	 Consider the following 6 activities 
 *		 start[]  =  {1, 3, 0, 5, 8, 5};
 *		 finish[] =  {2, 4, 6, 7, 9, 9};
 *		 A person can perform at most four activities. The 
 *		 maximum set of activities that can be executed 
 *		 is {0, 1, 3, 4} [These are indexes in start[] and finish[]]
 *
 * APPROACH
 * 1) Sort the activities according to their finishing time
 *	 2) Select the first activity from the sorted array and print it.
 *	 3) Do following for remaining activities in the sorted array.
 *			a) If the start time of this activity is greater than or equal 
 *				 to the finish time of previously selected activity then 
 *         select this activity and print it.
 */

package algorithm.greedy.activitySelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActivitySelection {

	public static void main(String args[]) {
		int n,count=1;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		
		List<Activity> actList = new ArrayList<Activity>();
		
		for(int i=0;i<n;i++) {
			 Activity act = new Activity();
			 act.start = s.nextInt();
			 act.finish = s.nextInt();
			 actList.add(act);
		}
		
		Collections.sort(actList);
		
		int finish = actList.get(0).finish;
		
		for(int i=1;i<n;i++) {
				if(actList.get(i).start >= finish) {
					count += 1;
					finish = actList.get(i).finish;
				}
		}
		
		System.out.println("Maximum number of activities that can be performed = "+count);
		s.close();	
	}
}

package algorithm.greedy.activitySelection;

public class Activity implements Comparable<Activity>{
	int start;
	int finish;
	
	@Override
	public int compareTo(Activity o) {
		// TODO Auto-generated method stub
		return finish - o.finish;
	}
	
}

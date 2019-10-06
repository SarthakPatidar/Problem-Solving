package rangeQuery.moAlgorithm;

public class Query implements Comparable<Query> {

	int l, r, index, block;

	public Query(int l, int r, int index, int n) {
		this.l = l;
		this.r = r;
		this.index = index;
		this.block = (int) Math.sqrt(n);
	}

	@Override
	public int compareTo(Query q) {
		// TODO Auto-generated method stub
		if (q.l / block != l / block) {
			return l / block - q.l / block;
		}
		return r - q.r;
	}

}

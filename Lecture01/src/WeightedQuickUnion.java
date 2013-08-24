
public class WeightedQuickUnion {
	
	int[] id;
	int[] sz;
	
	public WeightedQuickUnion(int n){
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		if(sz[i] < sz[j])
			{ id[i] = j; sz[j] += sz[i];}
		else
			{ id[j] = i; sz[i] += sz[j];}
	}
	
	private int root(int i) {
		while(i != id[i]) i = id[i];
		return i;
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < id.length; i++){
			if(i > 0) sb.append(" ");
			sb.append(String.valueOf(id[i]));
		}
		return sb.toString();
	}
	
	

}

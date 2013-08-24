public class QuickFind {

	int[] id;

	public QuickFind(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid)
				id[i] = qid;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < id.length; i++) {
			if (i > 0)
				sb.append(" ");
			sb.append(String.valueOf(id[i]));
		}
		return sb.toString();
	}

}

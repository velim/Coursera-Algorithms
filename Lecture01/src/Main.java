public class Main {

	public static void main(String[] args) {

		QuickFind qf = new QuickFind(10);
		// 0-5 9-6 9-2 4-3 2-3 0-6
		System.out.println(qf.toString());
		qf.union(0, 5);
		System.out.println(qf.toString());
		qf.union(9, 6);
		System.out.println(qf.toString());
		qf.union(9, 2);
		System.out.println(qf.toString());
		qf.union(4, 3);
		System.out.println(qf.toString());
		qf.union(2, 3);
		System.out.println(qf.toString());
		qf.union(0, 6);
		System.out.println(qf.toString());

		System.out.println("- - - - - -");

		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		// 4-8 1-9 3-5 2-7 6-4 7-9 5-4 3-9 4-0
		System.out.println(wqu.toString());
		wqu.union(4, 8);
		System.out.println(wqu.toString());
		wqu.union(1, 9);
		System.out.println(wqu.toString());
		wqu.union(3, 5);
		System.out.println(wqu.toString());
		wqu.union(2, 7);
		System.out.println(wqu.toString());
		wqu.union(6, 4);
		System.out.println(wqu.toString());
		wqu.union(7, 9);
		System.out.println(wqu.toString());
		wqu.union(5, 4);
		System.out.println(wqu.toString());
		wqu.union(3, 9);
		System.out.println(wqu.toString());
		wqu.union(4, 0);
		System.out.println(wqu.toString());

	}

}

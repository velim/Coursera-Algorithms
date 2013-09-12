public class MyShell {

	public static void sort(Comparable[] a, int c) {

		int N = a.length;
		int h = 1;

		while (h < N / 3)
			h = 3 * h + 1;

		while (h >= 1) {
			System.out.println(h);
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			printA(a);
			h = h / 3;
		}

	}

	private static boolean less(Comparable<Comparable> c1, Comparable c2) {
		return  c1.compareTo(c2) < 0;
	}

	private static void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static void printA(Comparable[] a) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++){
			sb.append(a[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}

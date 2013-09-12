public class ExWeek21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t = new In(args[0]).readAllInts();
		Integer[] a = new Integer[t.length];
		for (int i = 0; i < t.length; i++)
			a[i] = t[i];
		MyShell.sort(a, 4);
		
	}

}

public class Percolation {

    private int n;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF wqu1;
    private WeightedQuickUnionUF wqu2;
    private boolean[] open;

    /**
     * create N-by-N grid, with all sites blocked
     * 
     * @param N
     */
    public Percolation(int N) {
        n = N;
        top = n * n;
        bottom = n * n + 1;
        wqu1 = new WeightedQuickUnionUF((n * n) + 2);
        wqu2 = new WeightedQuickUnionUF((n * n) + 2);
        open = new boolean[n * n];
        for (int i = 0; i < open.length; i++)
            open[i] = false;

    }

    /**
     * open site (row i, column j) if it is not already
     * 
     * @param i
     * @param j
     */
    public void open(int i, int j) {
        checkIndicesBounds(i, j);
        int mi = i - 1;
        int mj = j - 1;

        int self = xyToInt(mi, mj);
        int up = xyToInt(mi - 1, mj);
        int down = xyToInt(mi + 1, mj);
        int left = xyToInt(mi, mj - 1);
        int right = xyToInt(mi, mj + 1);

        open[self] = true;

        if (mi == 0) {
            wqu1.union(self, top);
            wqu2.union(self, top);
        }

        if (mi == (n - 1))
            wqu1.union(self, bottom);

        // top
        if (mi > 0 && open[up]) {
            wqu1.union(self, up);
            wqu2.union(self, up);
        }

        // bottom
        if (mi < (n - 1) && open[down]) {
            wqu1.union(self, down);
            wqu2.union(self, down);
        }

        // left
        if (mj > 0 && open[left]) {
            wqu1.union(self, left);
            wqu2.union(self, left);
        }

        // right
        if (mj < (n - 1) && open[right]) {
            wqu1.union(self, right);
            wqu2.union(self, right);
        }

        /*
         * if (isFull(i, j)) for (int x = 1; x <= n; x++) if (isOpen(n, x) &&
         * isFull(n, x)) wqu.union(xyToInt(n - 1, x - 1), bottom);
         */

    }

    /**
     * is site (row i, column j) open?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j) {
        checkIndicesBounds(i, j);
        return open[xyToInt(i - 1, j - 1)];
    }

    /**
     * is site (row i, column j) full?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j) {
        checkIndicesBounds(i, j);
        return wqu1.connected(xyToInt(i - 1, j - 1), top);
    }

    /**
     * does the system percolate?
     * 
     * @return
     */
    public boolean percolates() {
        return wqu1.connected(top, bottom);
    }

    /**
     * 
     * @param i
     * @param j
     * 
     */
    private void checkIndicesBounds(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new java.lang.IndexOutOfBoundsException();
    }

    /**
     * 
     * @param i
     * @param j
     * 
     */
    private int xyToInt(int i, int j) {
        return i * n + j;
    }
}

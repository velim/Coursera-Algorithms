public class Percolation {

	private int n;

	class Site {
		boolean open;
		boolean full;
		Site top;
		Site left;
		Site bottom;
		Site right;

		public Site() {
			open = false;
		}

	}

	private Site[][] grid;
	private Site[] top;
	private Site[] bottom;
	private int siteSopen;

	/**
	 * create N-by-N grid, with all sites blocked
	 * 
	 * @param N
	 */
	public Percolation(int N) {
		n = N;
		grid = new Site[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = new Site();

		top = new Site[n];
		for (int i = 0; i < n; i++)
			top[i] = grid[0][i];

		bottom = new Site[n];
		for (int i = 0; i < n; i++)
			bottom[i] = grid[n - 1][i];

	}

	/**
	 * open site (row i, column j) if it is not already
	 * 
	 * @param i
	 * @param j
	 */
	public void open(int i, int j) {
		
		Site site = grid[i][j]; 
		site.open = true;
		
		if (i == 0)
			site.full = true;

		// top
		if (i > 0 && grid[i - 1][j].open) {
			site.top = grid[i - 1][j];
			grid[i - 1][j].bottom = site;
			if (grid[i - 1][j].full)
				site.full = true;
		}

		// bottom
		if (i < (n-1) && grid[i + 1][j].open) {
			site.bottom = grid[i + 1][j];
			grid[i + 1][j].top = site;
			if (grid[i + 1][j].full)
				site.full = true;
		}

		// left
		if (j > 0 && grid[i][j - 1].open) {
			site.left = grid[i][j - 1];
			grid[i][j - 1].right = site;
			if (grid[i][j - 1].full)
				site.full = true;
		}

		// right
		if (j < (n-1) && grid[i][j + 1].open) {
			site.right = grid[i][j + 1];
			grid[i][j + 1].left = site;
			if (grid[i][j + 1].full)
				site.full = true;
		}

		if(site.full){
			fillAround(site);
		}
		
		siteSopen++;
	}



	private void fillAround(Site site) {
		fillSite(site.top);
		fillSite(site.bottom);
		fillSite(site.left);
		fillSite(site.right);
		
	}

	private void fillSite(Site site) {
		if((site != null) && !site.full){
			site.full = true;
			fillAround(site);
		}
		
	}

	/**
	 * is site (row i, column j) open?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isOpen(int i, int j) {
		return grid[i][j].open;
	}

	/**
	 * is site (row i, column j) full?
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isFull(int i, int j) {
		return grid[i][j].full;
	}

	/**
	 * does the system percolate?
	 * 
	 * @return
	 */
	public boolean percolates() {
		for (Site site : bottom)
			if (site.full)
				return true;
		return false;
	}
	
	public int getSiteSopen() {
		return siteSopen;
	}

}

import java.util.Random;

public class PercolationStats {
	/**
	 * perform T independent computational experiments on an N-by-N grid
	 * 
	 * @param N
	 * @param T
	 */
	private double[] fractions;
	private double mean;
	private int t;
	private double stddev;
	private double confidence;

	public PercolationStats(int N, int T) {
		this.t = T;
		fractions = new double[this.t];
		for (int i = 0; i < this.t; i++) {
			Percolation percolation = new Percolation(N);
			Random rand = new Random();
			while (!percolation.percolates()) {

				int ni = rand.nextInt(N);
				int nj = rand.nextInt(N);
				if (percolation.isOpen(ni, nj))
					continue;

				percolation.open(ni, nj);

			}
			fractions[i] = (double) percolation.getSiteSopen() / (N * N);
			percolation = null;
			System.gc();
		}
		
		double tmp = 0.0;
		for (double val : this.fractions)
			tmp += val;
		this.mean = tmp / this.t;
		
		tmp = 0.0;
		for (double val : this.fractions)
			tmp += Math.pow(val - this.mean, 2);
		this.stddev = tmp / (this.t - 1);
		
		confidence = (1.96*this.stddev)/Math.sqrt(this.t);
	}

	/**
	 * sample mean of percolation threshold
	 * 
	 * @return
	 */
	public double mean() {
		return this.mean;

	}

	/**
	 * sample standard deviation of percolation threshold
	 * 
	 * @return
	 */
	public double stddev() {
		return this.stddev;
	}

	/**
	 * returns lower bound of the 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceLo() {
		return this.mean - this.confidence;

	}

	/**
	 * returns upper bound of the 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceHi() {
		return this.mean + this.confidence;

	}

	/**
	 * test client, described below
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PercolationStats stats = new PercolationStats(200, 200);
		System.out.println(String.format("mean\t= %.10f", stats.mean()));
		System.out.println(String.format("stddev\t= %.10f", stats.stddev()));
		System.out.println(String.format("95%% confidence interval\t= %.10f, %.10f", stats.confidenceLo(),stats.confidenceHi()));

	}
}

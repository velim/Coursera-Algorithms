import java.lang.IllegalArgumentException;

public class PercolationStats {
    
    private int t;
    private double[] fractions;
    private double mean;
    private double stddev;
    private double confidence;
    private int count = 0;
    
    /**
     * perform T independent computational experiments on an N-by-N grid
     * 
     * @param N
     * @param T
     */

    public PercolationStats(int N, int T) {
        
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        
        this.t = T;
        fractions = new double[this.t];
        for (int i = 0; i < this.t; i++) {
            Percolation percolation = new Percolation(N);
            count = 0;

            while (!percolation.percolates()) {
                int item = StdRandom.uniform(N*N);
                int ni = (item % N)+1;
                int nj = (item / N)+1;
                //System.out.println(ni+" "+nj);
                if (percolation.isOpen(ni, nj))
                    continue;
                percolation.open(ni, nj);

                count++;
            }
            fractions[i] = (double) count / (N*N);
        }

        
        this.mean = StdStats.mean(fractions);
        this.stddev = StdStats.stddev(fractions);
        this.confidence = (1.96*this.stddev)/Math.sqrt(T);
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

        System.out.println(args[0]);
        System.out.println(args[1]);

        PercolationStats stats = new PercolationStats(Integer.valueOf(args[0]),
                Integer.valueOf(args[1]));
        System.out.println(String.format("mean\t= %.10f", stats.mean()));
        System.out.println(String.format("stddev\t= %.10f", stats.stddev()));
        System.out.println(String.format(
                "95%% confidence interval\t= %.10f, %.10f",
                stats.confidenceLo(), stats.confidenceHi()));

    }
}

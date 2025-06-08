class Solution {
    public long maximumProfit(int[] prices, int k) {
        int c = prices.length;
        if (c < 2) {
            return 0L;
        }
        int d = Math.min(k, c / 2);
        long[][] e = new long[d + 1][c];
        for (int i = 0; i <= d; i++) {
            e[i][0] = 0L;
        }
        for (int j = 0; j < c; j++) {
            e[0][j] = 0L;
        }
        for (int i = 1; i <= d; i++) {
            long f = -prices[0];
            long g = prices[0];
            for (int j = 1; j < c; j++) {
                long h = e[i][j - 1];
                long m = f + prices[j];
                if (m > h) {
                    h = m;
                }
                long n = g - prices[j];
                if (n > h) {
                    h = n;
                }
                e[i][j] = h;
                long u = e[i - 1][j - 1] - prices[j];
                if (u > f) {
                    f = u;
                }
                long v = e[i - 1][j - 1] + prices[j];
                if (v > g) {
                    g = v;
                }
            }
        }
        return e[d][c - 1];
    }
}

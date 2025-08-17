class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) return 1.0;
        if (n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double sum = 1.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) {
                sum += dp[i];
            }
            if (i >= maxPts) {
                sum -= dp[i - maxPts];
            }
        }

        double result = 0.0;
        for (int i = k; i <= n; i++) {
            result += dp[i];
        }

        return result;
    }
}

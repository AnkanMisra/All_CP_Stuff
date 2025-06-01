class Solution {
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[n + 1][100];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int ans = recurse(1, 0, dp, x, n, m);
        return ans;
    }

    static int recurse(int i, int sum, int dp[][], int target, int n, int m) {
        if (i > n && target == sum)
            return 1;
        if (i > n)
            return 0;
        if (sum > target)
            return 0;
        if (dp[i][sum] != -1)
            return dp[i][sum];

        int value = 0;
        for (int k = 1; k <= m; k++) {
            value += recurse(i + 1, sum + k, dp, target, n, m);
        }
        return dp[i][sum] = value;

    }
}

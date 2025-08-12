class Solution {
    public int numSquares(int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            arr.add(i * i);
        }
        int[][] dp = new int[arr.size() + 1][n + 1];
        for (int i = 0; i <= arr.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, arr.size(), n, dp);
    }
    public int helper(List<Integer> arr, int idx, int target, int[][] dp) {
        if (target == 0) return 0;
        if (idx == 0) return Integer.MAX_VALUE - 1;

        if (dp[idx][target] != -1) return dp[idx][target];

        if (target >= arr.get(idx - 1)) {
            dp[idx][target] = Math.min(
                1 + helper(arr, idx, target - arr.get(idx - 1), dp),
                helper(arr, idx - 1, target, dp)
            );
        } else {
            dp[idx][target] = helper(arr, idx - 1, target, dp);
        }
        return dp[idx][target];
    }
}

class Solution {
    public int maximumLength(int[] nums) {
        int[][] dp = new int[2][2]; 
        int ans = 0;
        for (int x : nums) {
            int r = x % 2;
            for (int y = 0; y < 2; y++) {
                dp[r][y] = dp[y][r] + 1;
                ans = Math.max(ans, dp[r][y]);
            }
        }
        return ans;
    }
}
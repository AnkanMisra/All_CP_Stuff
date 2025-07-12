class Solution {
    public int maxGold(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int ans = 0;
        int[][] dp = new int[n][m];
        for(int i =0; i < n; i++) {
            dp[i][0] = mat[i][0];
        }
        for(int[] arr : dp) Arrays.fill(arr, -1);
        for(int i =0; i < n; i++) {
            ans = Math.max(ans, helper(i, 0, mat, dp));
        }
        return ans;
        
    }
    
    public int helper(int i, int j, int[][] mat, int[][]dp) {
        if(i < 0 || i >= mat.length || j >= mat[0].length) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int sum = 0;
        sum += mat[i][j];
        int tempSum = 0;
        tempSum = Math.max(helper(i-1, j+1, mat, dp), Math.max(helper(i, j+1, mat, dp), helper(i+1, j +1, mat, dp)));
        
        return dp[i][j] = sum + tempSum;
    }
}
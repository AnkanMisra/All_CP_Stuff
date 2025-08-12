class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = (int)1e9 + 7;
        for(int i = 1; i <= n; i++){
            int val = (int) Math.pow(i, x);
            if(val > n){
                break;
            }
            int[] next = new int[n + 1];
            for(int j = 0; j <= n; j++){
                next[j] = dp[j];
                if(j >= val){
                    next[j] += dp[j - val];
                    next[j] %= mod;
                }
            }
            dp = next;
        }
        return dp[n];
    }
}

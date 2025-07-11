class Solution {
    
    int fun(int i, int prev, int n, int[][] dp){
        if(i == n-1) return 1;
        
        if(dp[i][prev] != -1) return dp[i][prev];
        
        if(prev == 0){
            dp[i][prev] = fun(i+1, 0, n, dp) + fun(i+1, 1, n, dp);
        }
        else{
            dp[i][prev] = fun(i+1, 0, n, dp);
        }
        
        return dp[i][prev];
        
    }
    
    
    public int countConsec(int n) {
        
        int i, j;
        
        int first = 0;
        int second = 1;
        
        for(i=2; i <= n+2; i++){
            int c = first + second;
            first = second;
            second = c;
        }
        
        return (1<<n) - second;
        
    }
    
}
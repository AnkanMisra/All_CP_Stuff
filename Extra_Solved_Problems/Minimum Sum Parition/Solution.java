class Solution {
    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j =0;j<sum+1;j++){
                if(i==0) dp[0][j] = false;
                if(j==0) dp[i][0] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j =1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        boolean[] range = new boolean[sum+1/2];

        for(int i=0;i<sum+1/2;i++){
            range[i] = dp[n][i];
            if(range[i] == true){
                minDiff = Math.min(minDiff, Math.abs(sum-2*i));
            }
        }

        return minDiff;

    }
}

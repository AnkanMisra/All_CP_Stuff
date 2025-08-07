class Solution {
    public int solve1(int i, int j, int arr[][], Integer memo1[][], int n, int d_limit) {
        if(i<0||i>=n||j<0||j>=n||i>=j || (i==n-1 && j==n-1)) {
            return 0 ;
        }
        if(memo1[i][j]!=null) {
            return memo1[i][j] ;
        }
        int ans1 = arr[i][j] + solve1(i+1, j, arr, memo1, n, d_limit) ;
        int ans2 = arr[i][j] +solve1(i+1, j-1, arr, memo1, n, d_limit-1) ;
        int ans3 = arr[i][j] +solve1(i+1, j+1, arr, memo1, n, d_limit) ;
        return memo1[i][j] = Math.max(ans1, Math.max(ans2, ans3)) ;
    }
    public int solve2(int i, int j, int arr[][], Integer memo2[][], int n, int d_limit) {
        if(i<0||i>=n||j<0||j>=n||j>=i|| (i==n-1 && j==n-1)) {
            return 0 ;
        }
        if(memo2[i][j]!=null) {
            return memo2[i][j] ;
        }
        int ans1 = arr[i][j] +solve2(i, j+1, arr, memo2, n, d_limit) ;
        int ans2 = arr[i][j] +solve2(i-1, j+1, arr, memo2, n, d_limit-1) ;
        int ans3 = arr[i][j] +solve2(i+1, j+1, arr, memo2, n, d_limit) ;
        return memo2[i][j] = Math.max(ans1, Math.max(ans2, ans3)) ;
    }

    public int maxCollectedFruits(int[][] arr) {
        int n = arr.length ;
        Integer memo1[][] = new Integer[n][n] ;
        Integer memo2[][] = new Integer[n][n] ;
        int d_limit = (int)Math.floor(n/2)-2 ;
        int ans = 0 ;
        for(int i=0; i<n; i++) {
            ans += arr[i][i] ;
            //arr[i][i] = -1 ;
        }
        ans += solve1(0,n-1,arr, memo1, n, d_limit) ;
        ans += solve2(n-1,0,arr, memo2, n, d_limit) ;
        return ans ;

    }
}

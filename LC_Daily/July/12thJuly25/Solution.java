import java.util.*;

public class Solution {

    public int[] earliestAndLatest(int n, int a, int b) {
        dp = new int[n + 1][n + 1][n + 1][2];
        return recMemo(n, a, b);
    }

    int[] recMemo(int n, int a, int b) {
        if (n == 2 || a + b == n + 1) return new int[]{1, 1};
        if (dp[n][a][b][0] != 0) return dp[n][a][b];
        if (a > b) return recMemo(n, b, a);
        if (a + b > n + 1) return recMemo(n, n - b + 1, n - a + 1);

        int nextN = (n + 1) / 2;
        dp[n][a][b][0] = Integer.MAX_VALUE / 2;
        dp[n][a][b][1] = Integer.MIN_VALUE / 2;

        if (b <= nextN) {
            for (int x = 0; x < a; x++) {
                for (int y = 0; y < b - a; y++) {
                    int[] case1 = recMemo(nextN, x + 1, x + 1 + y + 1);
                    dp[n][a][b][0] = Math.min(dp[n][a][b][0], 1 + case1[0]);
                    dp[n][a][b][1] = Math.max(dp[n][a][b][1], 1 + case1[1]);
                }
            }
        } else {
            int bb = n + 1 - b;
            for (int x = 0; x < a; x++) {
                for (int y = 0; y < bb - a; y++) {
                    int bToBb = b - bb - 1;
                    int z = (bToBb + 1) / 2;
                    int[] case2 = recMemo(nextN, x + 1, x + 1 + y + 1 + z);
                    dp[n][a][b][0] = Math.min(dp[n][a][b][0], 1 + case2[0]);
                    dp[n][a][b][1] = Math.max(dp[n][a][b][1], 1 + case2[1]);
                }
            }
        }

        return dp[n][a][b];
    }

    int[][][][] dp;

}

/*
 * author  : Ankan Misra
 * created : 2025-07-03 at 16:09:26 PM IST
 * editor  : nvim
 * blame the bugs on me, not the editor
 */

import java.io.*;
import java.util.*;

public class Solution {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = 1_000_000_007;
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = nextIntArray(n);
        int answer = minimumRestDays(a);
        out.println(answer);
        out.flush();
        out.close();
    }

    static int minimumRestDays(int[] a) {
        int n = a.length;
        final int INF_INT = 101;
        int[][] dp = new int[n + 1][3];
        for (int[] row : dp) Arrays.fill(row, INF_INT);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int val = a[i - 1];
            int bestPrev = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]));
            dp[i][0] = bestPrev + 1;
            if (val == 1 || val == 3) {
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            }
            if (val == 2 || val == 3) {
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }

    // ---Utility ---
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd((int)a, (int)b) * b;
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
        return arr;
    }

    //---FastReader---
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

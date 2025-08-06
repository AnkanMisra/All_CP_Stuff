/*
 * author  : Ankan Misra
 * created : 2025-08-06 at 20:41:50 PM IST
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
        int k = sc.nextInt();
        int d = sc.nextInt();
        solve(n, k, d);
        out.flush();
        out.close();
    }

    static void solve(int n, int k, int d) {
        long[] dpAll = new long[n + 1];
        long[] dpSmall = new long[n + 1];

        dpAll[0] = 1;
        dpSmall[0] = 1;

        for (int sum = 1; sum <= n; sum++) {
            long total = 0;
            long small = 0;
            for (int w = 1; w <= k; w++) {
                if (sum - w < 0) break;
                total += dpAll[sum - w];
                if (w < d) {
                    small += dpSmall[sum - w];
                }
            }
            dpAll[sum] = total % MOD;
            dpSmall[sum] = small % MOD;
        }

        long ans = (dpAll[n] - dpSmall[n]) % MOD;
        if (ans < 0) ans += MOD;
        out.println(ans);
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

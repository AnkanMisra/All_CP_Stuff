/*
 * author  : Ankan Misra
 * created : 2025-08-18 at 15:29:26 PM IST
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
        solve();
        out.flush();
        out.close();
    }

    static void solve() {
        long n = sc.nextLong();
        if (n == 1) {
            out.println(1);
            return;
        }
        if (n == 2) {
            out.println(2);
            return;
        }
        if (n == 3) {
            out.println(6);
            return;
        }
        long ans;
        if ((n & 1) == 1) {
            ans = n * (n - 1) * (n - 2);
        } else {
            long cand1 = lcm(n, n - 1, n - 3);
            long cand2 = lcm(n - 1, n - 2, n - 3);
            ans = Math.max(cand1, cand2);
        }
        out.println(ans);
    }

    // ---Utility ---
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long lcm(long a, long b, long c) {
        return lcm(lcm(a, b), c);
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

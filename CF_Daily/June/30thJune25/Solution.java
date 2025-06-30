/*
 * author  : Ankan Misra
 * created : 2025-06-30 at 19:32:10 PM IST
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
        int m = sc.nextInt();
        int s = sc.nextInt();

        if ((s == 0 && m > 1) || s > 9 * m) {
            out.println("-1 -1");
            return;
        }

        if (s == 0 && m == 1) {
            out.println("0 0");
            return;
        }

        int remaining = s;
        int[] minDigits = new int[m];

        remaining -= 1;
        for (int i = m - 1; i >= 0; i--) {
            int digit = Math.min(9, Math.max(0, remaining));
            minDigits[i] = digit;
            remaining -= digit;
        }
        minDigits[0] += 1;

        StringBuilder minNumber = new StringBuilder();
        for (int d : minDigits) minNumber.append(d);

        remaining = s;
        int[] maxDigits = new int[m];
        for (int i = 0; i < m; i++) {
            int digit = Math.min(9, remaining);
            maxDigits[i] = digit;
            remaining -= digit;
        }

        StringBuilder maxNumber = new StringBuilder();
        for (int d : maxDigits) maxNumber.append(d);

        out.println(minNumber.toString() + " " + maxNumber.toString());
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

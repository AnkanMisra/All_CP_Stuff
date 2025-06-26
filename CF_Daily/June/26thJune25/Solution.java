/*
 * author  : Ankan Misra
 * created : 2025-06-26 at 17:25:19 PM IST
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
        String a = sc.next();
        int b = a.length();

        for (int c = 0; c < b; c++) {
            int d = a.charAt(c) - '0';
            if (d % 8 == 0) {
                out.println("YES");
                out.println(d);
                return;
            }
        }

        for (int c = 0; c < b; c++) {
            if (a.charAt(c) == '0') {
                continue;
            }
            for (int d = c + 1; d < b; d++) {
                int e = (a.charAt(c) - '0') * 10 + (a.charAt(d) - '0');
                if (e % 8 == 0) {
                    out.println("YES");
                    out.println("" + a.charAt(c) + a.charAt(d));
                    return;
                }
            }
        }

        for (int c = 0; c < b; c++) {
            if (a.charAt(c) == '0') {
                continue;
            }
            for (int d = c + 1; d < b; d++) {
                for (int e = d + 1; e < b; e++) {
                    int f = (a.charAt(c) - '0') * 100 + (a.charAt(d) - '0') * 10 + (a.charAt(e) - '0');
                    if (f % 8 == 0) {
                        out.println("YES");
                        out.println("" + a.charAt(c) + a.charAt(d) + a.charAt(e));
                        return;
                    }
                }
            }
        }

        out.println("NO");
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

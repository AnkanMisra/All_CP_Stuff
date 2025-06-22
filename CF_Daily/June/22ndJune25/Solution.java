// created by AnkanMisra at 2025-06-22 and 18:33:03 IST 
// written in nvim, but blame the bugs on me

import java.io.*;
import java.util.*;

public class Solution {
    static FastReader sc = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = 1_000_000_007;
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) {
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        char[][] d = new char[a][b];
        for (int e = 0; e < a; e++) {
            String f = sc.next();
            d[e] = f.toCharArray();
        }

        int[][] g = new int[a + 1][b + 1];
        int h = 0;
        for (int i = 0; i < a; i++) {
            int j = 0;
            for (int k = 0; k < b; k++) {
                if (d[i][k] == 'g') {
                    j++;
                    h++;
                } else {

                }
                g[i + 1][k + 1] = g[i][k + 1] + j;
            }
        }

        int l = c - 1;
        int m = Integer.MAX_VALUE;
        for (int n = 0; n < a; n++) {
            for (int o = 0; o < b; o++) {
                if (d[n][o] != '.') {
                    continue;
                } else {
                    int p = countGold(g,
                            Math.max(0, n - l),
                            Math.max(0, o - l),
                            Math.min(a - 1, n + l),
                            Math.min(b - 1, o + l));
                    if (p < m) {
                        m = p;
                    } else {

                    }
                }
            }
        }

        if (m == Integer.MAX_VALUE) {
            m = 0;
        } else {

        }

        out.println(h - m);
    }

    static int countGold(int[][] q, int r, int s, int t, int u) {
        if (r > t || s > u) {
            return 0;
        } else {
            r++;
            s++;
            t++;
            u++;
            return q[t][u] - q[r - 1][u] - q[t][s - 1] + q[r - 1][s - 1];
        }
    }

    // ---Utility ---
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd((int) a, (int) b) * b;
    }

    static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        return arr;
    }

    // ---FastReader---
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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

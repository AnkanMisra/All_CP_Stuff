// created by AnkanMisra at 2025-06-21 and 20:31:11 IST 
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
        long b = sc.nextLong();

        if (a == 1) {
            if (b == 1) {
                out.println(1);
            } else {
                out.println(-1);
            }
            return;
        }

        long c = a;
        long d = (long) a * (a + 1L) / 2L;
        if (b < c || b > d) {
            out.println(-1);
            return;
        }

        if (b == c) {
            out.println(1);
            for (int e = 2; e <= a; e++) {
                out.println("1 " + e);
            }
            return;
        }

        int f = -1;
        long g = 0;
        for (int h = 2; h <= a; h++) {
            long i = ((long) h) * a - ((long) h) * (h - 1L) / 2L;
            long j = a + h - 1L;
            if (b >= j && b <= i) {
                f = h;
                g = i;
                break;
            }
        }

        if (f == -1) {
            out.println(-1);
            return;
        }

        int[] k = new int[a + 1];
        k[f] = 0;
        k[1] = f;
        for (int l = 2; l <= a; l++) {
            if (l == f) continue;
            k[l] = f;
        }

        long m = g - b;
        if (m < 0) m = 0;

        long n = f - 1L;

        for (int o = a; o > f && m >= n; o--) {
            k[o] = 1;
            m -= n;
        }

        for (int p = f - 1; p >= 2 && m > 0; p--) {
            long q = p - 1L;
            if (q <= m) {
                k[p] = 1;
                m -= q;
            }
        }

        out.println(f);
        for (int r = 1; r <= a; r++) {
            if (r == f) continue;
            out.println(k[r] + " " + r);
        }
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
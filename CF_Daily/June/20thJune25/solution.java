// created by AnkanMisra at 2025-06-20 and 19:24:22 IST 
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
        int q = sc.nextInt();
        ArrayDeque<Long> dq = new ArrayDeque<>();
        long sum = 0;
        long rizz = 0;
        boolean rev = false;

        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            if (s == 3) {
                long k = sc.nextLong();
                long m = dq.size();
                long newPos = m + 1;
                rizz += k * newPos;
                sum += k;
                if (!rev) {
                    dq.addLast(k);
                } else {
                    dq.addFirst(k);
                }
            } else if (s == 1) {
                int m = dq.size();
                long x;
                if (!rev) {
                    x = dq.removeLast();
                    dq.addFirst(x);
                } else {
                    x = dq.removeFirst();
                    dq.addLast(x);
                }
                rizz = rizz - x * m + sum;
            } else {
                int m = dq.size();
                rizz = (long) (m + 1) * sum - rizz;
                rev = !rev;
            }
            out.println(rizz);
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

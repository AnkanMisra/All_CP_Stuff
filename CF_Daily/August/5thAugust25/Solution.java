/*
 * author  : Ankan Misra
 * created : 2025-08-05 at 18:10:24 PM IST
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
        String recipe = sc.next();
        long nb = sc.nextLong();
        long ns = sc.nextLong();
        long nc = sc.nextLong();
        long pb = sc.nextLong();
        long ps = sc.nextLong();
        long pc = sc.nextLong();
        long r = sc.nextLong();

        long reqB = 0, reqS = 0, reqC = 0;
        for (char ch : recipe.toCharArray()) {
            if (ch == 'B') reqB++;
            else if (ch == 'S') reqS++;
            else if (ch == 'C') reqC++;
        }

        long low = 0, high = (long)1e13;
        while (low <= high) {
            long mid = (low + high) >> 1;

            long needB = Math.max(0, reqB * mid - nb);
            long needS = Math.max(0, reqS * mid - ns);
            long needC = Math.max(0, reqC * mid - nc);

            long cost = needB * pb + needS * ps + needC * pc;
            if (cost <= r) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        out.println(high);
        return;
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

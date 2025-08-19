/*
 * author  : Ankan Misra
 * created : 2025-08-19 at 20:20:08 PM IST
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
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve() {
        int n = sc.nextInt();
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            int len1 = o1[1] - o1[0];
            int len2 = o2[1] - o2[0];
            if (len1 != len2) return len2 - len1;
            return o1[0] - o2[0];
        });
        pq.add(new int[]{0, n - 1});
        for (int i = 1; i <= n; i++) {
            int[] seg = pq.poll();
            int l = seg[0];
            int r = seg[1];
            int len = r - l + 1;
            int mid;
            if (len % 2 == 1) {
                mid = (l + r) / 2;
            } else {
                mid = (l + r - 1) / 2;
            }
            ans[mid] = i;
            if (l <= mid - 1) pq.add(new int[]{l, mid - 1});
            if (mid + 1 <= r) pq.add(new int[]{mid + 1, r});
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) out.print(" ");
            out.print(ans[i]);
        }
        out.println();
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

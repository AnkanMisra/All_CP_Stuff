/*
 * author  : Ankan Misra
 * created : 2025-07-17 at 18:06:14 PM IST
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
        String firstToken = sc.nextLine();
        if (firstToken == null || firstToken.isEmpty()) {
            return;
        }
        firstToken = firstToken.trim();
        if (isNumeric(firstToken)) {
            int testcases = Integer.parseInt(firstToken);
            for (int t = 0; t < testcases; t++) {
                String s = sc.nextLine();
                if (s == null || s.isEmpty()) {
                    s = sc.next();
                }
                solve(s.trim());
            }
        } else {
            solve(firstToken);
        }
        out.flush();
        out.close();
    }

    static void solve(String s) {
        boolean ok = false;
        int idxAB = s.indexOf("AB");
        if (idxAB != -1) {
            int idxBAAfter = s.indexOf("BA", idxAB + 2);
            if (idxBAAfter != -1) ok = true;
        }
        int idxBA = s.indexOf("BA");
        if (!ok && idxBA != -1) {
            int idxABAfter = s.indexOf("AB", idxBA + 2);
            if (idxABAfter != -1) ok = true;
        }
        out.println(ok ? "YES" : "NO");
    }

    static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return !str.isEmpty();
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

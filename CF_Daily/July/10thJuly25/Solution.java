/*
 * author  : Ankan Misra
 * created : 2025-07-10 at 21:03:42 PM IST
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
        int[] freq = new int[n + 2]; 
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val <= n) freq[val]++;
        }

        int[] diff = new int[n + 2];
        boolean prefixGood = true;  

        for (int mex = 0; mex <= n; mex++) {
            if (prefixGood) {
                int L = freq[mex];  
                int R = n - mex;    
                if (L <= R) {
                    diff[L]++;
                    diff[R + 1]--;
                }
            }
            if (freq[mex] == 0) prefixGood = false; 
        }

        StringBuilder sb = new StringBuilder();
        int current = 0;
        for (int k = 0; k <= n; k++) {
            current += diff[k];
            sb.append(current);
            if (k < n) sb.append(' ');
        }
        out.println(sb.toString());
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

/*
 * author  : Ankan Misra
 * created : 2025-06-28 at 20:48:58 PM IST
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
        int count = sc.nextInt();
        for (int idx = 0; idx < count; idx++) {
            long num = sc.nextLong();
            if (isTPrime(num)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }

    static boolean isTPrime(long val) {
        long root = (long) Math.sqrt(val);
        
        if (root * root != val) {
            return false;
        }
        
        return isPrime(root);
    }

    static boolean isPrime(long val) {
        if (val < 2) {
            return false;
        }
        if (val == 2) {
            return true;
        }
        if (val % 2 == 0) {
            return false;
        }
        
        for (long i = 3; i * i <= val; i += 2) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
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

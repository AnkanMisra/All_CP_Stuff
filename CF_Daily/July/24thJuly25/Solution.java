/*
 * author  : Ankan Misra
 * created : 2025-07-24 at 22:51:49 PM IST
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
        int[] s = nextIntArray(n);
        int[] dp = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            int pos = i + 1;
            for(int j = 1; j * j <= pos; j++){
                if(pos % j == 0){
                    int d1 = j;
                    if(d1 < pos){
                        int prev = d1 - 1;
                        if(s[prev] < s[i]){
                            dp[i] = Math.max(dp[i], dp[prev] + 1);
                        }
                    }
                    int d2 = pos / j;
                    if(d2 != d1 && d2 < pos){
                        int prev = d2 - 1;
                        if(s[prev] < s[i]){
                            dp[i] = Math.max(dp[i], dp[prev] + 1);
                        }
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        out.println(ans);
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

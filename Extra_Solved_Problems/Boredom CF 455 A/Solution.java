
/*
 * author  : Ankan Misra
 * created : 2025-06-24 at 20:10:52 PM IST
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
        int smol = sc.nextInt();
        int[] smolarr = nextIntArray(smol);
        int smolmax = 0;
        for (int smolval : smolarr)
            smolmax = Math.max(smolmax, smolval);

        long[] smolcnt = new long[smolmax + 2];
        for (int smolval : smolarr)
            smolcnt[smolval]++;

        long[] smoldp = new long[smolmax + 2];
        smoldp[0] = 0;
        smoldp[1] = smolcnt[1];
        for (int smoli = 2; smoli <= smolmax; smoli++) {
            smoldp[smoli] = Math.max(smoldp[smoli - 1], smoldp[smoli - 2] + smolcnt[smoli] * smoli);
        }
        out.println(smoldp[smolmax]);
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

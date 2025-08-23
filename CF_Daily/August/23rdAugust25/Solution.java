/*
 * author  : Ankan Misra
 * created : 2025-08-23 at 17:09:08 PM IST
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
        long[] divisors = new long[n];

        for (int i = 0; i < n; i++) {
            divisors[i] = sc.nextLong();
        }

        Arrays.sort(divisors);

        long candidateX = divisors[0] * divisors[n-1];

        Set<Long> allDivisors = new HashSet<>();
        for (long i = 1; i * i <= candidateX; i++) {
            if (candidateX % i == 0) {
                allDivisors.add(i);
                if (i != candidateX / i) {
                    allDivisors.add(candidateX / i);
                }
            }
        }
        allDivisors.remove(1L);
        allDivisors.remove(candidateX);
        long[] generatedDivisors = allDivisors.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(generatedDivisors);

        if (generatedDivisors.length == n && Arrays.equals(divisors, generatedDivisors)) {
            out.println(candidateX);
        } else {
            out.println(-1);
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

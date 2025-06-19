
// created by AnkanMisra at 2025-06-19 and 15:33:26 IST
// written in nvim, blame the bugs on me
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
        long k = sc.nextLong();
        String s = sc.next();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        final long BIG_NEG = -1_000_000_000_000_000_000L;

        long best = Long.MIN_VALUE;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur = (cur > 0 ? cur : 0) + arr[i];
                if (cur > best)
                    best = cur;
            } else {
                cur = 0;
            }
        }
        if (best == Long.MIN_VALUE)
            best = 0;

        if (best > k) {
            out.println("No");
            return;
        }

        int unknownCnt = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0')
                unknownCnt++;

        long[] res = new long[n];
        for (int i = 0; i < n; i++)
            res[i] = arr[i];

        if (best == k) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0')
                    res[i] = BIG_NEG;
            }
            out.println("Yes");
            printArray(res);
            return;
        }

        if (unknownCnt == 0) {
            out.println("No");
            return;
        }

        long[] suffix = new long[n];
        cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur = Math.max(arr[i], cur + arr[i]);
                suffix[i] = cur;
            } else {
                cur = 0;
                suffix[i] = 0;
            }
        }

        long[] prefix = new long[n];
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cur = Math.max(arr[i], cur + arr[i]);
                prefix[i] = cur;
            } else {
                cur = 0;
                prefix[i] = 0;
            }
        }

        int idx = -1;
        long leftContrib = 0, rightContrib = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                long l = (i > 0) ? Math.max(0, suffix[i - 1]) : 0;
                long r = (i + 1 < n) ? Math.max(0, prefix[i + 1]) : 0;
                idx = i;
                leftContrib = l;
                rightContrib = r;
                break;
            }
        }

        long val = k - leftContrib - rightContrib;

        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0')
                res[i] = BIG_NEG;
        res[idx] = val;

        out.println("Yes");
        printArray(res);
    }

    static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i]);
            if (i + 1 < arr.length)
                out.print(' ');
        }
        out.println();
    }

    // --- Utility functions ---
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
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        return arr;
    }

    // ---FastReader implementation for faster input---
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

# Solution Explanation

## Intuition
The problem asks if a number `x` can be represented as a sum of any number of 11, 111, 1111, ... (i.e., numbers consisting only of 1's, with at least two digits). The key insight is that any such number can be written as a sum of 11 and 111, since 1111 = 111 + 11*9, and so on. Thus, it suffices to check if `x` can be written as `x = 111*k + 11*m` for non-negative integers `k` and `m`.

## Approach
- For each test case, try all possible values of `k` such that `111*k <= x` (since 111 is the largest "building block").
- For each `k`, check if the remainder `x - 111*k` is divisible by 11.
- If such a `k` exists, print "YES"; otherwise, print "NO".
- Since 111*k grows quickly, we only need to check up to about 100 values of `k` for any reasonable `x`.

## Complexity
- **Time Complexity:** O(1) per test case (since the loop runs at most 100 times).
- **Space Complexity:** O(1).

## Summary
**By checking all possible combinations of 111 and 11 that sum to `x`, we can efficiently determine if `x` can be formed as required.**  
This approach is efficient and leverages the properties of the numbers involved.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-25 at 18:41:26 PM IST
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
        long x = sc.nextLong();
        boolean ok = false;
        for (int k = 0; k <= 100 && 111L * k <= x; k++) {
            if ((x - 111L * k) % 11 == 0) {
                ok = true;
                break;
            }
        }
        out.println(ok ? "YES" : "NO");
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

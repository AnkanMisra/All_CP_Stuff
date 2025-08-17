

# Solution Explanation

## Intuition
The key observation is that adding the same value `bj` to every element of the array `a` does **not** change the pairwise differences between elements of `a`. The GCD of a set of numbers remains the same if each number is reduced by the same amount. Therefore, instead of recomputing the GCD for all `n` numbers in every query, we can:
1. Pre-compute the GCD of **all pairwise differences** in the array `a` (relative to one fixed element, e.g. `a1`). Call this pre-computed value `g`.
2. For each query value `bj`, the required result is simply `GCD(a1 + bj, g)`.

## Approach
1. **Preprocessing**
   • Fix `base = a1`.
   • Compute `g = GCD(|ai − base|)` for all `i = 2 … n`.
   • This takes `O(n)` time.
2. **Answering each query**
   • For each `bj`, output `GCD(base + bj, g)`.
3. The GCD between two numbers can be found with the Euclidean algorithm in `O(log V)` where `V` is their magnitude (≤ `10^18`).

## Complexity
- **Preprocessing:**
  • Time: `O(n)` (one GCD per element after the first)
  • Space: `O(1)`
- **Per Query:**
  • Time: `O(log 10^18)` ≈ `O(60)` (negligible)
  • Space: `O(1)`
- **Total:**
  • Time: `O(n + m log 10^18)`
  • Space: `O(1)`

## Summary
By factoring out the common GCD `g` of all differences in the original array, each query is reduced to computing the GCD of just two numbers: `a1 + bj` and `g`. This leverages the property that `GCD(x + k, y + k) = GCD(x, y)` and allows all queries to be answered in `O(1)` (amortised) after an `O(n)` preprocessing step.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-17 at 19:27:40 PM IST
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = nextLongArray(n);
        long g = 0;
        for (int i = 1; i < n; i++) {
            g = gcd(g, Math.abs(a[i] - a[0]));
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            long bVal = sc.nextLong();
            long ans = gcd(a[0] + bVal, g);
            sb.append(ans);
            if (j + 1 < m) sb.append(' ');
        }
        out.println(sb.toString());
    }

    // ---Utility ---
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }


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
```

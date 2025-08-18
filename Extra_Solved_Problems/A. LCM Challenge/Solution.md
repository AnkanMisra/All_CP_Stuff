
# Solution Explanation

## Intuition
To maximize the least common multiple (LCM) of three numbers not greater than `n`, we want the three numbers to be as large and as **pairwise‐coprime** as possible.
For any `n ≥ 3`, the best candidates are always drawn from the top four numbers `n, n-1, n-2, n-3`.

## Approach
1. **Small `n`:**
   - `n = 1` → answer `1`
   - `n = 2` → answer `2`
   - `n = 3` → answer `6`
   (These are direct checks.)
2. **`n` is odd:**
   The numbers `n, n-1, n-2` are consecutive and contain two even/odd mixture ensuring they are pairwise coprime, so their product is the answer:
   `LCM(n, n-1, n-2) = n × (n-1) × (n-2)`
3. **`n` is even:**
   Using all of `n, n-1, n-2` would introduce at least one extra factor of `2`, lowering the LCM. Two good candidate triplets are:
   - `n, n-1, n-3`
   - `n-1, n-2, n-3`
   Evaluate both and take the maximum.

## Complexity
- **Time Complexity:** `O(1)` — only a constant number of arithmetic operations.
- **Space Complexity:** `O(1)` — constant extra space.

## Summary
The optimal triplet always lies within the four largest numbers ≤ `n`.
For odd `n` the consecutive triple gives the maximum; for even `n`, skipping one even number avoids an extra factor of `2`, so we compare two specific candidate triplets and return the larger LCM.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-18 at 15:29:26 PM IST
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
        long n = sc.nextLong();
        if (n == 1) {
            out.println(1);
            return;
        }
        if (n == 2) {
            out.println(2);
            return;
        }
        if (n == 3) {
            out.println(6);
            return;
        }
        long ans;
        if ((n & 1) == 1) {
            ans = n * (n - 1) * (n - 2);
        } else {
            long cand1 = lcm(n, n - 1, n - 3);
            long cand2 = lcm(n - 1, n - 2, n - 3);
            ans = Math.max(cand1, cand2);
        }
        out.println(ans);
    }

    // ---Utility ---
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long lcm(long a, long b, long c) {
        return lcm(lcm(a, b), c);
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

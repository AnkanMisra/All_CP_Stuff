# Solution Explanation

## Intuition
We want to split `n` into `k` positive integers whose **least common multiple** (LCM) does not exceed `n²`.
Using many `1`s is beneficial because `1` does not affect the LCM or the sum.
After fixing `k − 3` numbers to `1`, only three numbers have to be chosen carefully; handling three values is easy and always possible due to parity properties of the remaining sum.

## Approach
1. Output `1` exactly `k − 3` times. The remaining sum is `s = n − (k − 3)`.
2. Now choose the last three numbers depending on the parity of `s`:
   * **`s` is odd**:
     Pick `(1, s / 2, s / 2)` (integer division is exact because `s` is odd).
     The LCM is `s / 2`, clearly ≤ `n ≤ n²`.
   * **`s` is even and `s % 4 == 0`**:
     Pick `(s / 2, s / 4, s / 4)`.
     The LCM is `s / 2`, also ≤ `n ≤ n²`.
   * **`s` is even and `s % 4 == 2`**:
     Pick `(2, (s − 2) / 2, (s − 2) / 2)`.
     The LCM is `(s − 2) / 2`, again ≤ `n ≤ n²`.

All three cases satisfy both the sum and the LCM condition.

## Algorithm
1. Read `n`, `k`.
2. Print `1` `k − 3` times and subtract that amount from `n` to obtain `s`.
3. Apply the case distinction above and print the final three numbers.

## Complexity
- **Time Complexity:** `O(k)` (only printing `k` numbers).
- **Space Complexity:** `O(1)` (constant extra memory).

## Summary
By fixing `k − 3` numbers to `1`, the problem reduces to splitting the remaining sum into three numbers.
Parity analysis ensures one of the three deterministic patterns always works, keeps the LCM small (`≤ n`), and meets the required total sum, providing a valid answer for every test case.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-21 at 18:19:20 PM IST
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
        long n = sc.nextLong();
        int k = sc.nextInt();

        int ones = k - 3;
        for (int i = 0; i < ones; i++) {
            out.print(1 + " ");
        }

        long s = n - ones;
        if (s % 2 == 1) {
            long a = s / 2;
            out.print(1 + " " + a + " " + a);
        } else {
            if (s % 4 == 0) {
                long a = s / 4;
                out.print(s / 2 + " " + a + " " + a);
            } else {
                long a = (s - 2) / 2;
                out.print(2 + " " + a + " " + a);
            }
        }
        out.println();
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
```


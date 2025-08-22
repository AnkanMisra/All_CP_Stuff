# Solution Explanation

## Intuition
For any path from `(x1, y1)` to `(x2, y2)` the list of visited **anti-diagonals** is the same, because every step changes `x + y` by exactly `1`. On each anti-diagonal the numbers increase by `1` from top to bottom, so choosing a different vertical position on that diagonal changes the path sum by a fixed amount. The first move that goes **down** decides this choice; later moves on the same diagonal no longer affect the sum.

Thus, every unordered pair **(down move, right move)** where the down move occurs *before* the right move contributes an independent binary decision that can increase the sum by a constant delta. Counting such pairs counts all possible distinct sums.

## Approach
1. Compute `dx = x2 - x1` and `dy = y2 - y1` — the counts of down and right moves.
2. Each down move can precede any of the right moves: there are `dx * dy` possible unordered pairs.
3. Every pair may appear in one of two orders (down-first or right-first), and flipping the order changes the path sum by the same constant. All sums therefore form an arithmetic progression whose length equals the number of independent flips plus `1` for the minimal sum.
4. Return **`dx * dy + 1`**.

## Algorithm (concise)
1. Read `x1, y1, x2, y2`.
2. `dx ← x2 - x1`, `dy ← y2 - y1`.
3. Output `dx * dy + 1`.

## Complexity
- **Time Complexity:** `O(1)` per test case
- **Space Complexity:** `O(1)`

## Summary
There are `dx * dy` independent down/right order choices inside the rectangle. Each choice toggles the sum by a fixed amount, giving exactly `dx * dy + 1` distinct path sums.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-22 at 17:53:59 PM IST
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
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();

        long dx = x2 - x1;
        long dy = y2 - y1;
        long ans = dx * dy + 1;
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
```


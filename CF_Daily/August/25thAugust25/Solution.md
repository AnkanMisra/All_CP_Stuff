

# Solution Explanation

## Intuition
To maximize the number of hikes, Jean should always start a hike as soon as a valid `k`-day good-weather window appears because delaying a feasible hike can only postpone subsequent hikes and never increase their count.

## Approach
1. **Prefix Sum for Fast Checks**
   * Build a prefix sum array `pref`, where `pref[i]` is the number of rainy days among the first `i` days.
   * A segment `[l, r]` has only good weather iff `pref[r] − pref[l] = 0`.
2. **Greedy Scan**
   * Start with index `idx = 0` (0-based).
   * While `idx + k ≤ n`:
     * If the segment `[idx, idx + k − 1]` is all good weather, count one hike and jump to `idx += k + 1` (`k` days of hiking + 1 mandatory rest day).
     * Otherwise increment `idx` by `1` and continue scanning.
3. The variable `ans` accumulates the number of successful hikes.

## Complexity
* **Time Complexity:** `O(n)` — a single linear scan per test case.
* **Space Complexity:** `O(n)` — the prefix sum array.

## Summary
The greedy strategy of taking a hike immediately when a `k`-day clear window is found is optimal because it never blocks a potential future hike. A prefix sum allows constant-time verification of each window, yielding an overall linear solution.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-25 at 18:17:07 PM IST
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
        int k = sc.nextInt();
        int[] a = nextIntArray(n);
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + a[i];
        }

        int ans = 0;
        int idx = 0;
        while (idx + k <= n) {
            if (pref[idx + k] - pref[idx] == 0) {
                ans++;
                idx += k + 1;
            } else {
                idx++;
            }
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
```


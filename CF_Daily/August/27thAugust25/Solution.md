

# Solution Explanation

## Intuition
For each monster, the explosion of the previous monster can partially damage it.
If the previous explosion damage `b_{i-1}` is at least the health `a_i`, that monster can be killed without firing any bullet at it.
Otherwise we must spend additional bullets equal to `a_i - b_{i-1}`.
Summing these extra bullets for every monster gives a baseline.
Finally, we can freely choose a starting monster whose **full health** (not the reduced value) is paid instead of its extra part, giving us the minimum possible total.

## Approach
1. Read arrays `a` and `b`.
2. For every monster `i` compute `need_i = max(0, a_i - b_{i-1})` (with circular index).
   Add all `need_i` to `total`.
3. Answer candidates: for each `i`, consider shooting monster `i` first.
   Then bullets required = `total - need_i + a_i` (replace its extra part by full health).
4. The minimum of these candidates is the answer.

## Complexity
- **Time Complexity:** `O(n)` per test case (single pass to compute arrays, single pass to find minimum).
- **Space Complexity:** `O(n)` for arrays `a`, `b`, `need` (can be reduced to `O(1)` with careful inline computation).

## Summary
The key is to split bullets into two parts: extra bullets needed after previous explosions (`need_i`) and the full cost of one chosen starting monster.
By evaluating each starting position in constant time we obtain the optimal total bullets in linear time.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-27 at 17:56:53 PM IST
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
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
        }

        long total = 0;
        long[] need = new long[n];
        for (int i = 0; i < n; i++) {
            long prevB = (i == 0) ? b[n - 1] : b[i - 1];
            need[i] = Math.max(0L, a[i] - prevB);
            total += need[i];
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long bullets = total - need[i] + a[i];
            ans = Math.min(ans, bullets);
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


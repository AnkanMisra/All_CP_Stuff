# Solution Explanation

## Intuition
Whenever we move **left** once we must surround it by two **right** moves (`… R L R …`).
Therefore each left move consumes **2 steps** of the `k` budget (right-left-right)
except that the final right after the last left is already counted inside `k`.
Thus performing `ℓ` left moves means we actually advance to index `k − 2ℓ` on the
array (the remaining steps are all rights).  While walking we repeatedly collect
values of two adjacent elements `a[i] + a[i+1]`.  Maximising the score boils
down to choosing a prefix length and how many best adjacent sums we can reuse
by oscillating (`RL`) over them.

## Approach
1. **Prefix sums** `pref[i]` — total value of the first `i + 1` elements, obtained
   by always moving right.
2. **Adjacent pair sums** `pair[i] = a[i] + a[i+1]` for `0 ≤ i < n-1`.
3. **Best pair to the left of each position** `bestPair[i] = max(pair[0…i-1])` via
   a running maximum.
4. Enumerate `ℓ = 0 … z` (number of left moves):
   - Remaining rights index = `pos = k − 2ℓ`. If negative, break.
   - Score = `pref[pos] + ℓ * bestPair[pos]` (we oscillate `ℓ` times on the
     best pair seen so far).
   - Track the maximum over all `ℓ`.

## Complexity
- **Time:** `O(n)` per test case (single linear scans and a small loop over `z ≤ 5`).
- **Space:** `O(n)` for prefix and helper arrays (can be `O(1)` with minor tweaks).

## Summary
By precomputing prefix sums and the running best adjacent pair we transform the
problem into trying every feasible count of left moves (at most 5).  Each choice
gives a closed-form score that we evaluate in constant time, yielding the
maximum total score within linear complexity.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-20 at 19:37:18 PM IST
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
        int z = sc.nextInt();
        int[] a = nextIntArray(n);

        long[] pref = new long[n];
        pref[0] = a[0];
        for (int i = 1; i < n; i++) pref[i] = pref[i - 1] + a[i];
        long ans = 0;
        long curSum = a[0];
        int bestPair = a[0] + a[1];

        for (int i = 0; i <= k; i++) {
            int remaining = k - i;
            int maxLeft = Math.min(z, remaining / 2);

            for (int l = 0; l <= maxLeft; l++) {
                int pos = i + (remaining - 2 * l);
                long score = curSum + (long) l * bestPair;
                if (pos > i) score += pref[pos] - pref[i];
                ans = Math.max(ans, score);
            }

            if (i + 1 >= n) break;
            if (i + 2 < n) bestPair = Math.max(bestPair, a[i + 1] + a[i + 2]);
            curSum += a[i + 1];
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


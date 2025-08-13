
# Solution Explanation

## Intuition
The key insight is that an element is **special** if it can be represented as the **sum of two or more consecutive elements** from the array. Since all array values are bounded by `n`, we can efficiently track which sums are possible and then count how many array elements match these special sums.

## Approach
The solution uses a **frequency-based counting approach** combined with **prefix sum enumeration**:

1. **Count frequencies**: Store how many times each value `1` to `n` appears in the array using a frequency array
2. **Mark special sums**: Use nested loops to generate all possible sums of consecutive subarrays with length ≥ 2
3. **Optimize with early termination**: Since array values are bounded by `n`, any sum > `n` cannot be a special element
4. **Count special elements**: For each value that can be formed as a consecutive sum, add its frequency to the answer

## Algorithm
1. Read array and build frequency table for values `1` to `n`
2. Initialize boolean array `special[]` to track which sums are achievable
3. For each starting position `i`:
   - Initialize `sum = a[i]`
   - For each ending position `j > i`:
     - Add `a[j]` to current sum
     - If `sum > n`, break (optimization)
     - Mark `special[sum] = true`
4. Count answer by summing `freq[v]` for all `v` where `special[v]` is true

## Complexity
- **Time Complexity**: `O(n^2)` per test case for the nested loops generating consecutive sums
- **Space Complexity**: `O(n)` for the frequency and special arrays

## Summary
This approach works because it **exhaustively generates all possible consecutive sums** while staying within memory constraints through the `sum > n` optimization. The key insight is that since array values are bounded by `n`, any sum exceeding `n` cannot correspond to an array element. The frequency-based counting ensures that **duplicate values are properly handled** - if multiple array elements have the same special value, all occurrences are counted in the final answer.

```java
/*
 * author  : Ankan Misra
 * created : 2025-08-13 at 19:04:49 PM IST
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
        int[] a = nextIntArray(n);
        int[] freq = new int[n + 1];
        for (int val : a) freq[val]++;
        boolean[] special = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int sum = a[i];
            for (int j = i + 1; j < n; j++) {
                sum += a[j];
                if (sum > n) break;
                special[sum] = true;
            }
        }
        int ans = 0;
        for (int v = 1; v <= n; v++) {
            if (special[v]) ans += freq[v];
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

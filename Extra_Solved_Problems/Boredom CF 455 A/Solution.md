# Solution Explanation

## Intuition
The problem is a variation of the "maximum sum of non-adjacent numbers" (classic dynamic programming). If you pick a number `x`, you must delete all `x-1` and `x+1` from the sequence, so you can't pick adjacent numbers. The optimal strategy is to use dynamic programming to decide, for each number, whether to take all occurrences of that number (and skip its neighbors) or skip it.

## Approach
1. **Count Occurrences:**  
   - Count how many times each number appears in the array.
2. **Dynamic Programming:**  
   - Let `dp[x]` be the maximum points you can get considering numbers up to `x`.
   - For each number `x`:
     - Either skip `x` and take `dp[x-1]`
     - Or take all `x` (which gives `count[x] * x`) and add `dp[x-2]` (since you must skip `x-1`)
     - `dp[x] = max(dp[x-1], dp[x-2] + count[x] * x)`
3. **Result:**  
   - The answer is `dp[max_value]`, where `max_value` is the largest number in the array.

## Complexity
- **Time Complexity:** O(n + m), where n is the length of the array and m is the maximum value in the array (since we process all numbers up to the maximum).
- **Space Complexity:** O(m), for the count and dp arrays.

## Summary
**By using dynamic programming and counting occurrences, we efficiently compute the maximum points Alex can earn by always making the optimal choice at each step.**  
This approach is optimal for the given constraints.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-24 at 20:10:52 PM IST
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
        int smol = sc.nextInt();
        int[] smolarr = nextIntArray(smol);
        int smolmax = 0;
        for (int smolval : smolarr) smolmax = Math.max(smolmax, smolval);

        long[] smolcnt = new long[smolmax + 2];
        for (int smolval : smolarr) smolcnt[smolval]++;

        long[] smoldp = new long[smolmax + 2];
        smoldp[0] = 0;
        smoldp[1] = smolcnt[1];
        for (int smoli = 2; smoli <= smolmax; smoli++) {
            smoldp[smoli] = Math.max(smoldp[smoli - 1], smoldp[smoli - 2] + smolcnt[smoli] * smoli);
        }
        out.println(smoldp[smolmax]);
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

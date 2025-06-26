# Solution Explanation

## Intuition
The problem is to determine if you can remove some digits (without rearranging) from a given number to form a number divisible by 8. The key insight is that a number is divisible by 8 if its last three digits form a number divisible by 8. Since the input can be up to 100 digits, we only need to check all possible 1-digit, 2-digit, and 3-digit subsequences (in order) for divisibility by 8.

## Approach
1. **Check All 1-Digit Subsequences:**  
   - If any single digit is divisible by 8, print "YES" and the digit.
2. **Check All 2-Digit Subsequences:**  
   - For every pair of digits (in order, skipping leading zeros), check if the two-digit number is divisible by 8.
3. **Check All 3-Digit Subsequences:**  
   - For every triplet of digits (in order, skipping leading zeros), check if the three-digit number is divisible by 8.
4. **If No Solution:**  
   - If no such subsequence is found, print "NO".

## Complexity
- **Time Complexity:** O(n^3), where n is the length of the string (but n ≤ 100, so this is efficient).
- **Space Complexity:** O(1) extra space.

## Summary
**By checking all possible 1, 2, and 3-digit subsequences, we can efficiently determine if a number divisible by 8 can be formed by removing digits (without rearranging).**  
This approach is optimal for the given constraints.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-26 at 17:25:19 PM IST
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
        String a = sc.next();
        int b = a.length();

        // Check all 1-digit subsequences
        for (int c = 0; c < b; c++) {
            int d = a.charAt(c) - '0';
            if (d % 8 == 0) {
                out.println("YES");
                out.println(d);
                return;
            }
        }

        // Check all 2-digit subsequences
        for (int c = 0; c < b; c++) {
            if (a.charAt(c) == '0') {
                continue;
            }
            for (int d = c + 1; d < b; d++) {
                int e = (a.charAt(c) - '0') * 10 + (a.charAt(d) - '0');
                if (e % 8 == 0) {
                    out.println("YES");
                    out.println("" + a.charAt(c) + a.charAt(d));
                    return;
                }
            }
        }

        // Check all 3-digit subsequences
        for (int c = 0; c < b; c++) {
            if (a.charAt(c) == '0') {
                continue;
            }
            for (int d = c + 1; d < b; d++) {
                for (int e = d + 1; e < b; e++) {
                    int f = (a.charAt(c) - '0') * 100 + (a.charAt(d) - '0') * 10 + (a.charAt(e) - '0');
                    if (f % 8 == 0) {
                        out.println("YES");
                        out.println("" + a.charAt(c) + a.charAt(d) + a.charAt(e));
                        return;
                    }
                }
            }
        }

        out.println("NO");
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

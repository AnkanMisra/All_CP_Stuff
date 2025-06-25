# Solution Explanation

## Intuition
The problem is to find the maximum number of consecutive books Valera can read without exceeding his available time `t`. This is a classic sliding window (two-pointer) problem: we want the longest subarray whose sum does not exceed `t`.

## Approach
- Use two pointers, `l` (left) and `r` (right), to maintain a window of books.
- Expand the window by moving `r` and adding the next book's time to the current sum.
- If the total time exceeds `t`, shrink the window from the left by moving `l` and subtracting the leftmost book's time.
- Track the maximum window size (number of books) that fits within the time limit.

## Complexity
- **Time Complexity:** O(n), where n is the number of books (each book is added and removed from the window at most once).
- **Space Complexity:** O(1) extra space.

## Summary
**By using a sliding window, we efficiently find the maximum number of consecutive books that can be read within the time limit.**  
This approach is optimal for large input sizes and is a standard technique for subarray sum problems.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-25 at 18:02:52 PM IST
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
        long t = sc.nextLong();
        int[] a = nextIntArray(n);
        
        int m = 0;
        long u = 0;
        int l = 0;
        
        for (int r = 0; r < n; r++) {
            u += a[r];
            while (u > t && l <= r) {
                u -= a[l];
                l++;
            }
            m = Math.max(m, r - l + 1);
        }
        
        out.println(m);
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

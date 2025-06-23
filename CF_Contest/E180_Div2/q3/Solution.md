# Solution Explanation

## Intuition
Alice wants to choose 3 elements from a sorted array such that, no matter which element Bob colors blue, the sum of the red elements is strictly greater than the value of the blue element. The key insight is that Alice must ensure the sum of the 3 chosen elements is strictly greater than the largest element in the array, and also strictly greater than any of the 3 chosen elements (since Bob can recolor a red element).

## Approach
1. **Sort the Array:**  
   - The array is already sorted in non-decreasing order.
2. **Iterate Over Possible Triplets:**  
   - For each possible third element (index `e` from 2 to n-1), consider it as the largest among the three red elements.
   - For each such `e`, use a two-pointer approach to count the number of pairs `(g, h)` with `g < h < e` such that `b[g] + b[h] > max(b[e], c - b[e])`, where `c` is the largest element in the array.
   - This ensures that the sum of the three red elements is strictly greater than both the largest element in the array and any of the three red elements.
3. **Count Valid Triplets:**  
   - For each valid pair, increment the count by the number of possible pairs.
4. **Output:**  
   - Print the total number of valid ways for each test case.

## Complexity
- **Time Complexity:** O(n^2) per test case (due to the two-pointer approach for each possible third element).
- **Space Complexity:** O(n) for storing the array.

## Summary
**By using a two-pointer approach on a sorted array, we efficiently count the number of valid triplets such that Alice can always win, regardless of Bob's choice.**  
This approach leverages the sorted property and the constraints of the problem for optimal performance.

```java
/*
 * author  : Ankan Misra
 * created : 2025-06-23 at 20:35:18 PM IST
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
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve() {
        int a = sc.nextInt();
        int[] b = nextIntArray(a);
        int c = b[a - 1];
        long d = 0L;

        for (int e = 2; e < a; e++) {
            int f = Math.max(b[e], c - b[e]);
            int g = 0, h = e - 1;
            while (g < h) {
                if (b[g] + b[h] > f) {
                    d += (h - g);
                    h--;
                } else {
                    g++;
                }
            }
        }

        out.println(d);
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

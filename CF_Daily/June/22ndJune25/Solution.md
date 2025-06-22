# Solution Explanation

## Intuition
The problem is to maximize the amount of gold Smilo can collect by detonating dynamite in empty cells of a grid. When dynamite is detonated, all gold strictly inside the explosion square is destroyed, but gold on the boundary is collected. The key insight is that for each empty cell, we can simulate an explosion and determine how much gold would be destroyed, then subtract this from the total gold to find how much can be collected.

## Approach
1. **Prefix Sum for Gold Counting:**  
   - Build a 2D prefix sum array to quickly count the number of gold cells in any subrectangle of the grid.
   - Count the total number of gold cells in the grid.
2. **Simulate Explosions:**  
   - For each empty cell, simulate detonating dynamite at that cell.
   - The explosion affects a square of side `2k+1` centered at the cell.
   - Use the prefix sum to count the number of gold cells strictly inside the explosion square (not on the boundary).
   - The number of gold collected is the total gold minus the gold destroyed.
   - Track the minimum number of gold destroyed across all possible detonations.
3. **Output:**  
   - For each test case, output the maximum gold that can be collected, which is the total gold minus the minimum gold destroyed.

## Complexity
- **Time Complexity:** O(n * m) per test case, where n and m are the grid dimensions (due to prefix sum and iterating over all empty cells).
- **Space Complexity:** O(n * m) for the prefix sum array.

## Summary
**By using a 2D prefix sum to efficiently count gold in any subrectangle, and simulating explosions at each empty cell, we can determine the optimal place to detonate dynamite to maximize the gold collected.**  
This approach is efficient and leverages prefix sums for fast subgrid queries.

```java
// created by AnkanMisra at 2025-06-22 and 18:33:03 IST 
// written in nvim, but blame the bugs on me

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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        char[][] d = new char[a][b];
        for (int e = 0; e < a; e++) {
            String f = sc.next();
            d[e] = f.toCharArray();
        }

        int[][] g = new int[a + 1][b + 1];
        int h = 0;
        for (int i = 0; i < a; i++) {
            int j = 0;
            for (int k = 0; k < b; k++) {
                if (d[i][k] == 'g') {
                    j++;
                    h++;
                }
                g[i + 1][k + 1] = g[i][k + 1] + j;
            }
        }

        int l = c - 1;
        int m = Integer.MAX_VALUE;
        for (int n = 0; n < a; n++) {
            for (int o = 0; o < b; o++) {
                if (d[n][o] != '.') {
                    continue;
                }
                int p = countGold(g,
                        Math.max(0, n - l),
                        Math.max(0, o - l),
                        Math.min(a - 1, n + l),
                        Math.min(b - 1, o + l));
                if (p < m) {
                    m = p;
                }
            }
        }

        if (m == Integer.MAX_VALUE) {
            m = 0;
        }

        out.println(h - m);
    }

    static int countGold(int[][] q, int r, int s, int t, int u) {
        if (r > t || s > u) {
            return 0;
        } else {
            r++; s++; t++; u++;
            return q[t][u] - q[r - 1][u] - q[t][s - 1] + q[r - 1][s - 1];
        }
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

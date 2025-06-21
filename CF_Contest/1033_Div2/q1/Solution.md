# Solution Explanation

## Intuition
The problem asks whether three given rectangles (with fixed orientation, no rotation allowed) can be arranged to form a perfect square, with all rectangles aligned along the edges and no overlaps. The key insight is that the total area of the rectangles must be a perfect square, and their sides must fit together exactly to form a square of side length equal to the square root of the total area.

## Approach
1. **Calculate the Total Area:**  
   - Compute the sum of the areas of the three rectangles.
   - The side of the square must be the integer square root of this area, and the area must be a perfect square.
2. **Check Rectangle Fit:**  
   - For each rectangle, both its length and width must not exceed the side of the square.
3. **Check All Arrangements:**  
   - There are a few main ways to arrange the rectangles:
     - All rectangles aligned in a row or column (i.e., all heights or all widths equal to the square's side, and the sum of the other dimension equals the square's side).
     - One rectangle fills one side, and the other two are stacked or placed to fill the remaining space.
   - Try all permutations and possible placements to see if the rectangles can fill the square exactly.
4. **Output:**  
   - If any arrangement works, print "YES". Otherwise, print "NO".

## Complexity
- **Time Complexity:** O(1) per test case (since the number of rectangles and arrangements is constant).
- **Space Complexity:** O(1).

## Summary
**By checking all possible ways to fit the three rectangles into a square (without rotation), and ensuring the total area is a perfect square and all sides fit, we can determine if the rectangles can form a square.**  
This approach is efficient due to the small, fixed number of rectangles and possible arrangements.

```java
// created by AnkanMisra at 2025-06-21 and 20:02:39 IST 
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
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int[] g = {a, c, e};
        int[] h = {b, d, f};
        int i = a * b + c * d + e * f;
        int j = (int) Math.round(Math.sqrt(i));
        if (j * j != i) {
            out.println("NO");
            return;
        }
        for (int x = 0; x < 3; x++) {
            if (g[x] > j || h[x] > j) {
                out.println("NO");
                return;
            }
        }
        boolean k = false;
        if (b == j && d == j && f == j && a + c + e == j) {
            k = true;
        }
        if (a == j && c == j && e == j && b + d + f == j) {
            k = true;
        }
        for (int m = 0; m < 3 && !k; m++) {
            for (int n = 0; n < 3 && !k; n++) {
                if (n == m) {
                    continue;
                }
                int o = 3 - m - n;
                int p = g[m], q = h[m];
                int r = g[n], s = h[n];
                int t = g[o], u = h[o];
                if (p == j) {
                    int v = j - q;
                    if (v > 0) {
                        if (s == v && u == v && r + t == j) {
                            k = true;
                        }
                        if (r == j && t == j && s + u == v) {
                            k = true;
                        }
                    }
                }
                if (!k && q == j) {
                    int w = j - p;
                    if (w > 0) {
                        if (r == w && t == w && s + u == j) {
                            k = true;
                        }
                        if (s == j && u == j && r + t == w) {
                            k = true;
                        }
                    }
                }
            }
        }
        if (k) {
            out.println("YES");
        } else {
            out.println("NO");
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
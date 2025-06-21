# Solution Explanation

## Intuition
The problem asks us to construct a rooted tree with `n` nodes such that the sum of the divineness values (where the divineness of a node is the smallest label on the path from the root to that node) is exactly `m`. If no such tree exists, we must output `-1`.

The key insight is that the minimum possible sum is when the root is 1 (the divineness of every node is 1), and the maximum possible sum is when the tree is a chain (the root is n, and the divineness of each node is its own label). We need to find a root and a tree structure such that the sum of divineness is exactly `m`.

## Approach
1. **Handle the Single Node Case:**  
   - If `n == 1`, the only possible sum is 1. If `m == 1`, output 1; otherwise, output -1.
2. **Check Feasibility:**  
   - The minimum possible sum is `n` (all nodes have divineness 1).
   - The maximum possible sum is `n * (n + 1) / 2` (chain rooted at n).
   - If `m` is outside this range, output -1.
3. **Special Case (Star Tree):**  
   - If `m == n`, the root is 1 and all other nodes are direct children of the root.
4. **General Case:**  
   - Try all possible roots from 2 to n.
   - For each possible root `f`, calculate the maximum sum achievable with that root.
   - If `m` is within the achievable range, construct the tree:
     - Start with a star centered at `f`.
     - Move as many nodes as possible to be direct children of 1 to decrease the sum as needed.
     - Output the root and the edges.
5. **Output:**  
   - If a valid tree is found, print the root and the edges.
   - If not, print -1.

## Complexity
- **Time Complexity:** O(n) per test case in the worst case (since we may try all possible roots).
- **Space Complexity:** O(n) for storing the tree structure.

## Summary
**By considering the possible range of divineness sums and constructing the tree accordingly, we can efficiently determine if a solution exists and output the required tree.**  
The approach leverages the properties of rooted trees and the divineness definition to construct a valid solution or report impossibility.

```java
// created by AnkanMisra at 2025-06-21 and 20:31:11 IST 
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
        long b = sc.nextLong();

        if (a == 1) {
            if (b == 1) {
                out.println(1);
            } else {
                out.println(-1);
            }
            return;
        }

        long c = a;
        long d = (long) a * (a + 1L) / 2L;
        if (b < c || b > d) {
            out.println(-1);
            return;
        }

        if (b == c) {
            out.println(1);
            for (int e = 2; e <= a; e++) {
                out.println("1 " + e);
            }
            return;
        }

        int f = -1;
        long g = 0;
        for (int h = 2; h <= a; h++) {
            long i = ((long) h) * a - ((long) h) * (h - 1L) / 2L;
            long j = a + h - 1L;
            if (b >= j && b <= i) {
                f = h;
                g = i;
                break;
            }
        }

        if (f == -1) {
            out.println(-1);
            return;
        }

        int[] k = new int[a + 1];
        k[f] = 0;
        k[1] = f;
        for (int l = 2; l <= a; l++) {
            if (l == f) continue;
            k[l] = f;
        }

        long m = g - b;
        if (m < 0) m = 0;

        long n = f - 1L;

        for (int o = a; o > f && m >= n; o--) {
            k[o] = 1;
            m -= n;
        }

        for (int p = f - 1; p >= 2 && m > 0; p--) {
            long q = p - 1L;
            if (q <= m) {
                k[p] = 1;
                m -= q;
            }
        }

        out.println(f);
        for (int r = 1; r <= a; r++) {
            if (r == f) continue;
            out.println(k[r] + " " + r);
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
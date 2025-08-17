

# Solution Explanation

## Intuition
The fate of the game hinges on the **special node `x`**:
- If `x` is already a **leaf** (`degree ≤ 1`), Ayush removes it on his very first move and wins.
- Otherwise, after removing `x`, exactly `n − 1` nodes remain.
  The players will then alternately delete the remaining leaves. Since the number of remaining moves equals `n − 1`, the winner depends on its **parity**.

## Approach
1. Compute the **degree** of every node while reading the edges.
2. If `degree[x] ≤ 1`, Ayush wins immediately.
3. Otherwise, if `n` is **even**, Ayush again wins because after deleting `x` (`n − 1` is odd) Ashish is forced to play last.
4. In all other cases (i.e.
   `degree[x] > 1` and `n` is **odd**), Ashish wins.

## Algorithm (Detailed Steps)
1. Read `n`, `x` and all `n − 1` edges.
2. Maintain an array `deg[1‥n]` counting incident edges for each node.
3. After input:
   - **If** `deg[x] ≤ 1` → **Ayush**.
   - **Else if** `n` is **even** → **Ayush**.
   - **Else** → **Ashish**.

## Complexity
- **Time Complexity:** `O(n)` per test case — single pass through the edges.
- **Space Complexity:** `O(n)` for the degree array.

## Summary
- **Leaf `x`**: Ayush wins instantly.
- **Non-leaf `x`**:
  - **Even `n`** → Ayush wins (he controls the parity).
  - **Odd `n`** → Ashish wins (he gets the decisive move).
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-17 at 16:15:18 PM IST
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
        int x = sc.nextInt();
        int[] deg = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            deg[u]++;
            deg[v]++;
        }
        if (deg[x] <= 1 || n % 2 == 0) {
            out.println("Ayush");
        } else {
            out.println("Ashish");
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

```

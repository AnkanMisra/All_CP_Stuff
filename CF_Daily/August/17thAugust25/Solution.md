
# Solution Explanation

## Intuition
Treat the capital (city `1`) as the **root of the tree**.
For every city we may choose as an industry centre we care about how many **tourism cities** its envoy crosses while walking to the root.
If we place industry in the subtree of another industry city, we lose happiness because their paths overlap inside that subtree.
Hence it is better to choose cities that are **deep** in the tree and whose subtrees are **small**.

## Approach
1. **Root the tree** at city `1` and run one DFS/BFS to compute for each node:
   • `depth[v]` – distance from `v` to the root.
   • `sub[v]` – size of the subtree of `v` (including itself).
2. For every city compute a score

   `gain[v] = depth[v] - (sub[v] - 1)`

   • `depth[v]` is the number of edges from `v` up to the root: these are potential tourism cities on its path.
   • `sub[v] - 1` counts how many descendants would become **tourism** if `v` itself is chosen as industry, thus cancelling the same amount of happiness for their envoys.
   The formula is exactly the marginal gain in total happiness if we mark `v` as industry.
3. Collect all `gain[v]` values, sort them, and take the **largest `k` gains** – those cities give the maximal possible sum.
4. The answer is the sum of these `k` gains.

## Complexity
- **Time Complexity:** `O(n log n)` – one DFS (`O(n)`) plus sorting `n` values (`O(n log n)`).
- **Space Complexity:** `O(n)` – adjacency lists, arrays for depth, subtree size and gains.

## Summary
By rooting the tree and analysing the marginal contribution of each node (`depth - subtree_size + 1`), we convert the selection problem into choosing the `k` largest gains, solvable with sorting.
This maximises the total number of tourism cities travelled by all envoys, therefore maximising overall happiness.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-17 at 17:27:24 PM IST
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
        int k = sc.nextInt();
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        int[] depth = new int[n + 1];
        int[] parent = new int[n + 1];
        int[] order = new int[n];
        int top = 0;
        int[] stack = new int[n];
        stack[top++] = 1;
        parent[1] = 0;
        int idx = 0;
        while (top > 0) {
            int u = stack[--top];
            order[idx++] = u;
            for (int v : g[u]) {
                if (v == parent[u]) continue;
                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        int[] sub = new int[n + 1];
        Arrays.fill(sub, 1);
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            if (parent[u] != 0) {
                sub[parent[u]] += sub[u];
            }
        }

        long[] val = new long[n];
        for (int i = 1; i <= n; i++) {
            val[i - 1] = (long) depth[i] - (sub[i] - 1);
        }
        Arrays.sort(val);
        long ans = 0;
        for (int i = n - 1; i >= n - k; i--) ans += val[i];
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

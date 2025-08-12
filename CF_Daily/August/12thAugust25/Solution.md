
# Solution Explanation

## Intuition
To find **cyclic components** in an undirected graph, we need to identify connected components where each vertex has **exactly degree 2** and the number of vertices equals the number of edges. A cycle is a closed path where every vertex is visited exactly once, which means each vertex must have exactly two neighbors.

## Approach
We use **BFS/DFS traversal** to explore each connected component and check if it forms a cycle:

1. **Build adjacency list** representation of the graph from input edges
2. **Iterate through all vertices** and for each unvisited vertex:
   - Start a **BFS traversal** to explore the entire connected component
   - **Count vertices** in the component
   - **Sum all degrees** of vertices in the component
   - **Check if all vertices have degree 2**
3. **Calculate edges** as `degreeSum / 2` (since each edge contributes to two vertices' degrees)
4. **Verify cycle conditions**:
   - All vertices have degree 2
   - Number of vertices ≥ 3 (minimum cycle size)
   - Number of edges equals number of vertices
5. **Increment cycle counter** if all conditions are met

## Complexity
- **Time Complexity:** `O(n + m)` where `n` is number of vertices and `m` is number of edges. Each vertex and edge is visited exactly once during BFS traversal.
- **Space Complexity:** `O(n + m)` for the adjacency list representation and visited array.

## Summary
The approach works because **a connected component is a cycle if and only if** every vertex has exactly degree 2 and the component is connected. This ensures there are no branches or additional edges beyond the cycle structure. The condition `edges == vertices` confirms that the component forms exactly one cycle without any additional structure. **Corner cases** include isolated vertices (degree 0), trees (degree ≠ 2 for some vertices), and components with multiple cycles (more edges than vertices).
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-12 at 18:56:52 PM IST
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
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        int cycles = 0;

        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(i);
            vis[i] = true;
            int vertices = 0;
            long degreeSum = 0;
            boolean allDegTwo = true;
            while (!dq.isEmpty()) {
                int node = dq.poll();
                vertices++;
                int deg = adj.get(node).size();
                degreeSum += deg;
                if (deg != 2) allDegTwo = false;
                for (int nei : adj.get(node)) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        dq.add(nei);
                    }
                }
            }
            long edges = degreeSum / 2;
            if (allDegTwo && vertices >= 3 && edges == vertices) cycles++;
        }

        out.println(cycles);
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

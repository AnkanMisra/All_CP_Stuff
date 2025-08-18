

# Solution Explanation

## Intuition
The relative order of letters can be extracted by comparing **adjacent names**. For every first position where two consecutive names differ, the character in the earlier name must come **before** the character in the later name in any alphabet that keeps the list lexicographically sorted. Collecting all such relations forms a **directed graph** on the 26 letters. If this graph is **acyclic**, a **topological order** of its vertices is an alphabet that satisfies all relations; otherwise no such alphabet exists.

## Approach
1. **Build Constraints**
   - For every pair of consecutive names `s` and `t`, find the first index `i` where they differ.
   - If no differing position exists and `|s| > |t|`, then `s` is a longer prefix of `t` ⇒ **Impossible**.
   - Otherwise, add a directed edge `s[i] → t[i]` if that edge is not already present.
2. **Topological Sort (Kahn’s algorithm)**
   - Compute **in-degree** of each letter.
   - Push all letters with in-degree `0` into a queue.
   - Repeatedly pop a letter, append it to the output order, and decrease in-degree of its neighbours, queuing any that drop to `0`.
3. **Validate Result**
   - If the resulting order contains **all 26 letters**, output it.
   - Otherwise (cycle detected) output `Impossible`.

## Complexity
- **Time Complexity:** `O(L + 26)` where `L` is the total length of all names (≤ 10 000). Topological sort touches every edge and vertex once.
- **Space Complexity:** `O(26²)` for the adjacency list and in-degree array — effectively **O(1)**.

## Summary
Extracting precedence constraints from adjacent names transforms the problem into detecting a cycle in a directed graph of letters. A valid topological ordering gives an alphabet that sorts the names; a cycle or invalid prefix relation makes it **Impossible**.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-18 at 14:07:03 PM IST
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
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();

        List<Integer>[] adj = new ArrayList[26];
        int[] indeg = new int[26];
        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();

        boolean impossible = false;
        for (int i = 0; i < n - 1; i++) {
            String a = names[i];
            String b = names[i + 1];
            int min = Math.min(a.length(), b.length());
            int j = 0;
            while (j < min && a.charAt(j) == b.charAt(j)) j++;
            if (j == min) {
                if (a.length() > b.length()) {
                    impossible = true;
                    break;
                }
                continue;
            }
            int u = a.charAt(j) - 'a';
            int v = b.charAt(j) - 'a';
            if (!adj[u].contains(v)) {
                adj[u].add(v);
                indeg[v]++;
            }
        }

        if (impossible) {
            out.println("Impossible");
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) if (indeg[i] == 0) q.offer(i);

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char) ('a' + u));
            for (int v : adj[u]) {
                indeg[v]--;
                if (indeg[v] == 0) q.offer(v);
            }
        }

        if (order.length() != 26) {
            out.println("Impossible");
        } else {
            out.println(order.toString());
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


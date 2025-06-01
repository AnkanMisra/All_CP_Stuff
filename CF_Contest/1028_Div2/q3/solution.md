# Solution Explanation

### Intuition

The goal is to make all elements of the array equal using the minimum number of operations, where each operation replaces an element with the gcd of itself and another element. The optimal value to make all elements equal to is the gcd of the entire array.

### Approach

- Compute the gcd `g` of the entire array.
- Count how many elements are already equal to `g`. If at least one, the answer is `n - cnt` (where `cnt` is the count of elements equal to `g`).
- If no element is equal to `g`, use BFS to find the minimum number of gcd operations needed to reach `g` from any of the distinct values in the array.
- The answer is the minimum number of operations to reach `g` plus `n - 1` (since we need to make all elements equal to `g`).

### Code

```java
import java.util.*;

public class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int g = a[0];
            for (int i = 1; i < n; i++) {
                g = gcd(g, a[i]);
            }

            int cnt = 0;
            for (int v : a) {
                if (v == g) {
                    cnt++;
                }
            }

            if (cnt > 0) {
                System.out.println(n - cnt);
                continue;
            }

            boolean[] seen = new boolean[5001];
            int[] distinct = new int[n];
            int dn = 0;
            for (int v : a) {
                if (!seen[v]) {
                    seen[v] = true;
                    distinct[dn++] = v;
                }
            }

            boolean[] vis = new boolean[5001];
            int[] dist = new int[5001];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < dn; i++) {
                int v = distinct[i];
                vis[v] = true;
                dist[v] = 0;
                q.offer(v);
            }

            int d = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == g) {
                    d = dist[u];
                    break;
                }
                int nd = dist[u] + 1;
                for (int i = 0; i < dn; i++) {
                    int w = gcd(u, distinct[i]);
                    if (!vis[w]) {
                        vis[w] = true;
                        dist[w] = nd;
                        q.offer(w);
                    }
                }
            }

            System.out.println(d + n - 1);
        }
    }
}
```

### Complexity

- **Time Complexity:** O(n^2) in the worst case (due to BFS over all pairs of distinct values).
- **Space Complexity:** O(n), for storing distinct values and visited arrays.

### Summary

- The solution finds the gcd of the array and counts how many elements are already equal to it.
- If at least one, the answer is `n - cnt`.
- Otherwise, it uses BFS to find the minimum number of operations to reach the gcd from any distinct value, and adds `n - 1` to get the total number of operations.

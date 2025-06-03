import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            List<Integer>[] adj = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            int[] parent = new int[n + 1];
            int[] depth = new int[n + 1];
            long[] upPS = new long[n + 1];
            long[] minUp = new long[n + 1];
            long[] maxUp = new long[n + 1];
            long[] threat = new long[n + 1];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            parent[1] = 0;
            depth[1] = 0;
            upPS[1] = a[1];
            minUp[1] = 0;
            maxUp[1] = 0;
            threat[1] = upPS[1] - minUp[1];
            q.add(1);
            while (!q.isEmpty()) {
                int v = q.poll();
                for (int u : adj[v]) {
                    if (u != parent[v]) {
                        parent[u] = v;
                        depth[u] = depth[v] + 1;
                        if (depth[u] % 2 == 0) {
                            upPS[u] = upPS[v] + a[u];
                        } else {
                            upPS[u] = upPS[v] - a[u];
                        }
                        minUp[u] = Math.min(minUp[v], upPS[v]);
                        maxUp[u] = Math.max(maxUp[v], upPS[v]);
                        if (depth[u] % 2 == 0) {
                            threat[u] = upPS[u] - minUp[u];
                        } else {
                            threat[u] = maxUp[u] - upPS[u];
                        }
                        q.add(u);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                sb.append(threat[i]);
                if (i < n)
                    sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        sc.close();
    }
}

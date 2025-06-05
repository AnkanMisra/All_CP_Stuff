import java.util.*;

public class Solution {
    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int MAXN = 200000 + 5;
        List<Edge>[] adj = new ArrayList[MAXN];
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
        }
        long[] b = new long[MAXN];
        long[] best = new long[MAXN];
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextLong();
                adj[i].clear();
            }
            List<Integer> W = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int s = sc.nextInt();
                int t2 = sc.nextInt();
                int w = sc.nextInt();
                adj[s].add(new Edge(t2, w));
                W.add(w);
            }
            if (m == 0) {
                sb.append(-1).append('\n');
                continue;
            }
            Collections.sort(W);
            int wcnt = 1;
            for (int i = 1; i < W.size(); i++) {
                if (!W.get(i).equals(W.get(i - 1))) {
                    W.set(wcnt++, W.get(i));
                }
            }
            for (int i = W.size() - 1; i >= wcnt; i--) {
                W.remove(i);
            }
            int lo = 0, hi = W.size() - 1, ans = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                int B = W.get(mid);
                if (canReach(n, B, adj, b, best)) {
                    ans = B;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
        sc.close();
    }

    static boolean canReach(int n, int B, List<Edge>[] adj, long[] b,
            long[] best) {
        for (int i = 1; i <= n; i++) {
            best[i] = -1;
        }
        best[1] = 0;
        for (int u = 1; u <= n; u++) {
            if (best[u] < 0)
                continue;
            long cur = best[u] + b[u];
            for (Edge e : adj[u]) {
                if (e.w <= B && cur >= e.w && cur > best[e.to]) {
                    best[e.to] = cur;
                }
            }
            if (best[n] >= 0)
                return true;
        }
        return best[n] >= 0;
    }
}

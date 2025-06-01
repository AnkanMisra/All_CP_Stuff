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

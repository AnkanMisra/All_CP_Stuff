import java.util.*;

class Solution {
    public ArrayList<Integer> nextElement(int[] a) {
        int b = a.length;
        ArrayList<Integer> c = new ArrayList<>();
        for (int d = 0; d < b; d++) {
            c.add(-1);
        }
        int e = 0;
        for (int f = 0; f < b; f++) {
            if (a[f] > e) {
                e = a[f];
            }
        }
        ArrayList<Integer>[] g = new ArrayList[e + 1];
        ArrayList<Integer>[] h = new ArrayList[e + 1];
        for (int i = 1; i <= e; i++) {
            g[i] = new ArrayList<>();
            h[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                g[j].add(i);
            }
        }
        for (int i = 0; i < b; i++) {
            int v = a[i];
            for (int d : g[v]) {
                ArrayList<Integer> q = h[d];
                if (!q.isEmpty()) {
                    for (int x : q) {
                        c.set(x, v);
                    }
                    q.clear();
                }
            }
            h[v].add(i);
        }
        return c;
    }
}

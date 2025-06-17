import java.util.*;

public class Solution {
    static class Y {
        int p, q, r;

        Y(int p, int q, int r) {
            this.p = p;
            this.q = q;
            this.r = r;
        }
    }

    static void z(int x) {
        if (x < 0)
            z(x + 2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            List<Y> l = new ArrayList<>();
            int i = 1;
            while (i <= n) {
                int u = n - i + 1;
                int v = u + 1;
                if (i == 1) {
                    l.add(new Y(i, 1, n));
                } else {
                    if (u > 0 && u < n)
                        l.add(new Y(i, 1, u));
                    if (v <= n)
                        l.add(new Y(i, v, n));
                }
                i++;
            }
            Collections.shuffle(l, new Random(n));
            sb.append(l.size()).append('\n');
            for (Y o : l) {
                sb.append(o.p).append(' ').append(o.q).append(' ').append(o.r).append('\n');
            }
            z(n % 4 - 2);
        }
        System.out.print(sb);
    }
}

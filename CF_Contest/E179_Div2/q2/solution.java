import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        int[] c = new int[11];
        c[1] = 1;
        c[2] = 2;
        for (int i = 3; i <= 10; i++) {
            c[i] = c[i - 1] + c[i - 2];
        }
        StringBuilder out = new StringBuilder();
        while (b-- > 0) {
            int n = a.nextInt();
            int m = a.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = c[n - i];
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int w = a.nextInt();
                int l = a.nextInt();
                int h = a.nextInt();
                ArrayList<int[]> g = new ArrayList<>();
                g.add(new int[] { w, l, h });
                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    int v = s[k];
                    boolean placed = false;
                    for (int j = 0; j < g.size(); j++) {
                        int[] p = g.get(j);
                        int pw = p[0], pl = p[1], ph = p[2];
                        if (v <= pw && v <= pl && v <= ph) {
                            placed = true;
                            g.remove(j);
                            if (pw - v > 0)
                                g.add(new int[] { pw - v, pl, v });
                            if (pl - v > 0)
                                g.add(new int[] { v, pl - v, v });
                            if (ph - v > 0)
                                g.add(new int[] { v, v, ph - v });
                            break;
                        }
                    }
                    if (!placed) {
                        ok = false;
                        break;
                    }
                }
                ans.append(ok ? '1' : '0');
            }
            out.append(ans);
            if (b > 0)
                out.append('\n');
        }
        System.out.print(out);
    }
}

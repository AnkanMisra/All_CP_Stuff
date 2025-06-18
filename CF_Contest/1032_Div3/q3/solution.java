
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        StringBuilder c = new StringBuilder();
        while (testcases-- > 0) {
            int d = a.nextInt();
            int e = a.nextInt();
            int[][] f = new int[d][e];
            int g = 0;
            for (int h = 0; h < d; h++) {
                for (int i = 0; i < e; i++) {
                    int j = a.nextInt();
                    f[h][i] = j;
                    if (j > g) {
                        g = j;
                    }
                }
            }
            int[] k = new int[d];
            int[] l = new int[e];
            ArrayList<Integer>[] m = new ArrayList[d];
            ArrayList<Integer>[] n = new ArrayList[e];
            for (int h = 0; h < d; h++) {
                for (int i = 0; i < e; i++) {
                    if (f[h][i] == g) {
                        k[h]++;
                        l[i]++;
                        if (m[h] == null)
                            m[h] = new ArrayList<>();
                        m[h].add(i);
                        if (n[i] == null)
                            n[i] = new ArrayList<>();
                        n[i].add(h);
                    }
                }
            }
            int o = 0;
            for (int i = 0; i < e; i++) {
                if (l[i] > 0) {
                    o++;
                }
            }
            boolean p = false;
            for (int h = 0; h < d && !p; h++) {
                if (k[h] == 0) {
                    continue;
                }
                int q = o;
                for (int col : m[h]) {
                    if (l[col] == 1) {
                        q--;
                    }
                }
                if (q <= 1) {
                    p = true;
                }
            }
            if (!p) {
                int r = 0;
                for (int h = 0; h < d; h++) {
                    if (k[h] > 0) {
                        r++;
                    }
                }
                for (int i = 0; i < e && !p; i++) {
                    if (l[i] == 0) {
                        continue;
                    }
                    int q = r;
                    for (int row : n[i]) {
                        if (k[row] == 1) {
                            q--;
                        }
                    }
                    if (q <= 1) {
                        p = true;
                    }
                }
            }
            if (p) {
                int s = g - 1;
                c.append(s).append('\n');
            } else {
                int s = g;
                c.append(s).append('\n');
            }
        }
        String result = c.toString();
        System.out.println(result);
    }
}

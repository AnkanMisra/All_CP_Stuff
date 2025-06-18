import java.util.*;

public class Solution {
    public static void main(String[] x) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        StringBuilder y = new StringBuilder();
        while (testcases-- > 0) {
            int c = a.nextInt();
            int[] d = new int[c];
            int[] e = new int[c];
            for (int i = 0; i < c; i++) {
                d[i] = a.nextInt();
            }
            for (int i = 0; i < c; i++) {
                e[i] = a.nextInt();
            }
            ArrayList<int[]> f = new ArrayList<>();
            for (int i = 0; i < c; i++) {
                int g = 2 * i + 1;
                int h = -1;
                boolean j = true;
                for (int k = i; k < c; k++) {
                    if (d[k] == g) {
                        h = k;
                        j = true;
                        break;
                    }
                    if (e[k] == g) {
                        h = k;
                        j = false;
                        break;
                    }
                }
                if (!j) {
                    f.add(new int[] { 3, h + 1 });
                    int t = d[h];
                    d[h] = e[h];
                    e[h] = t;
                }
                while (h > i) {
                    f.add(new int[] { 1, h });
                    int t = d[h];
                    d[h] = d[h - 1];
                    d[h - 1] = t;
                    h--;
                }
                int l = 2 * (i + 1);
                int m = -1;
                boolean n = true;
                for (int k = i; k < c; k++) {
                    if (e[k] == l) {
                        m = k;
                        n = false;
                        break;
                    }
                    if (d[k] == l) {
                        m = k;
                        n = true;
                        break;
                    }
                }
                if (n) {
                    f.add(new int[] { 3, m + 1 });
                    int t = d[m];
                    d[m] = e[m];
                    e[m] = t;
                }
                while (m > i) {
                    f.add(new int[] { 2, m });
                    int t = e[m];
                    e[m] = e[m - 1];
                    e[m - 1] = t;
                    m--;
                }
            }
            y.append(f.size()).append('\n');
            for (int[] q : f) {
                y.append(q[0]).append(' ').append(q[1]).append('\n');
            }
        }
        String result = y.toString();
        System.out.println(result);
    }
}

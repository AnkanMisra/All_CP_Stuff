import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a != 0) {
            a--;
            int b = sc.nextInt();
            int[] c = new int[b];
            int[] d = new int[b];
            for (int e = 0; e < b; e++) {
                c[e] = sc.nextInt();
            }
            for (int e = 0; e < b; e++) {
                d[e] = sc.nextInt();
            }
            final int f = 998244353;
            long[] g = new long[b];
            g[0] = 1;
            for (int e = 1; e < b; e++) {
                g[e] = (g[e - 1] * 2) % f;
            }
            int h = c[0];
            int i = 0;
            int j = d[0];
            int k = 0;
            for (int e = 0; e < b; e++) {
                if (e == 0) {
                    h = c[0];
                    i = 0;
                    j = d[0];
                    k = 0;
                }
                if (e > 0) {
                    if (c[e] > h) {
                        h = c[e];
                        i = e;
                    }
                    if (d[e] > j) {
                        j = d[e];
                        k = e;
                    }
                }
                int l = h;
                int m = d[e - i];
                int n = j;
                int o = c[e - k];
                int y;
                if (l > n) {
                    y = i;
                } else {
                    if (l < n) {
                        y = e - k;
                    } else {
                        if (m > o) {
                            y = i;
                        } else {
                            y = e - k;
                        }
                    }
                }
                long z = (g[c[y]] + g[d[e - y]]) % f;
                System.out.print(z);
                if (e < b - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

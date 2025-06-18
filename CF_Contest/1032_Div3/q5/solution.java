import java.util.*;

public class Solution {
    public static void main(String[] a) {
        Scanner b = new Scanner(System.in);
        int testcases = b.nextInt();
        StringBuilder d = new StringBuilder();
        while (testcases-- > 0) {
            String e = b.next();
            String f = b.next();
            int g = e.length();
            int[][] h = new int[2][2];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(h[i], 1000);
            }
            h[1][1] = 0;
            for (int i = 0; i < g; i++) {
                int[][] j = new int[2][2];
                for (int x = 0; x < 2; x++) {
                    Arrays.fill(j[x], 1000);
                }
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        int m = h[k][l];
                        if (m == 1000) {
                            continue;
                        }
                        int n;
                        if (k == 1) {
                            n = e.charAt(i) - '0';
                        } else {
                            n = 0;
                        }
                        int o;
                        if (l == 1) {
                            o = f.charAt(i) - '0';
                        } else {
                            o = 9;
                        }
                        int p = e.charAt(i) - '0';
                        int q = f.charAt(i) - '0';
                        for (int r = n; r <= o; r++) {
                            int s = m;
                            if (r == p) {
                                s++;
                            }
                            if (r == q) {
                                s++;
                            }
                            int t;
                            if (k == 1 && r == p) {
                                t = 1;
                            } else {
                                t = 0;
                            }
                            int u;
                            if (l == 1 && r == q) {
                                u = 1;
                            } else {
                                u = 0;
                            }
                            if (s < j[t][u]) {
                                j[t][u] = s;
                            }
                        }
                    }
                }
                h = j;
            }
            int min = Integer.MAX_VALUE;
            for (int[] row : h) {
                for (int val : row) {
                    min = Math.min(min, val);
                }
            }
            d.append(min).append('\n');
        }
        String result = d.toString();
        System.out.println(result);
    }
}

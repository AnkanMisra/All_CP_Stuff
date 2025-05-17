import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            boolean b, c;
            if (a[0] == 0) {
                b = false;
                c = true;
            } else {
                b = true;
                c = false;
            }
            for (int i = 1; i < n - 1 && (b || c); i++) {
                boolean nb = false;
                boolean nc = false;
                if (a[i] == 0) {
                    if (b) {
                        nc = true;
                    }
                } else {
                    if (c) {
                        nb = true;
                        nc = true;
                    }
                    if (b) {
                        nb = true;
                    }
                }
                b = nb;
                c = nc;
            }
            boolean ok = false;
            if (a[n - 1] == 0) {
                if (b) {
                    ok = true;
                }
            } else {
                if (c) {
                    ok = true;
                }
            }
            if (ok) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.print(sb.toString());
    }
}
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] b = new int[n + 1];
            int[] c = new int[n];
            Arrays.fill(b, n);
            for (int i = n - 1; i >= 0; i--) {
                c[i] = b[a[i]];
                b[a[i]] = i;
            }
            int res = 0;
            int prev = 0;
            int sup = -1;
            for (int i = 0; i < n; i++) {
                sup = Math.max(sup, c[i]);
                if (i >= prev && sup < n) {
                    res++;
                    prev = sup;
                    sup = -1;
                }
            }
            if (sup != -1) {
                res++;
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}

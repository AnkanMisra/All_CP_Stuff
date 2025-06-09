import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextLong();
            }
            long num = a[0] * n - a[n - 1];
            long den = (long) n * n - 1;
            if (num < 0 || num % den != 0) {
                System.out.println("NO");
                continue;
            }
            long y = num / den;
            long x = a[0] - y * n;
            if (x < 0) {
                System.out.println("NO");
                continue;
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                long want = x * (i + 1) + y * (n - i);
                if (a[i] != want) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

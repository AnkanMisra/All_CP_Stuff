import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, 1, n + 1);
            a[n + 1] = 0;
            int j = 0, k = 0;
            boolean ok = false;
            for (int i = 1; i <= n + 1; i++) {
                if (a[i] == a[i - 1]) {
                    j++;
                } else {
                    if (j >= 4 || (j >= 2 && k == 1)) {
                        ok = true;
                        break;
                    }
                    if (a[i] == a[i - 1] + 1) {
                        if (j >= 2) {
                            k = 1;
                        }
                    } else {
                        k = 0;
                    }
                    j = 1;
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }
}

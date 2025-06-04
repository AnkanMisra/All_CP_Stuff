import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] d = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                d[i] = sc.nextInt();
            }
            int[] l = new int[n + 1];
            int[] r = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
            }
            int[] low = new int[n + 1];
            int[] high = new int[n + 1];
            low[0] = 0;
            high[0] = 0;
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                int nl;
                int nh;
                if (d[i] == -1) {
                    nl = low[i - 1];
                    nh = high[i - 1] + 1;
                } else if (d[i] == 0) {
                    nl = low[i - 1];
                    nh = high[i - 1];
                } else {
                    nl = low[i - 1] + 1;
                    nh = high[i - 1] + 1;
                }
                low[i] = nl < l[i] ? l[i] : nl;
                high[i] = nh < r[i] ? nh : r[i];
                if (low[i] > high[i]) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                sb.append(-1).append('\n');
            } else {
                int[] ans = new int[n + 1];
                int hVal = low[n];
                for (int i = n; i >= 1; i--) {
                    if (d[i] != -1) {
                        ans[i] = d[i];
                    } else if (hVal >= low[i - 1] && hVal <= high[i - 1]) {
                        ans[i] = 0;
                    } else {
                        ans[i] = 1;
                    }
                    hVal -= ans[i];
                }
                for (int i = 1; i <= n; i++) {
                    sb.append(ans[i]);
                    if (i < n) {
                        sb.append(' ');
                    }
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}

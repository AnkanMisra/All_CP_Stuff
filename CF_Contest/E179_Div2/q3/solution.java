import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        StringBuilder c = new StringBuilder();
        while (b-- > 0) {
            int d = a.nextInt();
            int[] e = new int[d];
            for (int i = 0; i < d; i++) {
                e[i] = a.nextInt();
            }
            int[] f = new int[d + 1];
            int g = e[0], h = 1;
            for (int i = 1; i < d; i++) {
                if (e[i] == g) {
                    h++;
                } else {
                    if (h > f[g])
                        f[g] = h;
                    g = e[i];
                    h = 1;
                }
            }
            if (h > f[g])
                f[g] = h;
            long ans = Long.MAX_VALUE;
            for (int v = 1; v <= d; v++) {
                int k = f[v];
                if (k > 0) {
                    long cost = (long) (d - k) * v;
                    if (cost < ans)
                        ans = cost;
                }
            }
            c.append(ans).append('\n');
        }
        System.out.print(c);
    }
}

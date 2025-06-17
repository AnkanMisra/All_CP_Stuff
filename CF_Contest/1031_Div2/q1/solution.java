import java.util.Scanner;

public class Solution {

    private static int f(int a, int b, int c, int d, int e) {
        if (d == e) {
            int m = Math.min(b, c);
            if (a < m) {
                return 0;
            }
            return (a - m) / d + 1;
        }

        int p, q, r, s;
        if (d < e) {
            p = d;
            q = b;
            r = e;
            s = c;
        } else {
            p = e;
            q = c;
            r = d;
            s = b;
        }

        int ans = 0;

        if (a >= q) {
            int n = (a - q) / p + 1;
            ans += n;
            a -= n * p;
        }

        if (a >= s) {
            int n = (a - s) / r + 1;
            ans += n;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (testcases-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            sb.append(f(a, b, c, d, e)).append('\n');
        }

        System.out.print(sb);
    }
}

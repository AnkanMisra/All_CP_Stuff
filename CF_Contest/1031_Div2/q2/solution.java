import java.util.Scanner;

public class Solution {

    private static int mod(int v, int m) {
        int r = v % m;
        if (r < 0) {
            return r + m;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (testcases-- > 0) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            boolean sameRow = Math.abs(y1 - y2) < b;
            boolean sameCol = Math.abs(x1 - x2) < a;

            int mx1 = mod(x1, a);
            int mx2 = mod(x2, a);
            int my1 = mod(y1, b);
            int my2 = mod(y2, b);

            boolean ok;
            if (sameRow) {
                ok = mx1 == mx2;
            } else if (sameCol) {
                ok = my1 == my2;
            } else {
                ok = (mx1 == mx2) || (my1 == my2);
            }
            if (ok) {
                out.append("Yes\n");
            } else {
                out.append("No\n");
            }
        }
        System.out.print(out);
    }
}

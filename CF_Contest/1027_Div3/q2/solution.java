import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String c = sc.next();
            int d = 0;
            int e = 0;
            for (int i = 0; i < a; i++) {
                if (c.charAt(i) == '0') {
                    d++;
                } else {
                    e++;
                }
            }
            int f = a / 2 - b;
            if (d < f || e < f) {
                System.out.println("NO");
            } else {
                int g = d - f;
                int h = e - f;

                if (g % 2 == 0 && h % 2 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            testcases--;
        }
    }
}

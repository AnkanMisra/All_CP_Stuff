import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        while (a-- > 0) {
            int b = s.nextInt(), c = s.nextInt();
            int d = -1, e = -1;
            for (int f = 1; f <= b; f++) {
                int g = s.nextInt();
                if (g == 1) {
                    if (d == -1)
                        d = f;
                    e = f;
                }
            }
            if (e - d < c) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }
        }
    }
}

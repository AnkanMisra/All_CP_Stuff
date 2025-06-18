import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        StringBuilder c = new StringBuilder();
        while (testcases-- > 0) {
            int d = a.nextInt();
            String e = a.next();
            int[] f = new int[26];
            for (int h = 0; h < d; h++) {
                f[e.charAt(h) - 'a']++;
            }
            boolean g = false;
            for (int h = 1; h < d - 1 && !g; h++) {
                if (f[e.charAt(h) - 'a'] >= 2) {
                    g = true;
                }
            }
            if (g) {
                c.append("Yes\n");
            } else {
                c.append("No\n");
            }
        }
        String i = c.toString();
        System.out.println(i);
    }
}

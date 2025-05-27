import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        while (testcases != 0) {
            int c = a.nextInt();
            int d = Integer.MIN_VALUE;
            int e = 0;
            for (int i = 0; i < c; i++) {
                int f = a.nextInt();
                if (f >= d + 2) {
                    e++;
                    d = f;
                }
            }
            System.out.println(e);
            testcases--;
        }
    }
}

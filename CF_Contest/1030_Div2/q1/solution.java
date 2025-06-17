import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            if (k == 0) {
                for (int i = 0; i < n; i++)
                    System.out.print('0');
            } else if (k == n) {
                for (int i = 0; i < n; i++)
                    System.out.print('1');
            } else {
                System.out.print('1');
                int z = n - k - 1;
                for (int i = 0; i < z; i++)
                    System.out.print('0');
                for (int i = 0; i < k - 1; i++)
                    System.out.print('1');
                System.out.print('0');
            }
            System.out.println();
        }
    }
}

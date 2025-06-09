import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        while (b-- > 0) {
            int c = a.nextInt();
            System.out.print(1);
            for (int d = c; d >= 3; d--) {
                System.out.print(" " + d);
            }
            System.out.println(" 2");
        }
    }
}

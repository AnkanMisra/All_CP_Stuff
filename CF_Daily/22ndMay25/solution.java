import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int each_stesp = total / 5;
        if (total % 5 != 0) {
            each_stesp += 1;
        }
        System.out.println(each_stesp);
    }
}

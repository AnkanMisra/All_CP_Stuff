import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases != 0) {
            testcases--;
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            if (Math.min(a, c) >= Math.min(b, d)) {
                System.out.println("Gellyfish");
            } else {
                System.out.println("Flower");
            }
        }
    }
}

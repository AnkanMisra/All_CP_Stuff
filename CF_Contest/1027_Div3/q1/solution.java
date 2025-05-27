import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        while (b-- > 0) {
            String c = a.next();
            int d = Integer.parseInt(c);
            int e = (int) Math.sqrt(d);
            if (e * e != d) {
                System.out.println(-1);
            } else {
                System.out.println("0 " + e);
            }
        }
    }
}

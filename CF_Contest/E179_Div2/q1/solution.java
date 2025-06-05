import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        while (b-- > 0) {
            int c = a.nextInt();
            int k = 32 - Integer.numberOfLeadingZeros(c);
            System.out.println(2 * k + 1);
        }
    }
}

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (testcases!=0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (n == 1 && m == 1) {
                sb.append(0).append('\n');
            } else {
                long n1 = a < n - a + 1 ? a : n - a + 1;
                long m1 = b < m - b + 1 ? b : m - b + 1;
                long F1n = 64 - Long.numberOfLeadingZeros(n - 1);
                long F1m = 64 - Long.numberOfLeadingZeros(m - 1);
                long F1n1 = 64 - Long.numberOfLeadingZeros(n1 - 1);
                long F1m1 = 64 - Long.numberOfLeadingZeros(m1 - 1);
                long horiz = F1n1 + F1m;
                long vert = F1n + F1m1;
                sb.append(Math.min(horiz, vert) + 1).append('\n');
            }
        testcases--;
        }
        System.out.print(sb);
    }
}
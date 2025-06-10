import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long n = sc.nextLong();
        long w = sc.nextLong();
        long total = k * (w * (w + 1) / 2);
        long borrow = total > n ? total - n : 0;
        System.out.println(borrow);
    }
}

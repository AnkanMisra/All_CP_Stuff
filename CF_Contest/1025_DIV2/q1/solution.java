    import java.util.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t!=0) {
          int n = sc.nextInt();
          int m = sc.nextInt();
          int p = sc.nextInt();
          int q = sc.nextInt();
          if (n % p == 0 && m!= (n / p) * q) {
            sb.append("NO\n");
          } else {
            sb.append("YES\n");
          }
        t--;
        }
        System.out.print(sb);
      }
    }
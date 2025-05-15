import java.util.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    while (testcases!=0) {
      int n = sc.nextInt();
      int a1 = sc.nextInt();
      int x = Math.abs(a1);
      int countGreater = 0;
      for (int i = 1; i < n; i++) {
        int ai = sc.nextInt();
        if (Math.abs(ai) > x) {
          countGreater++;
        }
      }
      int requiredGreater = (n - 1) / 2;
      if (countGreater >= requiredGreater) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
      sb.append('\n');
    testcases--;
    }
    String ans=sb.toString();
    System.out.print(ans);
  }
}
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        if (!a.hasNextInt()) {
            return;
        }
        int testcases = a.nextInt();
        StringBuilder c = new StringBuilder();
        while (testcases-- > 0) {
            int d = a.nextInt();
            int e = a.nextInt();
            int f = Integer.MAX_VALUE;
            int g = Integer.MIN_VALUE;
            for (int h = 0; h < d; h++) {
                int i = a.nextInt();
                if (i < f){
                    f = i;
                }
                if (i > g){
                    g = i;
                } 
            }
            int j = g - f;
            int k = Math.min(Math.abs(e - f), Math.abs(e - g));
            int l = j + k;
            c.append(l).append('\n');
        }
       String result = c.toString();
       System.out.println(result);
    }
}

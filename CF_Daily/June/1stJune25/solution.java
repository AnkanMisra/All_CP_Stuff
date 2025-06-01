import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        double maxRadius = 0.0;
        maxRadius = Math.max(maxRadius, (double) a[0]);
        maxRadius = Math.max(maxRadius, (double) (l - a[n - 1]));

        for (int i = 0; i < n - 1; i++) {
            double distanceBetweenLanterns = a[i + 1] - a[i];
            maxRadius = Math.max(maxRadius, distanceBetweenLanterns / 2.0);
        }
        System.out.printf("%.10f\n", maxRadius);
    }
}

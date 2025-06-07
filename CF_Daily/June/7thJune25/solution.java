import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -1;
                }
            }
            int x, y;
            if (n % 2 == 0) {
                x = n / 2 - 1;
                y = n / 2 - 1;
            } else {
                x = n / 2;
                y = n / 2;
            }
            arr[x][y] = 0;
            int value = 1;
            int step = 1;
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            while (value < n * n) {
                for (int d = 0; d < 4; d++) {
                    int steps = step;
                    if (d % 2 == 1) step++;
                    int dx = dir[d][0], dy = dir[d][1];
                    for (int i = 0; i < steps; i++) {
                        x += dx;
                        y += dy;
                        if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == -1) {
                            arr[x][y] = value++;
                            if (value >= n * n) break;
                        }
                    }
                    if (value >= n * n) break;
                }
            }
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    row.append(arr[i][j]);
                    if (j + 1 < n) row.append(' ');
                }
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

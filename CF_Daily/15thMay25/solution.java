import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int oneRow = -1, oneCol = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    oneRow = i;
                    oneCol = j;
                }
            }
        }

        int moves = Math.abs(oneRow - 2) + Math.abs(oneCol - 2);
        System.out.println(moves);
    }
}
import java.util.*;

class Solution {
    public static int balanceSums(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, Integer> rowSum = new HashMap<>();
        Map<Integer, Integer> colSum = new HashMap<>();

        int maxRowSum = Integer.MIN_VALUE;
        int maxColSum = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int r = 0;
            int c = 0;
            for (int j = 0; j < col; j++) {
                r += mat[i][j];
                c += mat[j][i];
            }

            maxRowSum = Math.max(maxRowSum, r);
            maxColSum = Math.max(maxColSum, c);

            rowSum.put(i, r);
            colSum.put(i, c);
        }

        int maxSum = Math.max(maxRowSum, maxColSum);

        int ansRow = 0, ansCol = 0;

        for (int i = 0; i < row; i++) {
            if (rowSum.get(i) < maxSum) {
                ansRow += maxSum - rowSum.get(i);
            }
        }

        for (int i = 0; i < col; i++) {
            if (colSum.get(i) < maxSum) {
                ansCol += maxSum - colSum.get(i);
            }
        }

        return Math.max(ansRow, ansCol);
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        boolean goingUp = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (goingUp) {
                if (row == 0 || col == n - 1) {
                    goingUp = false;
                    if (col == n - 1) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            } else {
                if (col == 0 || row == m - 1) {
                    goingUp = true;
                    if (row == m - 1) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isRowZero = false, isColZero = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isRowZero = true;
                break;
            }
        }
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isColZero = true;
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < cols; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (isRowZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isColZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
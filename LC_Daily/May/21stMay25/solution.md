# Solution Explanation

### Intuition

To set entire rows and columns to zero in place when a zero is found, we can use the first row and first column of the matrix as markers to avoid extra space. We also need to separately track if the first row or first column should be zeroed.

### Approach

- Check if the first column or first row contains any zeros and store this information.
- For the rest of the matrix, if a cell is zero, mark its row and column by setting the corresponding first row and first column cell to zero.
- Iterate through the matrix (excluding the first row and column) and set cells to zero if their row or column is marked.
- Finally, zero out the first row and/or first column if needed.

### Code

```java
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
```

### Complexity

- **Time Complexity:** O(m * n), where m and n are the dimensions of the matrix.
- **Space Complexity:** O(1), since the algorithm uses the matrix itself for marking.

### Summary

- The solution uses the first row and column as markers to achieve constant space.
- It efficiently sets the required rows and columns to zero in place.

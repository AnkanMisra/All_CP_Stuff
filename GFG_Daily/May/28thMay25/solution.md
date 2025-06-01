# Solution Explanation

### Intuition

To find a rectangle with all four corners as 1, we can iterate through all possible top-left corners. For each top-left corner that is 1, we then look for a top-right corner (in the same row) and a bottom-left corner (in the same column). If both are found, we check if the corresponding bottom-right corner is also 1.

### Approach

- Iterate through each cell `(i, j)` in the matrix.
- If `mat[i][j]` is 1 (this is a potential top-left corner):
  - Iterate through all columns `k > j` in the same row `i`.
  - If `mat[i][k]` is 1 (this is a potential top-right corner):
    - Iterate through all rows `p > i` in the same column `j`.
    - If `mat[p][j]` is 1 (this is a potential bottom-left corner):
      - Check if `mat[p][k]` is also 1 (this is the bottom-right corner).
      - If all four corners are 1, return `true`.
- If no such rectangle is found after checking all possibilities, return `false`.

### Code

```java
class Solution {
    public boolean ValidCorner(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int r = i;
                    int c = j;
                    for (int k = j + 1; k < n; k++) {
                        if (mat[r][k] == 1) {
                            for (int p = r + 1; p < m; p++) {
                                if (mat[p][c] == 1 && mat[p][k] == 1) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
```

### Complexity

- **Time Complexity:** O(m^2 * n^2), where m and n are the dimensions of the matrix (due to four nested loops in the worst case).
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution iterates through all possible top-left corners and checks for corresponding top-right, bottom-left, and bottom-right corners.
- Returns `true` as soon as a valid rectangle is found.
- This brute-force approach is acceptable for the given constraints (m, n <= 200).

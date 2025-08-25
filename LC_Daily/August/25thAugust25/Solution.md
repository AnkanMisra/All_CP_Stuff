
# Solution Explanation

## Intuition
The key insight is that **diagonal traversal alternates direction** - we go up-right, then down-left, then up-right again. Each diagonal can be identified by the **sum of its row and column indices** (`i + j`). Elements on the same diagonal have the same sum value.

## Approach
1. **Identify diagonal pattern**: For an `m x n` matrix, there are `m + n - 1` diagonals total
2. **Direction alternation**: Even-indexed diagonals go **up-right** (decreasing row, increasing column), odd-indexed diagonals go **down-left** (increasing row, decreasing column)
3. **Boundary handling**: When we hit matrix boundaries, we need to **wrap around** to the next diagonal
4. **Traversal logic**:
   - Start at `(0, 0)`
   - For each position, determine if we're going up-right or down-left
   - Move in that direction until we hit a boundary
   - When hitting boundary, move to the start of next diagonal

## Algorithm
1. Initialize result array of size `m * n`
2. Start at position `(0, 0)` with direction flag
3. For each element:
   - Add current element to result
   - If going **up-right** (`row--`, `col++`):
     - If hit top boundary or right boundary, change direction and move to next diagonal start
   - If going **down-left** (`row++`, `col--`):
     - If hit bottom boundary or left boundary, change direction and move to next diagonal start
4. Continue until all elements are processed

## Complexity
- **Time Complexity:** `O(m * n)` - we visit each element exactly once
- **Space Complexity:** `O(1)` - only using constant extra space (excluding output array)

## Summary
This approach works by **recognizing the diagonal pattern** and handling direction changes at boundaries. The key insight is that we alternate between up-right and down-left movements, and carefully handle boundary conditions to transition between diagonals. **Corner cases** include single row/column matrices and ensuring proper boundary detection for both directions.
```java
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

```

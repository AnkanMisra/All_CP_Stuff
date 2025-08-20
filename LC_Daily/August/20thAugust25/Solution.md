

# Solution Explanation

## Intuition
For every cell that contains `1`, we want to know the largest square whose **bottom-right corner** is at that cell. If we already know this size for cells in the previous row and previous column, we can derive it in `O(1)` time per cell. Summing these sizes over the whole matrix directly yields the total number of all-ones squares.

## Approach
1. Create a **dynamic programming (DP)** array `dp` where `dp[j]` holds the size of the largest all-ones square ending at the current row and column `j` (1-indexed in the DP array).
2. Iterate row by row. While processing column `j` on the current row:
   - Let `prev[j]` be the size for the cell directly above, `prev[j-1]` for the cell above-left, and `dp[j-1]` (which we have just updated) for the cell directly left.
   - If the current matrix value is `1`, then the largest square ending here is
     `1 + min(prev[j], prev[j-1], dp[j-1])`.
   - If the matrix value is `0`, the largest square ending here is `0`.
3. Add the obtained size to an accumulator `total` — every size `k` contributes `k` different squares (side lengths `1 … k`) ending at this cell.
4. Continue for all rows; the accumulator is the answer.

## Complexity
- **Time Complexity:** `O(m · n)` — one pass through the matrix.
- **Space Complexity:** `O(n)` — only the previous row and current row are stored.

## Summary
The key observation is that the size of the largest square ending at `(i, j)` depends only on the three neighbors **above**, **left**, and **above-left**. A one-dimensional DP suffices because we process the matrix row by row, giving an optimal `O(m · n)` solution with constant-factor memory.
```java
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n + 1];
        int total = 0;

        for (int i = 1; i <= m; i++) {
            int diagUpLeft = 0;
            for (int j = 1; j <= n; j++) {
                int temp = prev[j];
                if (matrix[i - 1][j - 1] == 1) {
                    prev[j] = 1 + Math.min(Math.min(prev[j], prev[j - 1]), diagUpLeft);
                    total += prev[j];
                } else {
                    prev[j] = 0;
                }
                diagUpLeft = temp;
            }
        }

        return total;
    }
}
```

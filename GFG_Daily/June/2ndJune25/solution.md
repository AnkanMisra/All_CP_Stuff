# Solution Explanation

### Intuition

We need to count the number of unique paths from the top-left to the bottom-right of a grid, moving only right or down, and avoiding cells with value 1 (blocked). This is a classic dynamic programming problem, but with obstacles.

### Approach

- Use a 2D DP array where `dp[i][j]` represents the number of ways to reach cell `(i, j)`.
- Initialize the first row and first column:
  - If a cell is blocked, all cells after it in that row/column are unreachable.
  - Otherwise, set `dp[0][i] = 1` and `dp[i][0] = 1` for open cells.
- For each cell `(i, j)` (starting from 1, 1):
  - If the cell is not blocked (`grid[i][j] == 0`), set `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
  - If the cell is blocked, leave `dp[i][j] = 0`.
- The answer is `dp[n-1][m-1]`.

### Algorithm

1. Initialize a 2D DP array of size `n x m` with zeros.
2. Fill the first row and first column based on whether the cells are blocked.
3. For each cell `(i, j)` (i > 0, j > 0), update `dp[i][j]` as the sum of paths from the top and left if the cell is not blocked.
4. Return `dp[n-1][m-1]` as the result.

### Complexity

- **Time Complexity:** O(n * m), where n and m are the dimensions of the grid.
- **Space Complexity:** O(n * m), for the DP array.

### Summary

- The solution uses dynamic programming to count the number of unique paths, considering obstacles.
- It efficiently fills the DP table by only allowing moves to open cells.
- The approach is optimal for the given constraints and handles all edge cases.

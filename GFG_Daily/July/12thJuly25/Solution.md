
# Solution Explanation

## Intuition
The main idea is to use **dynamic programming** to keep track of the maximum gold that can be collected from each cell, considering all possible moves (right, right-up, right-down) at each step. By storing results for subproblems, we avoid redundant calculations and efficiently find the optimal path.

## Approach
- For each cell in the first column, start a recursive search to find the maximum gold collectible from that cell to the last column.
- At each cell `(i, j)`, the miner can move to:
  - `(i-1, j+1)` (diagonally up-right)
  - `(i, j+1)` (right)
  - `(i+1, j+1)` (diagonally down-right)
- Use a **DP table** `dp[i][j]` to store the maximum gold collectible from cell `(i, j)` to the end, to avoid recomputation.
- The answer is the maximum value among all starting positions in the first column.

## Complexity
- **Time Complexity:** `O(n * m)`
- **Space Complexity:** `O(n * m)`

## Summary
This approach works because **dynamic programming** ensures that each subproblem (maximum gold from a cell) is solved only once, and all possible paths are considered. The solution efficiently finds the optimal path by exploring all valid moves at each step and using memoization to avoid redundant work. **Edge cases** like boundaries (first/last row) are handled by checking indices before moving.


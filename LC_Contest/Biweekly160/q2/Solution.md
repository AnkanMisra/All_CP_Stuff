# Solution Explanation

## Intuition
The problem requires finding the minimum cost path from the top-left to the bottom-right of a grid, alternating between moving (right or down) and waiting in place. The cost to enter a cell and the cost to wait are both significant, so we must carefully plan the sequence of moves and waits to minimize the total cost.

## Approach
- Use **dynamic programming** to keep track of the minimum cost to reach each cell.
- For each cell `(i, j)`, the minimum cost to reach it is the minimum of:
  - The cost to reach the cell above `(i-1, j)` plus the entry and wait costs.
  - The cost to reach the cell to the left `(i, j-1)` plus the entry and wait costs.
- Since the movement alternates between moving and waiting, for every move to a new cell, we must also account for a wait at that cell (unless it is the destination).
- Use a 1D array to optimize space, updating the minimum cost for each column as we iterate through the grid row by row.
- The starting cell `(0, 0)` is initialized with its entry cost.
- For each cell, if it is not the destination, add both the entry cost and the wait cost; for the destination, only add the entry cost.
- The answer is the minimum cost to reach the bottom-right cell, plus the entry cost for the starting cell.

## Complexity
- **Time Complexity:** `O(m * n)`
- **Space Complexity:** `O(n)`

## Summary
This approach works because it systematically considers all possible ways to reach each cell, always choosing the path with the lowest accumulated cost. By alternating between moving and waiting, and by using a space-efficient dynamic programming array, we ensure that the solution is both correct and efficient for large grids. The key insight is to account for the alternating move/wait pattern and to optimize space by only keeping the current row's costs.


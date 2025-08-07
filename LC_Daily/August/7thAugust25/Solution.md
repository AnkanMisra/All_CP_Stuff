
# Solution Explanation

## Intuition
The problem involves **three children** starting from different corners of an `n x n` grid, each following specific movement rules to reach the bottom-right corner `(n-1, n-1)`. The key insight is that we can **decompose this into three separate optimization problems**: one child follows the main diagonal, while the other two children optimize their paths in their respective triangular regions.

## Approach
The solution uses **dynamic programming with memoization** to solve three subproblems:

1. **First child** starting from `(0,0)`: This child will naturally follow the main diagonal path `(0,0) -> (1,1) -> ... -> (n-1,n-1)`, collecting fruits along the diagonal.

2. **Second child** starting from `(0,n-1)`: Uses `solve1` function to find the optimal path in the upper triangular region above the main diagonal. The child can move down `(i+1,j)`, diagonally down-left `(i+1,j-1)`, or diagonally down-right `(i+1,j+1)`.

3. **Third child** starting from `(n-1,0)`: Uses `solve2` function to find the optimal path in the lower triangular region below the main diagonal. The child can move right `(i,j+1)`, diagonally up-right `(i-1,j+1)`, or diagonally down-right `(i+1,j+1)`.

## Algorithm
1. Calculate the total fruits collected by the first child along the main diagonal.
2. Use memoized recursion `solve1` to find maximum fruits the second child can collect in the upper triangle.
3. Use memoized recursion `solve2` to find maximum fruits the third child can collect in the lower triangle.
4. Sum all three results to get the maximum total fruits.

## Complexity
- **Time Complexity:** `O(n²)` - Each cell in the grid is visited at most once due to memoization
- **Space Complexity:** `O(n²)` - Two memoization tables of size `n x n` plus recursion stack space

## Summary
This approach works by **partitioning the grid** into three regions: the main diagonal (first child), upper triangle (second child), and lower triangle (third child). The movement constraints naturally prevent conflicts between children in different regions. The memoization ensures optimal substructure is leveraged, avoiding redundant calculations. Key considerations include boundary checks and ensuring children don't cross into each other's designated regions.


# Solution Explanation

## Intuition
To maximize the sum of MEX values over all subgrids, we want to spread out the smallest numbers as much as possible so that small subgrids are less likely to contain all small values. Placing the smallest values in the center and spiraling outwards ensures that the smallest numbers are not clustered together, which helps maximize the MEX in many subgrids.

## Approach
- Start by initializing an n x n grid with all values set to -1.
- Place 0 at the center of the grid (for even n, use the upper-left of the central 2x2 block).
- Fill the grid in a spiral order starting from the center, incrementing the value each time.
- The spiral order ensures that consecutive numbers are not adjacent, which helps maximize the MEX in subgrids.
- After filling the grid, print it row by row.

## Complexity
- Time Complexity: O(n^2) per test case, as each cell is filled exactly once.
- Space Complexity: O(n^2) per test case for the grid.

## Summary
By filling the grid in a spiral order from the center, the smallest numbers are distributed as far apart as possible, which helps maximize the sum of MEX values over all subgrids. This construction is efficient and works for all allowed values of n.

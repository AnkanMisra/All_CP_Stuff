# Solution Explanation

## Intuition
The key insight is that for a grid with only one row or one column, or a 2x2 grid, every path is greedy or can be made greedy, so it is **impossible** to construct a grid where no greedy path achieves the maximum value. For all other grid sizes, it is **possible** to construct such a grid.

## Approach
- If either `n = 1` or `m = 1`, or both `n = 2` and `m = 2`, output `NO`.
- Otherwise, output `YES`.
- The construction for larger grids (e.g., `n ≥ 3` and `m ≥ 3`, or one dimension ≥ 2 and the other > 2) is possible by carefully assigning values so that the maximum sum path is not greedy (as shown in the problem's example).

## Complexity
- **Time Complexity:** `O(1)` per test case
- **Space Complexity:** `O(1)`

## Summary
- **Single row, single column, or 2x2 grids:** Impossible to construct the required grid (**output `NO`**).
- **All other grid sizes:** Possible to construct such a grid (**output `YES`**).
- The solution relies on the fact that in larger grids, you can always design the grid so that the greedy path does not achieve the maximum sum, but in the small cases, all maximal paths are necessarily greedy.


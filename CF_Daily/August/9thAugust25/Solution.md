
# Solution Explanation

## Intuition
The key insight is to **maintain connectivity** while converting exactly `k` empty cells to walls. We can achieve this by using a **depth-first search (DFS) traversal** to visit exactly `(total_empty - k)` cells, ensuring they remain connected. All unvisited empty cells can then be safely converted to walls without breaking connectivity.

## Approach
The solution uses a **greedy DFS approach** to preserve connectivity:

1. **Count and locate**: Count total empty cells and find any starting position
2. **Calculate target**: Determine how many cells to keep as empty (`keep = total_empty - k`)
3. **DFS traversal**: Use a stack-based DFS to visit exactly `keep` cells starting from any empty cell
4. **Mark connected component**: All visited cells form a **connected component** that will remain empty
5. **Convert remaining**: All unvisited empty cells are converted to walls (`X`)

## Algorithm
1. Parse input and build the `grid`
2. Count `empty` cells and store any empty cell coordinates as `startR, startC`
3. Calculate `keep = empty - k` (number of cells to remain empty)
4. Initialize `visited` array and DFS `stack` with the starting position
5. **DFS Loop**: While stack is not empty and `visited < keep`:
   - Peek current cell from stack
   - Try to push unvisited neighbors in all 4 directions
   - If no neighbors can be pushed, pop current cell (backtrack)
   - Stop when exactly `keep` cells are visited
6. Convert all unvisited empty cells (`.`) to walls (`X`)
7. Output the modified grid

## Complexity
- **Time Complexity**: `O(n * m)` - Each cell is visited at most once during DFS
- **Space Complexity**: `O(n * m)` - For the visited array and stack storage

## Summary
This approach works because **DFS guarantees connectivity** among visited cells. By visiting exactly `(total_empty - k)` cells, we ensure the remaining empty cells form a connected component. The **greedy nature** of DFS ensures we find a valid solution efficiently. **Key insight**: We don't need to find the optimal set of cells to remove - any connected subset of the required size works due to the problem's guarantee that a solution exists.



# Solution Explanation

## Intuition
The key insight is to **traverse diagonals systematically** using coordinate-based movement. We use a **flag-based approach** to distinguish between bottom-left triangle diagonals (which need **non-increasing order**) and top-right triangle diagonals (which need **non-decreasing order**). The algorithm starts from the bottom-left corner and moves through each diagonal sequentially.

## Approach
1. **Initialize coordinates**: Start with `x = n-2, y = 0` and `flag = true` to begin processing bottom-left diagonals
2. **Traverse diagonals systematically**: Use coordinate pairs `(x, y)` as starting points for each diagonal
3. **Process based on triangle type**:
   - When `flag = true`: Process **bottom-left triangle** diagonals in **non-increasing order** (descending)
   - When `flag = false`: Process **top-right triangle** diagonals in **non-decreasing order** (ascending)
4. **Coordinate movement logic**:
   - For bottom-left diagonals: Decrement `x` after each diagonal
   - For top-right diagonals: Increment `y` after each diagonal
   - Switch from bottom-left to top-right when `x = -1`

## Algorithm
1. Start with coordinates `(n-2, 0)` and `flag = true`
2. For each diagonal starting at `(x, y)`:
   - Extract all elements along the diagonal direction `(tempX++, tempY++)`
   - Sort based on current triangle type (flag determines sorting order)
   - Place sorted elements back along the same diagonal path
3. Update coordinates based on current triangle being processed
4. Continue until all diagonals are processed (`y <= n-2`)

## Complexity
- **Time Complexity:** `O(n^2 log n)` - We process each diagonal once and sort elements within each diagonal
- **Space Complexity:** `O(n)` - Additional space for storing diagonal elements during sorting

## Summary
This **coordinate-based traversal approach** efficiently processes diagonals by using systematic movement patterns. The **flag mechanism** elegantly handles the transition between bottom-left and top-right triangles. **Corner cases** are naturally handled as single-element diagonals remain unchanged after sorting.
```java
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid[0].length;
        int x = n - 2, y = 0;
        boolean flag = true;

        while (y <= n - 2) {
            List<Integer> diagonal = new ArrayList<>();
            if (flag == true) {
                for (int tempX = x, tempY = y; tempX < n && tempY < n; tempX++, tempY++)
                    diagonal.add(grid[tempX][tempY]);
                diagonal.sort(Collections.reverseOrder());
                for (int tempX = x, tempY = y, i = 0; tempX < n && tempY < n; tempX++, tempY++, i++)
                    grid[tempX][tempY] = diagonal.get(i);
                x--;
            } else {
                for (int tempX = x, tempY = y; tempX < n && tempY < n; tempX++, tempY++)
                    diagonal.add(grid[tempX][tempY]);
                Collections.sort(diagonal);
                for (int tempX = x, tempY = y, i = 0; tempX < n && tempY < n; tempX++, tempY++, i++)
                    grid[tempX][tempY] = diagonal.get(i);
                y++;
            }
            if (x == -1) {
                flag = false;
                x = 0;
                y = 1;
            }
        }

        return grid;
    }
}
```


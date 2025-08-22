
# Solution Explanation

## Intuition
The smallest axis-aligned rectangle covering every `1` is exactly the **bounding box** of all cells containing `1`. Hence we only need the extreme row and column indices.

## Approach
1. Initialize `top = m`, `bottom = -1`, `left = n`, `right = -1`.
2. Scan every cell in `grid`.
   - Whenever a `1` is seen, update extremes:
     - `top = min(top, i)`
     - `bottom = max(bottom, i)`
     - `left = min(left, j)`
     - `right = max(right, j)`
3. After the scan the rectangle height is `bottom - top + 1` and width is `right - left + 1`.
4. The answer is the product of height and width.

## Complexity
- **Time complexity:** `O(m · n)` — we visit each cell once.
- **Space complexity:** `O(1)` — only constant extra variables.

## Summary
By locating the **minimum and maximum rows and columns** that contain a `1`, we directly derive the rectangle that encloses them. Multiplying its height and width yields the minimum area.
```java
class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int top = m, left = n, bottom = -1, right = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i < top) top = i;
                    if (i > bottom) bottom = i;
                    if (j < left) left = j;
                    if (j > right) right = j;
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
```

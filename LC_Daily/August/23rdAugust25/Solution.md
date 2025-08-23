
# Solution Explanation

## Intuition
Since we need exactly **3 non-overlapping rectangles** to cover all 1's, we can think of this as **partitioning the grid** into 3 regions. The key insight is that we can try all possible ways to divide the grid either **horizontally** (into 3 horizontal strips) or **vertically** (into 3 vertical strips), or a **combination** (2 rectangles in one part, 1 rectangle in another part).

## Approach
We need to consider **6 different partitioning strategies**:

1. **Three horizontal strips**: Divide grid into 3 horizontal regions
2. **Three vertical strips**: Divide grid into 3 vertical regions
3. **Top rectangle + bottom split**: One rectangle covers top portion, bottom portion split into 2 vertical rectangles
4. **Bottom rectangle + top split**: One rectangle covers bottom portion, top portion split into 2 vertical rectangles
5. **Left rectangle + right split**: One rectangle covers left portion, right portion split into 2 horizontal rectangles
6. **Right rectangle + left split**: One rectangle covers right portion, left portion split into 2 horizontal rectangles

For each partitioning strategy:
- Try all possible **split positions**
- For each region, find the **minimum bounding rectangle** that covers all 1's in that region
- Calculate the **total area** of the 3 rectangles
- Keep track of the **minimum total area**

## Algorithm
1. **Preprocess**: Find all positions of 1's in the grid
2. **Helper function**: Create a function to calculate minimum rectangle area for a given region
3. **Try all 6 partitioning strategies**:
   - For horizontal/vertical splits: try all possible split positions
   - For mixed splits: try all combinations of horizontal and vertical splits
4. **Return** the minimum area found across all strategies

## Complexity
- **Time Complexity**: `O(m^2 * n^2)` where `m` is number of rows and `n` is number of columns
  - We try `O(m)` horizontal splits and `O(n)` vertical splits
  - For each split, we calculate bounding rectangles in `O(m * n)` time
- **Space Complexity**: `O(1)` excluding input space

## Summary
This problem requires **systematic enumeration** of all possible ways to partition the grid into 3 regions. The key insight is that optimal partitions will always be **axis-aligned cuts** (either horizontal or vertical). By trying all possible combinations of cuts and calculating minimum bounding rectangles for each region, we can find the optimal solution. The **constraint that grid size ≤ 30** makes the `O(m^2 * n^2)` approach feasible.
```java
class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minArea = Integer.MAX_VALUE;

        for (int i = 1; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, n - 1);
                int area2 = getRectArea(grid, i, j - 1, 0, n - 1);
                int area3 = getRectArea(grid, j, m - 1, 0, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, m - 1, 0, i - 1);
                int area2 = getRectArea(grid, 0, m - 1, i, j - 1);
                int area3 = getRectArea(grid, 0, m - 1, j, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, n - 1);
                int area2 = getRectArea(grid, i, m - 1, 0, j - 1);
                int area3 = getRectArea(grid, i, m - 1, j, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int area1 = getRectArea(grid, 0, i - 1, 0, j - 1);
                int area2 = getRectArea(grid, 0, i - 1, j, n - 1);
                int area3 = getRectArea(grid, i, m - 1, 0, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, m - 1, 0, i - 1);
                int area2 = getRectArea(grid, 0, j - 1, i, n - 1);
                int area3 = getRectArea(grid, j, m - 1, i, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int area1 = getRectArea(grid, 0, j - 1, 0, i - 1);
                int area2 = getRectArea(grid, j, m - 1, 0, i - 1);
                int area3 = getRectArea(grid, 0, m - 1, i, n - 1);
                if (area1 > 0 && area2 > 0 && area3 > 0) {
                    minArea = Math.min(minArea, area1 + area2 + area3);
                }
            }
        }

        return minArea;
    }

    private int getRectArea(int[][] grid, int r1, int r2, int c1, int c2) {
        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        boolean hasOne = false;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    hasOne = true;
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return hasOne ? (maxRow - minRow + 1) * (maxCol - minCol + 1) : 0;
    }
}

```

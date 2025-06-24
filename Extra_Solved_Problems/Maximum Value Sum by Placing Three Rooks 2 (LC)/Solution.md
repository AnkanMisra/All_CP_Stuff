# Solution Explanation

## Intuition
The problem is to place three rooks on a chessboard such that no two are in the same row or column, and the sum of the values of the cells they occupy is maximized. This is equivalent to selecting three distinct rows and three distinct columns, and picking one cell from each row and column.

## Approach
- **Brute Force on Rows:**  
  - Iterate over all possible combinations of three distinct rows.
- **Brute Force on Columns:**  
  - For each combination of three rows, iterate over all possible combinations of three distinct columns.
- **Try All Permutations:**  
  - For each combination of three rows and three columns, try all 3! = 6 permutations to assign columns to rows, and compute the sum for each assignment.
- **Track the Maximum:**  
  - Keep track of the maximum sum found.

**Note:**  
The provided code uses a slightly different approach:  
- It iterates over all possible triplets of rows (x, y, z) and all possible triplets of columns (p, q, r), ensuring all indices are distinct.
- For each such combination, it computes the sum of the values at (x, p), (y, q), and (z, r), and updates the answer if this sum is greater than the current maximum.

## Complexity
- **Time Complexity:** O(h^3 * w^3), where h is the number of rows and w is the number of columns. This is feasible for small boards but may be slow for the largest allowed sizes.
- **Space Complexity:** O(1), only a few variables for tracking the answer.

## Summary
**By brute-forcing all possible combinations of three distinct rows and columns, and checking all possible assignments, we can find the maximum sum for placing three non-attacking rooks.**  
This approach is simple and guarantees correctness for the given constraints.

```java
class Solution {
    public long maximumValueSum(int[][] a) {
        int h = a.length, w = a[0].length;
        long ans = Long.MIN_VALUE;
        for (int x = 0; x < h; ++x) {
            for (int y = x + 1; y < h; ++y) {
                for (int z = y + 1; z < h; ++z) {
                    for (int p = 0; p < w; ++p) {
                        for (int q = 0; q < w; ++q) {
                            if (q == p) {
                                continue;
                            } else {
                                for (int r = 0; r < w; ++r) {
                                    if (r == p || r == q) {
                                        continue;
                                    } else {
                                        long s = (long)a[x][p] + a[y][q] + a[z][r];
                                        if (s > ans) {
                                            ans = s;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
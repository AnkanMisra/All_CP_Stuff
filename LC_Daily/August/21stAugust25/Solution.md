
# Solution Explanation

## Intuition
Convert each row into a histogram of consecutive `1`s above it. For a fixed bottom row, the number of all-ones submatrices ending at this row equals the total number of sub-arrays in the histogram whose minimum height is positive. A monotonic stack can aggregate these counts in linear time per row.

## Approach
1. Maintain an array `heights` of length `n` (number of columns).
   * For each row `i`, update `heights[j] = heights[j] + 1` if `mat[i][j] == 1`, otherwise set to `0`.
2. With the updated `heights`, count all sub-arrays whose minimum height `> 0`:
   * Iterate columns left to right with a **monotonic increasing stack** storing pairs `{height, count}`.
   * When the current `height` is smaller than the stack top, pop elements, subtract their contribution, and accumulate their `count`.
   * Push the merged pair, add its contribution `height * count` to a running `sum` representing the rectangles ending at current column.
   * Add `sum` to the global answer.
3. Repeat for every row; the accumulated answer is the total number of all-ones submatrices.

## Complexity
- **Time Complexity:** `O(m · n)` — each cell is processed a constant number of times.
- **Space Complexity:** `O(n)` — the `heights` array and stack.

## Summary
Treating rows as histogram bases reduces the 2-D problem to repeated 1-D sub-array counting. A monotonic stack efficiently sums, for each position, how many sub-arrays end there with a given minimum height, yielding an overall `O(m · n)` solution with `O(n)` extra space.
```java
class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = (mat[i][j] == 0) ? 0 : heights[j] + 1;
            }
            Deque<int[]> stack = new ArrayDeque<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int cnt = 1;
                while (!stack.isEmpty() && stack.peek()[0] >= heights[j]) {
                    int[] top = stack.pop();
                    sum -= top[0] * top[1];
                    cnt += top[1];
                }
                stack.push(new int[]{heights[j], cnt});
                sum += heights[j] * cnt;
                result += sum;
            }
        }
        return result;
    }
}
```

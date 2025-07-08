
# Solution Explanation

## Intuition
The key insight is to recognize that, since no two consecutive chosen students can be from the same row and the indices must strictly increase, this problem can be solved using **dynamic programming**. At each position, we can decide whether to pick the student from the first row or the second row, but if we pick from one row, the previous pick must have been from the other row.

## Approach
- Define two variables:
  - `bestRow1`: the **maximum total height** achievable by ending the selection at the current index with a student from the **first row**.
  - `bestRow2`: the **maximum total height** achievable by ending the selection at the current index with a student from the **second row**.
- For each index from `0` to `n-1`:
  - If we pick the student from the **first row** at index `i`, the previous pick (if any) must have been from the **second row** at an earlier index. So, the best total is `row1[i] + bestRow2`.
  - If we pick the student from the **second row** at index `i`, the previous pick (if any) must have been from the **first row** at an earlier index. So, the best total is `row2[i] + bestRow1`.
  - Update `bestRow1` and `bestRow2` to be the maximum of their current value and the new total at this index.
- After processing all indices, the answer is the maximum of `bestRow1` and `bestRow2`.

## Complexity
- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

## Summary
This approach works because at each step, the optimal choice for each row depends only on the best result from the other row up to the previous index. By maintaining only two variables, we efficiently compute the **maximum possible total height** while respecting the constraints. The solution is both **efficient** and **simple**, handling all edge cases, including when only one student is present in each row.


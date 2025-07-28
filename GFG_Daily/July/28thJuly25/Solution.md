
# Solution Explanation

## Intuition
To make a matrix "beautiful", we need to ensure that **all row sums and column sums are equal**. The key insight is that we should target the **maximum possible sum** among all current row and column sums, since we can only add elements (not subtract). This minimizes the total operations needed.

## Approach
The solution follows a **greedy approach** by calculating the deficit for each row and column separately, then choosing the scenario that requires fewer operations:

1. **Calculate all row sums and column sums** and store them in hash maps
2. **Find the maximum sum** among all rows and columns - this becomes our target
3. **Calculate row operations**: For each row with sum less than target, add the difference to total row operations
4. **Calculate column operations**: For each column with sum less than target, add the difference to total column operations
5. **Return the maximum** of row operations and column operations

## Algorithm
1. Initialize hash maps for `rowSum` and `colSum`
2. For each row `i` from `0` to `row-1`:
   - Calculate sum of row `i` and sum of column `i`
   - Track maximum row sum and maximum column sum
   - Store sums in respective hash maps
3. Set `maxSum = max(maxRowSum, maxColSum)`
4. Calculate `ansRow`: sum of deficits for all rows below `maxSum`
5. Calculate `ansCol`: sum of deficits for all columns below `maxSum`
6. Return `max(ansRow, ansCol)`

## Complexity
- **Time Complexity:** `O(n^2)` where `n` is the dimension of the square matrix (assuming `row = col = n`)
- **Space Complexity:** `O(n)` for storing row and column sums in hash maps

## Summary
This approach works because we **target the highest existing sum** as our goal, ensuring we only need to add elements. The algorithm efficiently calculates the minimum operations by considering both row-wise and column-wise balancing scenarios and choosing the better option. The key insight is that we cannot reduce sums, only increase them, so targeting the maximum sum is optimal.


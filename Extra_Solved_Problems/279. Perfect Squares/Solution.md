
# Solution Explanation

## Intuition
This problem can be solved using **dynamic programming with memoization**. The key insight is to treat this as an **unbounded knapsack problem** where we have unlimited access to perfect squares and want to find the minimum number of them that sum to `n`.

## Approach
The solution uses a **top-down dynamic programming approach** with the following steps:

1. **Generate all perfect squares** up to `n` by iterating from `1` to `sqrt(n)` and storing `i*i` values
2. **Create a memoization table** `dp[i][target]` where `i` represents the index in the perfect squares array and `target` is the remaining sum needed
3. **Use recursive helper function** that explores two choices at each step:
   - **Include the current perfect square** (if it doesn't exceed the target) and add 1 to the count
   - **Exclude the current perfect square** and move to the next smaller perfect square
4. **Return the minimum** of both choices
5. **Base cases:**
   - If `target == 0`, return `0` (no more squares needed)
   - If `idx == 0`, return a large value (no squares available)

## Complexity
- **Time Complexity:** `O(n * sqrt(n))` - We have `sqrt(n)` perfect squares and for each we might compute up to `n` different target values
- **Space Complexity:** `O(n * sqrt(n))` - For the memoization table plus `O(sqrt(n))` for recursion stack

## Summary
This approach works by **systematically exploring all combinations** of perfect squares while using memoization to avoid recomputing the same subproblems. The key insight is recognizing this as an unbounded knapsack variant where we want to **minimize the count rather than maximize value**. The solution handles edge cases well and ensures we always find the optimal (minimum) number of perfect squares needed.


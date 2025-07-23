
# Solution Explanation

## Intuition
The key insight is to **sort the friends by their money amounts** and use a **sliding window** to find the largest group where the difference in money between the richest and poorest is less than `d`, maximizing the sum of friendship factors.

## Approach
- Sort the friends based on their money.
- Compute prefix sums of friendship factors for efficient range sum queries.
- Use two pointers to maintain a window where the money difference condition is satisfied, updating the maximum sum.

## Complexity
- Time Complexity: `O(n log n)` due to sorting; the sliding window is `O(n)`.
- Space Complexity: `O(n)` for storing friends and prefix sums.

## Summary
This approach efficiently finds the optimal group by ensuring no friend feels poor while maximizing friendship, handling large `n` effectively through sorting and linear traversal.


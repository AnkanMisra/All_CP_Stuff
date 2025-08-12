
# Solution Explanation

## Intuition
The key insight is to use a **greedy approach** with sorting. To minimize cost, we should buy the cheapest candies and get the most expensive ones for free. To maximize cost, we should buy the most expensive candies and get the cheapest ones for free.

## Approach
The solution uses **two-pointer technique** after sorting the prices array:

1. **Sort the prices array** in ascending order to easily access cheapest and most expensive candies
2. **For minimum cost**: Start from the cheapest candy (left pointer), buy it, and skip the next `k` most expensive candies (move right pointer left by `k`)
3. **For maximum cost**: Start from the most expensive candy (right pointer), buy it, and skip the next `k` cheapest candies (move left pointer right by `k`)
4. Continue until all candies are either bought or obtained for free

## Algorithm
1. Sort the `prices` array in ascending order
2. **Minimum Cost Calculation**:
   - Initialize `start = 0`, `end = n-1`, `minCost = 0`
   - While `start <= end`:
     - Add `prices[start]` to `minCost` (buy cheapest)
     - Increment `start` by 1
     - Decrement `end` by `k` (get k most expensive for free)
3. **Maximum Cost Calculation**:
   - Reset `start = 0`, `end = n-1`, `maxCost = 0`
   - While `start <= end`:
     - Add `prices[end]` to `maxCost` (buy most expensive)
     - Decrement `end` by 1
     - Increment `start` by `k` (get k cheapest for free)
4. Return `[minCost, maxCost]`

## Complexity
- **Time Complexity:** `O(n log n)` due to sorting the prices array
- **Space Complexity:** `O(1)` excluding the space used for the output array

## Summary
This **greedy approach** works because we want to maximize the value of free candies in each case. For minimum cost, we buy cheap and get expensive candies free. For maximum cost, we buy expensive and get cheap candies free. The two-pointer technique efficiently tracks which candies have been bought or obtained for free.


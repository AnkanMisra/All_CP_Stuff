
# Solution Explanation

## Intuition
The key insight is that if we can partition the array into two subsets with sums `S1` and `S2`, then `S1 + S2 = totalSum`. To **minimize the absolute difference** `|S1 - S2|`, we want to make `S1` and `S2` as close as possible. This means we want to find a subset with sum as close as possible to `totalSum/2`.

## Approach
This problem can be solved using **dynamic programming** based on the **subset sum problem**:

1. **Calculate total sum** of all array elements
2. **Create a DP table** `dp[i][j]` where `dp[i][j]` represents whether it's possible to achieve sum `j` using first `i` elements
3. **Fill the DP table** using the recurrence relation:
   - If `arr[i-1] <= j`: `dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j]`
   - Else: `dp[i][j] = dp[i-1][j]`
4. **Find the closest sum to totalSum/2** by checking all possible sums from `0` to `totalSum/2`
5. **Calculate minimum difference** as `|totalSum - 2*closestSum|`

## Algorithm
1. Initialize DP table with base cases: `dp[i][0] = true` (sum 0 is always possible with empty subset)
2. For each element and each possible sum, determine if the sum is achievable
3. Iterate through all possible sums up to `totalSum/2` and find the largest achievable sum
4. The minimum difference will be `totalSum - 2*largestAchievableSum`

## Complexity
- **Time Complexity:** `O(n * sum)` where `n` is the number of elements and `sum` is the total sum of array elements
- **Space Complexity:** `O(n * sum)` for the DP table

## Summary
This approach works by **transforming the partition problem into a subset sum problem**. By finding the subset with sum closest to half of the total sum, we ensure the **minimum possible difference** between the two partitions. The DP solution efficiently explores all possible subset sums and guarantees the optimal result.


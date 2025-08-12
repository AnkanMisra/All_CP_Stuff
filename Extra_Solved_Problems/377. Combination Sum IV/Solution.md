
# Solution Explanation

## Intuition
This problem is about counting the **number of ways** to form a target sum using elements from an array, where **order matters** (different sequences count as different combinations). This is a classic **dynamic programming** problem where we can build up solutions for smaller targets to solve larger ones.

## Approach
We use **bottom-up dynamic programming** where `dp[i]` represents the number of ways to form sum `i`.

1. **Initialize:** Create a `dp` array of size `target + 1` and set `dp[0] = 1` (one way to make sum 0: use no elements)
2. **Fill DP table:** For each target sum from `1` to `target`:
   - For each number in `nums`:
     - If the current number can be used (i.e., `current_sum - num >= 0`)
     - Add the number of ways to form `current_sum - num` to `dp[current_sum]`
3. **Return result:** `dp[target]` contains the total number of combinations

## Algorithm
1. Create `dp` array of size `target + 1`, initialize `dp[0] = 1`
2. For `i` from `1` to `target`:
   - For each `num` in `nums`:
     - If `i - num >= 0`: `dp[i] += dp[i - num]`
3. Return `dp[target]`

## Complexity
- **Time Complexity:** `O(target × nums.length)` - we iterate through all target values and for each, check all numbers
- **Space Complexity:** `O(target)` - for the DP array

## Summary
The **dynamic programming approach** works because we can express the number of ways to form any sum as the sum of ways to form smaller sums. The key insight is that `dp[i]` depends on `dp[i - num]` for all valid numbers, allowing us to build the solution incrementally. This handles the **order-sensitive** nature of combinations naturally since we consider all possible last elements.

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
         dp[0]=1;
        for (int i=1;i<=target;i++)
        {
            for(int n:nums)
            {
                if(i-n>=0)

                dp[i]+=dp[i-n];
            }
        }
        return dp[target];
    }
}
```

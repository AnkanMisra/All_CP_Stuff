
# Solution Explanation

## Intuition
This is a **dynamic programming problem** where we need to calculate the probability of Alice ending with `n` or fewer points. The key insight is that we can model this as a **Markov chain** where each state represents the current points Alice has, and we calculate the probability of reaching each state.

## Approach
We use **dynamic programming with sliding window optimization**. The main idea is:

1. **State Definition**: `dp[i]` represents the probability of Alice having exactly `i` points
2. **Base Case**: `dp[0] = 1.0` since Alice starts with 0 points
3. **Transition**: For each state `i`, the probability comes from all previous states `(i-maxPts)` to `(i-1)` that are still **active** (less than `k` points)
4. **Sliding Window**: We maintain a running sum of probabilities from active states to avoid recalculating the same values

## Algorithm
1. Handle **edge cases**: if `k = 0` or `n >= k + maxPts - 1`, return `1.0`
2. Initialize `dp` array and set `dp[0] = 1.0`
3. Maintain a `sum` variable representing the total probability of active states
4. For each point value `i` from `1` to `n`:
   - Calculate `dp[i] = sum / maxPts` (equal probability from each active state)
   - If `i < k`, add `dp[i]` to `sum` (this state can still draw)
   - If `i >= maxPts`, remove `dp[i - maxPts]` from `sum` (sliding window)
5. Sum all probabilities from `k` to `n` to get the final answer

## Complexity
- **Time Complexity**: `O(n)` - single pass through all states
- **Space Complexity**: `O(n)` - for the dp array

## Summary
The approach works by **efficiently calculating transition probabilities** using a sliding window technique. Key insights include recognizing that Alice stops drawing at `k` points, and that we need to track probabilities of reaching each exact point value. The sliding window optimization reduces time complexity from `O(n * maxPts)` to `O(n)` by maintaining a running sum of active states.
```java
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0){} return 1.0;
        if (n >= k + maxPts - 1) {
            return 1.0;
        }
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double sum = 1.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) {
                sum += dp[i];
            }
            if (i >= maxPts) {
                sum -= dp[i - maxPts];
            }
        }
        double result = 0.0;
        for (int i = k; i <= n; i++) {
            result += dp[i];
        }
        return result;
    }
}
```

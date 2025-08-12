
# Solution Explanation

## Intuition
This is a classic **dynamic programming problem** similar to the coin change problem. We need to find the number of ways to form a target sum `n` using unique positive integers raised to the power `x`. The key insight is that for each integer `i`, we can either **include `i^x` in our sum or exclude it**, and we need to count all valid combinations.

## Approach
We use **dynamic programming** where `dp[j]` represents the number of ways to form sum `j`. We iterate through each possible integer `i` starting from 1, and for each `i`, we calculate `val = i^x`. If `val > n`, we can break since larger values won't contribute to forming `n`.

For each valid `val`, we update our DP array by considering two choices:
1. **Don't include** `i^x`: keep `dp[j]` as is
2. **Include** `i^x`: add `dp[j - val]` to `dp[j]`

We use a **separate array** for each iteration to ensure we don't use the same integer multiple times (maintaining uniqueness).

## Algorithm
1. Initialize `dp[0] = 1` (one way to form sum 0: use no integers)
2. For each integer `i` from 1 to `n`:
   - Calculate `val = i^x`
   - If `val > n`, break the loop
   - Create a new DP array `next`
   - For each possible sum `j` from 0 to `n`:
     - `next[j] = dp[j]` (don't include `i^x`)
     - If `j >= val`, add `dp[j - val]` to `next[j]` (include `i^x`)
   - Update `dp = next`
3. Return `dp[n]`

## Complexity
- **Time Complexity:** `O(n^2)` - We iterate through at most `n` integers, and for each integer, we update the DP array of size `n+1`
- **Space Complexity:** `O(n)` - We use two arrays of size `n+1` for the DP computation

## Summary
This approach works because it systematically considers each possible integer and decides whether to include its `x`th power in the sum. The DP ensures we count all valid combinations while maintaining the **uniqueness constraint** by using a fresh array for each iteration. The modulo operation prevents integer overflow for large results.

```java
class Solution {
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = (int)1e9 + 7;
        for(int i = 1; i <= n; i++){
            int val = (int) Math.pow(i, x);
            if(val > n){
                break;
            }
            int[] next = new int[n + 1];
            for(int j = 0; j <= n; j++){
                next[j] = dp[j];
                if(j >= val){
                    next[j] += dp[j - val];
                    next[j] %= mod;
                }
            }
            dp = next;
        }
        return dp[n];
    }
}
```

# Solution Explanation

## Intuition
The key insight is that this is a **dynamic programming problem** where we need to track the minimum rest days while respecting the constraint that **no same activity can be done on consecutive days**. For each day, we have up to 3 choices (rest, contest, gym), and our decision depends on what we did the previous day.

## Approach
We use **dynamic programming** with states representing the last activity performed. For each day `i` and each possible last activity `state`, we track the minimum number of rest days needed.

**State definition:** `dp[i][state]` = minimum rest days after `i` days with last activity being `state`
- `state = 0`: last activity was **rest**
- `state = 1`: last activity was **contest** 
- `state = 2`: last activity was **gym**

**Transitions:**
- **Rest on day i:** Always possible, increment rest count by 1 from best previous state
- **Contest on day i:** Only if `a[i] = 1` or `a[i] = 3`, and previous day wasn't contest
- **Gym on day i:** Only if `a[i] = 2` or `a[i] = 3`, and previous day wasn't gym

**Base case:** `dp[0][0] = 0` (before starting, considered as rested with 0 rest days)

## Algorithm
1. Initialize DP table `dp[n+1][3]` with infinity values
2. Set base case: `dp[0][0] = 0`
3. For each day `i` from 1 to `n`:
   - **Rest option:** `dp[i][0] = min(dp[i-1][0], dp[i-1][1], dp[i-1][2]) + 1`
   - **Contest option:** If `a[i] = 1` or `a[i] = 3`, then `dp[i][1] = min(dp[i-1][0], dp[i-1][2])`
   - **Gym option:** If `a[i] = 2` or `a[i] = 3`, then `dp[i][2] = min(dp[i-1][0], dp[i-1][1])`
4. Return `min(dp[n][0], dp[n][1], dp[n][2])`

## Complexity
- **Time Complexity:** `O(n)` - we iterate through `n` days and perform constant work for each day
- **Space Complexity:** `O(n)` - we use a 2D DP table of size `(n+1) × 3`

## Summary
This **dynamic programming solution** works by considering all possible valid transitions while respecting the consecutive activity constraint. The approach ensures we find the **optimal schedule** that minimizes rest days. Key insights include recognizing that the problem has **optimal substructure** (optimal solution depends on optimal solutions to subproblems) and **overlapping subproblems** (same states are revisited). Corner cases are handled naturally - when activities aren't available, those transitions simply don't occur, and resting is always a valid fallback option.


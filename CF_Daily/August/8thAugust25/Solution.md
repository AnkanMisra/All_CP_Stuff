
# Solution Explanation

## Intuition
The alternating sessions create two distinct **turns**: your friend's turn (needs skip points for hard bosses) and your turn (no cost). Because each turn can take **one or two consecutive bosses**, the decision at position `i` depends only on:
- **Who is playing now**
- **How many bosses (1 or 2) we choose to kill this turn**

This local, sequential nature suggests a small-state **dynamic programming** solution from right to left.

## Approach
1. **State Definition**
   `dp[i][t]` = minimum skip points required to finish all bosses from index `i` to `n - 1` **when it is turn `t`** (`t = 0` for friend, `t = 1` for you).

2. **Transition**
   From position `i` and turn `t`, choose to kill `take = 1` or `2` bosses (if available):

   **Cost this turn:**
   - If `t = 0` (friend), add `a[i] + a[i+1]` for the bosses taken (only those positions that exist)
   - If `t = 1` (you), cost is `0`

   **Next state** is `dp[i + take][t ^ 1]` (switch turn). Take the **minimum** over both `take` options.

3. **Initialization**
   All `dp[n][t]`, `dp[n+1][t] = 0` (beyond last boss no cost).

4. **Answer**
   Required value is `dp[0][0]` because the **friend starts**.

## Complexity
- **Time Complexity:** `O(n)` - two turns × two choices per index is constant work
- **Space Complexity:** `O(n)` for the DP table (can be optimized to `O(1)` with rolling array)

## Summary
We process bosses backwards, keeping track of the current player. At each index we test killing one or two bosses, add skip points only when it is the friend's turn, and switch turns for the remaining suffix. This yields a **linear-time DP** that guarantees the minimum total skip points because every subproblem (suffix starting at `i`, given the current player) is solved optimally before it is needed.


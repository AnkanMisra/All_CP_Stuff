# Solution Explanation

## Intuition
The key insight is that the answer depends on whether we need **exactly one winner** (`k = 1`) or **multiple survivors** (`k > 1`). When `k > 1`, player j has a chance to survive since there are strategic ways to keep them alive. When `k = 1`, only the **strongest player(s)** can potentially win.

## Approach
The solution uses a **simple greedy observation**:

1. **Find the maximum strength** among all players in the tournament
2. **Case 1: k > 1** (Multiple survivors needed)
   - Player j can **always be one of the survivors**
   - Even if player j is weak, other players can eliminate each other strategically
   - Answer: **"YES"**
3. **Case 2: k = 1** (Single winner needed)
   - Only players with **maximum strength** can potentially win
   - If player j has maximum strength, they can win
   - If player j has less than maximum strength, they will eventually be eliminated
   - Answer: **"YES"** if `arr[j-1] == max`, otherwise **"NO"**

## Algorithm
1. Read the input values `n`, `j`, `k` and the array of player strengths
2. **Find the maximum strength** by iterating through the array
3. **Check the condition**:
   - If `k > 1`: Output **"YES"**
   - If `k = 1`: Check if `arr[j-1] == max`
     - If true: Output **"YES"**
     - If false: Output **"NO"**

## Complexity
- **Time Complexity:** `O(n)` - Single pass through the array to find maximum strength
- **Space Complexity:** `O(n)` - For storing the input array

## Summary
The solution works because of a **key observation**: when `k > 1`, there are always strategies to keep any player alive among the survivors, but when `k = 1`, only the strongest player(s) can win. The algorithm efficiently determines this by finding the maximum strength and checking the two cases. **Corner case handled**: Multiple players can have the same maximum strength, and any of them can potentially win when `k = 1`.


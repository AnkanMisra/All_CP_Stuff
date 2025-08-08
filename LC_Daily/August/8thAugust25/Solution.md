
# Solution Explanation

## Intuition
This problem is a **probability calculation** that can be solved using **dynamic programming with memoization**. The key insight is that we need to calculate the probability that soup A runs out before soup B, plus half the probability that both run out simultaneously. Since each operation has equal probability (`0.25`), we can recursively calculate probabilities for all possible states.

## Approach
We use **recursive dynamic programming** where `f(a, b)` represents the probability that soup A runs out before soup B (plus half the probability of simultaneous depletion) when we have `a` mL of soup A and `b` mL of soup B remaining.

**Base cases:**
- If `a <= 0` and `b > 0`: soup A is depleted first, return `1.0`
- If `a > 0` and `b <= 0`: soup B is depleted first, return `0.0`
- If both `a <= 0` and `b <= 0`: both depleted simultaneously, return `0.5`

**Recursive case:**
For each state `(a, b)`, we calculate the probability as the **weighted average** of all four possible operations:
- Operation 1: Pour `100` mL from A, `0` mL from B → `f(a-100, b)`
- Operation 2: Pour `75` mL from A, `25` mL from B → `f(a-75, b-25)`
- Operation 3: Pour `50` mL from A, `50` mL from B → `f(a-50, b-50)`
- Operation 4: Pour `25` mL from A, `75` mL from B → `f(a-25, b-75)`

Each operation has probability `0.25`, so: `f(a,b) = 0.25 * (f(a-100,b) + f(a-75,b-25) + f(a-50,b-50) + f(a-25,b-75))`

**Optimization:** For large values of `n` (greater than `4800`), the probability approaches `1.0` due to the **asymmetric nature** of the operations (more soup A is consumed on average), so we can return `1.0` directly.

## Algorithm
1. **Check optimization condition**: If `n > 4800`, return `1.0`
2. **Initialize memoization table**: Create a 2D array `dp[n+1][n+1]` filled with `-1`
3. **Call recursive function**: Start with `f(n, n, dp)`
4. **In recursive function**:
   - Check base cases and return appropriate probability
   - If already computed (`dp[a][b] != -1`), return cached result
   - Calculate probability using weighted average of four operations
   - Store result in `dp[a][b]` and return

## Complexity
- **Time Complexity:** `O(n^2)` - We compute each state `(a, b)` at most once due to memoization
- **Space Complexity:** `O(n^2)` - For the memoization table and recursion stack

## Summary
This solution efficiently handles the **probability calculation** using **dynamic programming with memoization**. The key insight is recognizing that this is a **Markov process** where future states depend only on the current state. The **optimization for large n** is crucial because the asymmetric operations make soup A much more likely to be depleted first when n is large, causing the probability to converge to `1.0`. The memoization ensures we don't recalculate the same subproblems, making the solution efficient for the given constraints.



# Solution Explanation

## Intuition
This is a **dynamic programming problem** where we need to track the number of ways to reach vertex D after exactly `n` steps. The key insight is that in a tetrahedron, **every vertex is connected to all other three vertices**, creating a symmetric structure. We can model this as a **state transition problem** where we track two states: being at vertex D vs being at any non-D vertex (A, B, or C).

## Approach
We use **two variables** to represent the states:
- `f(i)` = number of ways to be at vertex **D** after exactly `i` steps
- `g(i)` = number of ways to be at any **non-D vertex** (A, B, or C) after exactly `i` steps

The **recurrence relations** are:
- `f(i) = 3 * g(i-1)` - from any of the 3 non-D vertices, we can reach D in one step
- `g(i) = f(i-1) + 2 * g(i-1)` - from D we can reach any of the 3 non-D vertices, and from any non-D vertex we can reach 2 other non-D vertices

**Base cases**: `f(0) = 1` (initially at D), `g(0) = 0` (initially not at non-D vertices)

## Algorithm
1. Initialize `f = 1` and `g = 0` representing the initial state
2. For each step from `1` to `n`:
   - Calculate new `f` as `3 * g` (ways to reach D from non-D vertices)
   - Calculate new `g` as `f + 2 * g` (ways to reach non-D vertices)
   - Update `f` and `g` with the new values
   - Apply **modulo operation** to prevent overflow
3. Return `f` as the final answer

## Complexity
- **Time Complexity**: `O(n)` - single loop iterating `n` times
- **Space Complexity**: `O(1)` - only using constant extra space for variables

## Summary
This approach works because it **exploits the symmetry** of the tetrahedron where all non-D vertices are equivalent. By tracking only two states instead of four individual vertices, we reduce the problem complexity significantly. The **iterative DP approach** ensures we handle large values of `n` (up to `10^7`) efficiently while using modular arithmetic to prevent integer overflow. The key insight is recognizing that we don't need to track individual non-D vertices since they're all equivalent in terms of reachability.


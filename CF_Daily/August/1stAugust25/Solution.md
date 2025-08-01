
# Solution Explanation

## Intuition
The key insight is to **work backwards** from `n` toward `1`. Instead of generating numbers forward from `1`, consider reversing the operations: a number `x` could originate from `x / a` (if divisible by `a`) or `x - b`. If we can eventually reach `1` through these reverse steps, then `n` belongs to the set.

## Approach
We apply a **greedy backward traversal**:
- While `n > 1`:
  - If `n` is divisible by `a`, divide: `n = n / a`.
  - Otherwise, subtract `b` (only if `n > b`): `n = n - b`.
  - If neither move is possible, `n` cannot reach `1`.
- Special-case `a = 1`: multiplying never changes the value, so we only need to check if `(n - 1)` is divisible by `b`.

The strategy prefers division because it shrinks the value faster than subtraction, reducing iterations and ensuring we explore the most promising path first.

## Algorithm
1. Read `n`, `a`, `b`.
2. If `a = 1`, return **Yes** if `(n - 1) % b = 0`, else **No**.
3. Set `val = 1`.
4. While `val ≤ n`:
   1. If `(n - val) % b = 0`, output **Yes** and stop.
   2. If `val > n / a`, break (to avoid overflow in `val * a`).
   3. Update `val = val * a`.
5. If loop completes without success, output **No**.

## Complexity
- **Time complexity:** `O(log_a n)` divisions plus a constant check each loop — efficient even for the upper limits.
- **Space complexity:** `O(1)`; only a few scalar variables are used.

## Summary
By iteratively testing powers of `a` (`1, a, a², ...`) and checking if the residual to `n` is divisible by `b`, we efficiently decide membership in the generated set. This **greedy backward method** ensures we either find a valid decomposition or conclusively prove none exists, all within logarithmic time and constant space.


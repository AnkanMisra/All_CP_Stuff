
# Solution Explanation

## Intuition
The goal is to find two positive integers `a` and `b` such that **LCM(a, b) = X** and **max(a, b)** is minimized.
The key relationship is `a * b = LCM(a, b) * GCD(a, b)`. Substituting `LCM(a, b) = X`, we get `a * b = X * GCD(a, b)`.

To minimize `max(a, b)`, the values of `a` and `b` should be as close as possible to each other, which means they should be close to `sqrt(X)`.

A crucial simplification arises when `a` and `b` are **coprime** (i.e., `GCD(a, b) = 1`). In this case, `LCM(a, b) = a * b`. So, if we can find two coprime factors `a` and `b` such that `a * b = X`, they automatically satisfy `LCM(a, b) = X`. This becomes our primary search criterion.

## Approach
The approach is to find all pairs of factors `(a, b)` such that `a * b = X`. Among these pairs, we filter for those that are **coprime** (`GCD(a, b) = 1`). From this filtered set, we select the pair that minimizes `max(a, b)`.

To find these pairs efficiently, we can iterate from `i = 1` up to `sqrt(X)`.
- If `i` is a divisor of `X`, then `j = X / i` is also a divisor, and `(i, j)` is a factor pair.
- We then check if `GCD(i, j) == 1`.
- If they are coprime, this is a valid candidate pair for `(a, b)`.
- To minimize `max(a, b)`, we want `a` and `b` to be as close as possible. As our loop variable `i` increases, `j` decreases, so the pair `(i, j)` gets closer. The last coprime pair found during this iteration will have the largest `i` (and smallest `j`), thus minimizing `max(i, j)`.

## Complexity
- **Time Complexity:** `O(sqrt(X) * log(X))`
  - The loop runs up to `sqrt(X)` times.
  - Inside the loop, calculating `GCD(a, b)` takes `O(log(min(a, b)))` time.
- **Space Complexity:** `O(1)`
  - We only use a constant amount of extra space for variables.

## Summary
The solution efficiently finds the optimal pair `(a, b)` by focusing on **coprime factors** of `X`. By iterating through divisors up to `sqrt(X)`, we can check all relevant factor pairs. The condition `GCD(a, b) = 1` simplifies `LCM(a, b) = a * b = X`. The search strategy ensures we find the pair `(a, b)` that are closest to each other, which in turn minimizes `max(a, b)`.


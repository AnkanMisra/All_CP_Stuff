# Solution Explanation

## Intuition
The sum `min(a_1) + min(a_1, a_2) + ... + min(a_1, ..., a_n)` is minimized when the prefix minimums are as small as possible. Since we can perform at most one operation (add `a_j` to `a_i` for `i < j` and set `a_j = 0`), we need to determine if such an operation can reduce the sum of prefix minimums compared to doing nothing.

## Approach
- **Without any operation:**
  - Compute the prefix minimums for the array as is, and sum them up. This is the baseline answer.
- **With one operation:**
  - For every possible pair `(i, j)` with `i < j`, consider setting `a_i := a_i + a_j` and `a_j = 0`.
  - The operation can only decrease the prefix minimums if it causes an earlier prefix to become smaller, or if setting `a_j = 0` makes a later prefix minimum drop to zero.
  - The optimal operation is usually to set some `a_j` (where `a_j` is not already zero) to zero as early as possible, or to increase an earlier `a_i` to avoid a larger minimum in later prefixes.
  - Efficiently, we can check the effect of setting each `a_j` to zero (for `j > 1`), and also consider the effect of combining two elements early in the array.
- For each test case, output the minimum sum found (either with or without the operation).

## Complexity
- **Time Complexity:** `O(n)` per test case (since we only need to compute prefix minimums and can check the effect of the operation in a single pass)
- **Space Complexity:** `O(n)` for storing prefix minimums and auxiliary arrays

## Summary
- The problem is solved by comparing the sum of prefix minimums with and without the allowed operation.
- The key insight is that the operation can only help if it reduces a prefix minimum, especially by introducing a zero or combining values to lower the minimum in early prefixes.
- The approach efficiently checks all possibilities in linear time per test case, ensuring the solution meets the constraints.


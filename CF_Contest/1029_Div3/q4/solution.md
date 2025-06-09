# Solution Explanation

## Intuition
The problem allows two types of operations that decrease each element of the array by either its index or by `n - i + 1`. The goal is to determine if, after any sequence of these operations, all elements can be made zero. The key insight is that the effect of these operations can be represented as a system of linear equations, and the only way to reach all zeros is if the array matches a specific pattern.

## Approach
- Let `x` be the number of times the first operation is applied, and `y` be the number of times the second operation is applied.
- After applying these operations, the value at position `i` becomes:  
  `a[i] - x * (i + 1) - y * (n - i)`
- To reach all zeros, we need:  
  `a[i] = x * (i + 1) + y * (n - i)` for all `i`
- This is a system of equations. By using the first and last elements, we can solve for `x` and `y`:
  - From `a[0] = x * 1 + y * n`
  - From `a[n-1] = x * n + y * 1`
- Solve these two equations for `x` and `y`:
  - `num = a[0] * n - a[n-1]`
  - `den = n^2 - 1`
  - `y = num / den`
  - `x = a[0] - y * n`
- Check if `num` is non-negative and divisible by `den`, and if `x` is non-negative.
- Finally, verify that all elements of the array match the pattern for these `x` and `y`.

## Complexity
- Time Complexity: O(n) per test case, as we check each element once.
- Space Complexity: O(n) per test case for storing the array.

## Summary
By reducing the problem to a system of equations and checking if

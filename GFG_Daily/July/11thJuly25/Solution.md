
# Solution Explanation

## Intuition
The problem asks for the number of binary strings of length `n` that contain **at least one pair of consecutive 1's**. Instead of directly counting such strings, it's easier to count the total number of binary strings of length `n` and subtract the number of strings that have **no consecutive 1's**.

## Approach
- **Total binary strings:** There are `2^n` binary strings of length `n`.
- **Count strings with no consecutive 1's:**
  - Let `f(n)` be the number of binary strings of length `n` with no consecutive 1's.
  - Such strings can be built by:
    - Adding `0` to any string of length `n-1` with no consecutive 1's.
    - Adding `1` to any string of length `n-1` that ends with `0` (to avoid consecutive 1's).
  - This leads to a recurrence similar to the Fibonacci sequence.
  - The count of such strings is the `(n+2)`th Fibonacci number.
- **Final answer:** Subtract the count of strings with no consecutive 1's from the total: `2^n - Fib(n+2)`.

## Complexity
- **Time Complexity:** `O(n)` (for computing the Fibonacci number up to `n+2`)
- **Space Complexity:** `O(1)` (if using iterative Fibonacci calculation)

## Summary
- The key insight is to use **complement counting**: count all possible strings and subtract those without consecutive 1's.
- The number of binary strings of length `n` with no consecutive 1's follows the **Fibonacci sequence**.
- The answer is `2^n - Fib(n+2)`, which is efficient to compute for the given constraints.


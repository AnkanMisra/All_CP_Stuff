
# Solution Explanation

## Intuition
To find the highest power `x` such that `k^x` divides `n!`, we need to analyze how many times the prime factors of `k` appear in the factorization of `n!`. The limiting factor will be the prime in `k` that appears the fewest number of times (relative to its exponent in `k`).

## Approach
- **Prime Factorization of k:**
  - First, factorize `k` into its prime factors and record the exponent for each prime.
- **Count Prime Exponents in n!:**
  - For each prime factor `p` of `k`, count how many times `p` appears in the factorization of `n!`. This is done by summing `n / p`, `n / p^2`, `n / p^3`, etc., until `p^j > n`.
- **Determine Maximum x:**
  - For each prime `p`, the maximum possible `x` is the number of times `p` appears in `n!` divided by its exponent in `k` (using integer division).
  - The answer is the minimum value of `x` across all prime factors of `k`.
- **Edge Case:**
  - If any prime factor of `k` does not appear in `n!`, then `k^x` cannot divide `n!` for any `x > 0`, so the answer is `0`.

## Complexity
- **Time Complexity:** `O(√k + log_p n)` for each prime factor `p` of `k`, where `√k` is for factorization and `log_p n` is for counting exponents in `n!`.
- **Space Complexity:** `O(log k)` for storing the prime factors of `k`.

## Summary
- The solution works by breaking down `k` into its prime factors and checking how many times each appears in `n!`.
- The smallest such count (after dividing by the exponent in `k`) determines the highest power `x` such that `k^x` divides `n!`.
- This approach efficiently handles large values of `n` and `k` by leveraging properties of factorials and prime factorization.


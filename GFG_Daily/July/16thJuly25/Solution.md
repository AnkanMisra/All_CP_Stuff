
# Solution Explanation

## Intuition
To have **exactly 9 divisors**, a number must have a very specific prime factorization. The only possibilities are:
- A number of the form `p^8` (where `p` is a prime), since it has `8+1=9` divisors.
- A number of the form `p^2 * q^2` (where `p` and `q` are distinct primes), since it has `(2+1)*(2+1)=9` divisors.

## Approach
- **Generate all primes** up to `sqrt(n)` using the Sieve of Eratosthenes.
- For each prime `p`, check if `p^8` is less than or equal to `n` and count it.
- For all pairs of distinct primes `(p, q)` with `p < q`, check if `p^2 * q^2` is less than or equal to `n` and count it.
- Sum both counts to get the answer.

## Complexity
- **Time Complexity:** `O(sqrt(n) log log sqrt(n))` for prime generation, plus `O(k^2)` for checking pairs, where `k` is the number of primes up to `sqrt(n)`
- **Space Complexity:** `O(sqrt(n))` for storing primes

## Summary
- The solution leverages the **unique divisor structure** of numbers with exactly 9 divisors.
- By efficiently generating primes and checking the two possible forms, we ensure all such numbers up to `n` are counted.
- This approach is efficient and works within the given constraints (`n` up to `10^9`).



# Solution Explanation

## Intuition
The key insight is to recognize that the problem requires splitting the array based on whether the index is a **prime number**. All elements at prime indices go into one array, and the rest go into the other. The challenge is efficiently identifying prime indices up to `n - 1`.

## Approach
- Use the **Sieve of Eratosthenes** to efficiently determine which indices (from `0` to `n - 1`) are prime.
  - Initialize a boolean array `p` of size `n` to track prime indices.
  - Mark all indices from `2` to `n - 1` as potentially prime.
  - For each index `i` from `2` up to `sqrt(n)`, if `p[i]` is true, mark all multiples of `i` as not prime.
- Iterate through the array `nums`:
  - If the index `i` is a **prime index** (`p[i]` is true and `i >= 2`), add `nums[i]` to the sum for array `A`.
  - Otherwise, add `nums[i]` to the sum for array `B`.
- Return the **absolute difference** between the sums of `A` and `B`.

## Complexity
- **Time Complexity:** `O(n log log n)` for the sieve, plus `O(n)` for the final pass through the array, so overall **O(n log log n)**.
- **Space Complexity:** `O(n)` for the boolean array to track primes.

## Summary
- The approach works efficiently for large arrays by using the **Sieve of Eratosthenes** to find all prime indices up to `n - 1`.
- All elements at prime indices are summed into one group, and the rest into another.
- The final answer is the **absolute difference** between these two sums.
- **Corner cases:** For arrays of length less than 2, there are no prime indices, so all elements go into array `B`.


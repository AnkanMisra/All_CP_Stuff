
# Solution Explanation

## Intuition
The key insight is to **group indices by their smallest prime factor**. For any index `i` with smallest prime factor `p`, we can place any multiple of `p` at position `i` to satisfy `gcd(p_i, i) > 1`. By **rotating elements within each prime group**, we can avoid fixed points whenever the group has more than one element.

## Approach
1. **Precompute smallest prime factors** using a sieve for all numbers up to `100,000`.
2. **Fix position 1** to value `1` (this is allowed since the constraint only applies to indices `≥ 2`).
3. **Iterate through primes in descending order** to minimize the number of singleton groups.
4. For each prime `p`, **collect all unvisited multiples** of `p` within the range `[1, n]`.
5. If the group has **only one element**, assign it to itself (unavoidable fixed point).
6. If the group has **multiple elements**, perform a **cyclic rotation** to ensure no element maps to itself.
7. **Output the resulting permutation**.

## Algorithm
1. Initialize arrays `p[]` for the permutation and `vis[]` to track visited indices.
2. Set `p[1] = 1` and mark index `1` as visited.
3. For each prime `prime` from `n` down to `2`:
   - Skip if `prime` is not actually prime (check using `spf[prime] != prime`).
   - Collect all unvisited multiples of `prime` into a list.
   - If list size is `1`, assign the element to itself.
   - If list size is `> 1`, rotate: `p[list[(i+1) % size]] = list[i]` for all `i`.
4. Output the permutation.

## Complexity
- **Time Complexity:** `O(n log log n)` for sieve preprocessing + `O(n log n)` for the main algorithm = `O(n log n)`
- **Space Complexity:** `O(n)` for arrays and temporary lists

## Summary
This approach **minimizes fixed points** by grouping indices that share common factors and rotating within groups. The **descending prime iteration** ensures larger primes are processed first, reducing singleton groups. The algorithm guarantees that `gcd(p_i, i) > 1` for all `i ≥ 2` while achieving the **minimum possible number of fixed points** for any valid permutation.


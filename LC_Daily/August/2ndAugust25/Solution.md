

# Solution Explanation

## Intuition
To make both baskets identical, each fruit cost must appear the **same number of times** in the two baskets. If any cost appears an odd number of times overall, the task is **impossible**.

After balancing counts, we still need to move the *surplus* copies of some values from one basket to the other. Swapping two items with values `a` and `b` costs `min(a, b)`. When both `a` and `b` are large, we can perform the swap *indirectly* using the **globally smallest fruit** `m`:

1. Swap `a` with `m` (cost `m`).
2. Swap `b` with `m` (cost `m`).

Total indirect cost is `2 · m`, so the cheapest way to swap two surplus values `x` and `y` costs `min(x, 2 · m)` where `x` is the *smaller* of the two.

## Approach
1. **Frequency Check**
   - Build a map of total occurrences for every cost value.
   - If any frequency is odd, return **-1**.

2. **Find Surpluses**
   - For each value, the desired count in each basket is `total / 2`.
   - Extra copies in `basket1` (above the target) go into `extra1`.
   - Extra copies in `basket2` go into `extra2`.

3. **Prepare for Minimal Swaps**
   - Sort `extra1` in **ascending** order.
   - Sort `extra2` in **descending** order (to pair biggest with smallest).
   - Let `m` be the **minimum value** across both baskets.

4. **Compute Cost**
   - For every index `i`, pair `extra1[i]` (smaller) with `extra2[i]` (larger).
   - Add `min(extra1[i], 2 · m)` to the running cost.

## Algorithm (Pseudo-steps)
1. Count frequencies of all values in both baskets.
2. If any frequency is odd → return `-1`.
3. Build `extra1`, `extra2` lists of surplus values.
4. Sort `extra1` ascending; sort `extra2` descending.
5. `m ← global minimum value`.
6. `cost ← 0`.
7. For `i` from `0` to `extra1.size() - 1`:
   - `cost += min(extra1[i], 2 · m)`.
8. Return `cost`.

## Complexity
- **Time Complexity:** `O(n log n)`
  Sorting the surplus lists dominates.
- **Space Complexity:** `O(n)` for frequency maps and surplus lists.

## Summary
The algorithm first checks feasibility via parity of frequencies. It then pairs surplus elements so that each swap involves the **cheapest possible fruit**, either directly or through the globally minimal fruit, guaranteeing the **minimum total cost** to equalize the baskets.



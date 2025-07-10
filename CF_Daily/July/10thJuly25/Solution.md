
# Solution Explanation

## Intuition
To obtain a particular MEX `m` after deleting exactly `k` elements we must:
1. Keep **at least one** occurrence of every number `0 … m-1`.
2. Keep **zero** occurrences of the number `m`.

The first rule fails if any number below `m` is missing from the original array.  
The second rule forces us to delete **all** occurrences of `m`.  
After these two constraints, every other element may be either deleted or kept arbitrarily.

Therefore, if every number `< m` is present, the range of feasible deletions is
- **Minimum deletions:** `L = freq[m]` (remove the mandatory copies of `m`).
- **Maximum deletions:** `R = n - m` (remove every element except one copy of `0 … m-1`).

`m` is achievable for **all** `k` in the inclusive interval `[L, R]`.

## Approach
1. **Frequency Counting** — store `freq[x]` for every `x ≤ n`.
2. **Prefix availability** — while scanning `m = 0 … n` keep a boolean `prefixGood` that is `true` iff all numbers `< m` exist in the array.
3. **Range contribution** — for each valid `m` add `+1` to every `k` in `[L, R]`.  
   This is performed in `O(1)` with a *difference array*: `diff[L]++`, `diff[R+1]--`.
4. **Prefix sum** over `diff` gives the required answers for all `k`.

## Algorithm
1. Read `n` and the array, build `freq[0 … n]`.
2. Initialise `diff[0 … n+1]` with zeros and `prefixGood = true`.
3. For `m = 0 … n`:
   - If `prefixGood` is `true`:
     - `L = freq[m]`, `R = n - m`.
     - If `L ≤ R` add the interval to `diff`.
   - Update `prefixGood &= (freq[m] > 0)`.
4. Compute prefix sums of `diff` to obtain the answer for every `k`.
5. Output the answers.

## Complexity
- **Time:** `O(n)` per test case (single linear scans).
- **Space:** `O(n)` for the frequency and difference arrays.

## Summary
Each potential MEX contributes to a continuous range of deletions.  
By marking these ranges with a difference array we aggregate their effects in linear time, producing the count of distinct MEX values for every `k`.


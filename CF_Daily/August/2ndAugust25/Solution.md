
# Solution Explanation

## Intuition
A subarray is **good** if its sum equals its length. We can transform this condition: for a subarray from index `l` to `r`, we need `sum(l to r) = r - l + 1`. Rearranging this gives us `sum(l to r) - (r - l + 1) = 0`, which means `prefixSum[r] - prefixSum[l-1] - (r - (l-1)) = 0`. This simplifies to `(prefixSum[r] - r) = (prefixSum[l-1] - (l-1))`.

## Approach
We use a **prefix sum with frequency counting** approach. For each position `i`, we calculate `prefixSum[i] - i` and count how many times this value has appeared before. Each previous occurrence represents a valid starting position for a good subarray ending at the current position.

## Algorithm
1. Initialize a frequency map with `freq[0] = 1` to handle subarrays starting from index 1
2. For each position `i` from 1 to `n`:
   - Add the current digit to the running prefix sum
   - Calculate the key as `prefixSum - i`
   - Add the frequency of this key to the answer (number of good subarrays ending at position `i`)
   - Increment the frequency of this key in the map
3. Return the total count

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string
- **Space Complexity:** `O(n)` for the frequency map in worst case

## Summary
This approach works because we transform the **good subarray condition** into finding pairs of positions with the same `prefixSum - index` value. The frequency map efficiently counts these occurrences, allowing us to find all good subarrays in a single pass. The key insight is recognizing that the condition `sum = length` can be rewritten using prefix sums to identify matching patterns.


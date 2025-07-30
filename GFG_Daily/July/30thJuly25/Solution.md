
# Solution Explanation

## Intuition
The key insight is to use **prefix sums** and a `HashMap` to efficiently count subarrays with sum `k`. If we know the prefix sum up to index `i` and we've seen a prefix sum of `(current_prefix_sum - k)` before, then there exists a subarray ending at index `i` with sum exactly `k`.

## Approach
We use the **prefix sum technique** combined with a `HashMap` to store the frequency of each prefix sum encountered:

1. **Initialize** a `HashMap` to store prefix sum frequencies and set `prefixSumMap[0] = 1` to handle subarrays starting from index 0
2. **Iterate** through the array, maintaining a running prefix sum
3. **Check** if `(prefixSum - k)` exists in the map - if yes, add its frequency to our count
4. **Update** the frequency of current prefix sum in the map
5. **Return** the total count of valid subarrays

## Algorithm
1. Create a `HashMap` to store prefix sum frequencies
2. Initialize `count = 0`, `prefixSum = 0`, and `prefixSumMap[0] = 1`
3. For each element in the array:
   - Add current element to `prefixSum`
   - If `(prefixSum - k)` exists in map, add its frequency to `count`
   - Update frequency of current `prefixSum` in the map
4. Return `count`

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the array. We traverse the array once and HashMap operations are `O(1)` on average.
- **Space Complexity:** `O(n)` in the worst case when all prefix sums are unique, requiring storage for each in the HashMap.

## Summary
This approach works because it leverages the mathematical property that if `prefixSum[j] - prefixSum[i-1] = k`, then the subarray from index `i` to `j` has sum `k`. By storing prefix sum frequencies, we can efficiently count all such valid subarrays. The algorithm handles **negative numbers** correctly and works for all edge cases including when `k = 0`.


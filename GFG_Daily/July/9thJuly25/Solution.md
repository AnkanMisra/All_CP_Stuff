
# Solution Explanation

## Intuition
The brute-force approach checks every subarray, but this is too slow for large arrays. The key insight is to count, for each element, how many subarrays it is the minimum of, and sum its contribution efficiently. This can be done using **monotonic stacks** to find the range where each element is the minimum.

## Approach
- For each element in the array, determine:
  - How many subarrays end at or after it where it is the minimum (using the next less element to the right)
  - How many subarrays start at or before it where it is the minimum (using the previous less element to the left)
- Use two passes with stacks:
  - **Left pass:** For each index, find the distance to the previous less element (PLE)
  - **Right pass:** For each index, find the distance to the next less element (NLE)
- The total number of subarrays where `arr[i]` is the minimum is `left[i] * right[i]`
- The answer is the sum over all `i` of `arr[i] * left[i] * right[i]`

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## Summary
This approach works because it efficiently counts the contribution of each element as the minimum in all subarrays where it is the smallest, using **monotonic stacks** to find boundaries in linear time. This avoids redundant work and handles large arrays within the constraints.


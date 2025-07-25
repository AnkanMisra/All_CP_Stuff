
# Solution Explanation

## Intuition
To find the **maximum subarray sum in a circular array**, we need to consider both non-wrapping and wrapping subarrays. The key insight is that the maximum circular sum is either the standard maximum subarray sum or the total array sum minus the minimum subarray sum.

## Approach
- Use **Kadane's algorithm** to find the maximum subarray sum (non-wrapping case).
- For the wrapping case, compute the **total sum** of the array and subtract the minimum subarray sum (using a variant of Kadane's algorithm).
- The answer is the **maximum** of these two values, unless all elements are negative (in which case, the maximum subarray sum is the answer).

## Algorithm
1. Initialize `max_kadane` as the result of Kadane's algorithm for maximum subarray sum.
2. Initialize `min_kadane` as the result of Kadane's algorithm for minimum subarray sum.
3. Compute the **total sum** of the array.
4. If all elements are negative, return `max_kadane`.
5. Otherwise, return the **maximum** of `max_kadane` and `total_sum - min_kadane`.

## Complexity
- **Time complexity:** `O(n)`
- **Space complexity:** `O(1)`

## Summary
This approach efficiently finds the **maximum circular subarray sum** by considering both non-wrapping and wrapping cases using Kadane's algorithm. The critical insight is to use the total sum minus the minimum subarray sum for the wrapping case, ensuring all scenarios are covered, including when all elements are negative.


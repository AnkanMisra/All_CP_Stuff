# Solution Explanation

## Intuition
To find the maximum difference `nums[j] - nums[i]` for `i < j` and `nums[i] < nums[j]`, we want to keep track of the smallest value seen so far as we iterate through the array. For each element, we check if it is greater than the minimum so far and update the maximum difference accordingly.

## Approach
- Initialize `minVal` as the first element of the array.
- Initialize `maxDiff` as -1 (the default if no valid pair is found).
- Iterate through the array starting from the second element:
  - If the current element is greater than `minVal`, compute the difference and update `maxDiff` if this difference is larger.
  - Otherwise, update `minVal` to the current element.
- Return `maxDiff` at the end.

## Complexity
- Time Complexity: O(n), where n is the length of the array, since we scan the array once.
- Space Complexity: O(1), as only a few variables are used.

## Summary
By maintaining the minimum value seen so far and updating the maximum difference when a larger value is found, we efficiently solve the problem in a single pass.

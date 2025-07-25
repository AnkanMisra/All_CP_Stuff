
# Solution Explanation

## Intuition
To maximize the sum of a subarray with all unique elements, we need to find the **largest possible sum of a contiguous segment** where no element repeats. This is a classic case for the **sliding window** technique with a set to track uniqueness.

## Approach
- Use two pointers (`left` and `right`) to represent the current window.
- Maintain a set to keep track of unique elements in the window and a variable for the current sum.
- Move the `right` pointer forward, adding elements to the set and sum if they are not already present.
- If a duplicate is found, move the `left` pointer forward, removing elements from the set and subtracting from the sum, until the duplicate is removed.
- At each step, update the maximum sum found.
- If all numbers are negative or zero, the answer is the maximum single element (since we must not leave the array empty).

## Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## Summary
This approach efficiently finds the **maximum sum of a subarray with all unique elements** by using a sliding window and a set for uniqueness. It works for arrays with negative numbers, zeros, and positives, and always ensures the array is not empty. The key insight is to dynamically adjust the window to maintain uniqueness and maximize the sum.



# Solution Explanation

## Intuition
The core idea is to find the **maximum sum** of a **contiguous subarray** where all elements are **unique**. This can be efficiently achieved using a **sliding window** technique to maintain a window of unique elements while tracking their sum.

## Approach
We use **two pointers** (`left` and `right`) to represent the current window and a `HashSet` to ensure uniqueness. As we expand the window by moving the `right` pointer, if a duplicate is found, we shrink the window from the `left` until there are no duplicates, updating the current sum accordingly. We keep track of the **maximum sum** encountered.

## Complexity
- **Time Complexity:** `O(n)` because each element is added and removed from the set at most once.
- **Space Complexity:** `O(n)` in the worst case for the set storing unique elements.

## Summary
This approach works by ensuring the window always contains unique elements, allowing us to compute the maximum sum efficiently. Key takeaways include handling duplicates by adjusting the window and considering edge cases like arrays with all unique or all duplicate elements.


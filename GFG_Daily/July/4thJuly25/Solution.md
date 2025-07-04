# Solution Explanation

## Intuition
The key insight is to use a **sliding window approach** with two pointers. Instead of checking every possible subarray individually, we can efficiently count all valid subarrays by maintaining a window that contains **at most k distinct elements**. For each valid window position, we can determine how many subarrays end at the current position and have at most k distinct elements.

## Approach
The solution uses a **two-pointer sliding window technique** combined with a `HashMap` to track element frequencies:

1. **Initialize** two pointers (`left` and `right`) both starting at index 0, and a `HashMap` to store element frequencies
2. **Expand the window** by moving the `right` pointer and adding the current element to the `HashMap`
3. **Shrink the window** when necessary: if the number of distinct elements exceeds `k`, move the `left` pointer right and remove elements from the `HashMap` until we have at most `k` distinct elements
4. **Count subarrays**: for each valid window position, add `(right - left + 1)` to the result. This represents all subarrays ending at the current `right` position that have at most `k` distinct elements
5. **Continue** until the `right` pointer reaches the end of the array

The crucial observation is that when we have a valid window from `left` to `right`, **all subarrays ending at position `right`** and starting from any position between `left` and `right` (inclusive) will have at most `k` distinct elements.

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the array. Each element is visited at most twice (once by the right pointer and once by the left pointer)
- **Space Complexity:** `O(k)` for the `HashMap` that stores at most `k` distinct elements

## Summary
The sliding window approach works efficiently because it **avoids redundant calculations** by maintaining a valid window and using the mathematical property that for a window of size `w`, there are `w` subarrays ending at the rightmost position. The `HashMap` helps us track distinct elements in `O(1)` time for insertions and deletions. This solution handles all edge cases naturally, including when `k` is larger than the number of distinct elements in the array, and when the array has duplicate elements. The key insight is that we don't need to generate all subarrays explicitly - we can count them mathematically based on valid window positions.


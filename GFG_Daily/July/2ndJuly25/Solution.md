# Solution Explanation

## Intuition
The key insight is to use a **sliding window technique** with two pointers to maintain a subarray that contains at most two distinct integers. We **expand the window** by moving the right pointer and **shrink the window** from the left when we have more than two distinct elements.

## Approach
1. **Initialize** two pointers (`start` and `i`) and a `HashMap` to track the frequency of elements in the current window
2. **Expand the window** by moving the right pointer (`i`) and adding elements to the map
3. **Check constraint**: If the number of distinct elements exceeds 2, shrink the window from the left:
   - Decrease the frequency of the element at `start` position
   - Remove the element from map if its frequency becomes 0
   - Move `start` pointer forward
4. **Update maximum length** after ensuring the window is valid (at most 2 distinct elements)
5. **Repeat** until the right pointer reaches the end of the array

## Algorithm
1. Initialize `start = 0`, `maxLength = 0`, and an empty `HashMap`
2. For each position `i` from 0 to `n-1`:
   - Add `arr[i]` to the map and increment its frequency
   - While `map.size() > 2`:
     - Decrement frequency of `arr[start]` in the map
     - If frequency becomes 0, remove the element from map
     - Increment `start`
   - Update `maxLength = max(maxLength, i - start + 1)`
3. Return `maxLength`

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the array. Each element is added and removed from the map at most once.
- **Space Complexity:** `O(1)` since the map can contain at most 2 distinct elements at any time.

## Summary
The **sliding window approach** works efficiently because it maintains the constraint (at most 2 distinct integers) while maximizing the window size. The two-pointer technique ensures we don't miss any valid subarrays, and the HashMap allows us to **quickly track element frequencies** and determine when to shrink the window. This approach handles all edge cases naturally, including arrays with fewer than 2 distinct elements.


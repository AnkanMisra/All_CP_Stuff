
# Solution Explanation

## Intuition
This problem is essentially asking for the **longest contiguous subarray** that contains at most **two distinct elements**. We can use a **sliding window approach** with two pointers to efficiently find this maximum length.

## Approach
We use a **sliding window technique** with a HashMap to track the frequency of fruit types in our current window:

1. **Expand the window:** Move the right pointer and add fruits to our HashMap, keeping track of their frequencies
2. **Contract the window:** When we have more than 2 distinct fruit types, move the left pointer until we have exactly 2 or fewer types
3. **Track maximum:** At each step, update our maximum window size
4. **Continue:** Repeat until we've processed all fruits

The HashMap helps us efficiently track which fruit types are in our current window and their counts, allowing us to know when to shrink the window.

## Algorithm
1. Initialize two pointers `l` (left) and `r` (right) at the start of the array
2. Use a HashMap to store fruit types and their frequencies in the current window
3. For each position of the right pointer:
   - Add the current fruit to the HashMap (increment its count)
   - While the HashMap has more than 2 distinct keys (fruit types):
     - Remove fruits from the left side by decrementing their count
     - Remove the fruit type from HashMap if its count becomes 0
     - Move the left pointer forward
   - Update the maximum length with the current window size `(r - l + 1)`
   - Move the right pointer forward
4. Return the maximum length found

## Complexity
- **Time Complexity:** `O(n)` where n is the length of the fruits array. Each element is visited at most twice (once by right pointer, once by left pointer)
- **Space Complexity:** `O(1)` since the HashMap will contain at most 3 entries (2 valid fruit types + 1 being removed)

## Summary
The **sliding window approach** works perfectly here because we need a contiguous subarray with a specific constraint (at most 2 distinct elements). The HashMap efficiently tracks fruit types in our current window, and the two-pointer technique ensures we examine each element only a constant number of times. The key insight is recognizing this as a **longest subarray with constraint** problem rather than trying to check all possible subarrays.


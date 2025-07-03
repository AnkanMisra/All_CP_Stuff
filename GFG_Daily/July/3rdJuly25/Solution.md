
# Solution Explanation

## Intuition
The **sliding window technique** is perfect for this problem because we need to find the longest contiguous substring with exactly `k` distinct characters. We can use **two pointers** to maintain a window and a `HashMap` to track character frequencies, allowing us to efficiently expand and contract the window while maintaining the exact count of distinct characters.

## Approach
1. **Initialize** two pointers `left` and `right` at the beginning of the string, a `HashMap` to store character frequencies, and `maxLen` to track the maximum length found.

2. **Expand the window** by moving the `right` pointer and adding characters to the `HashMap` with their frequencies.

3. **Contract the window** when the number of distinct characters exceeds `k`:
   - Move the `left` pointer forward
   - Decrease the frequency of the character at `left` position
   - Remove the character from the `HashMap` if its frequency becomes zero

4. **Update maximum length** whenever the window contains exactly `k` distinct characters by calculating `right - left + 1`.

5. **Return the result**: Return `maxLen` if a valid substring was found, otherwise return `-1`.

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string, as each character is visited at most twice (once by right pointer and once by left pointer)
- **Space Complexity:** `O(k)` for the `HashMap` storing at most `k` distinct characters

## Summary
The **sliding window approach** efficiently solves this problem by maintaining a window with exactly `k` distinct characters. The key insight is that we only need to track character frequencies and adjust the window size dynamically. **Edge cases** include when `k` is larger than the total number of distinct characters in the string (return `-1`) and when the string is empty or `k` is zero. The algorithm handles all cases correctly by using the frequency map to determine when to expand or contract the window.



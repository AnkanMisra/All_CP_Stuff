# Solution Explanation

### Intuition

To count the number of substrings with exactly `k` distinct characters, we can use the sliding window technique. However, it's easier to count the number of substrings with **at most** `k` distinct characters and subtract the number of substrings with **at most** `k-1` distinct characters. The difference gives the number of substrings with **exactly** `k` distinct characters.

### Approach

- Use a helper function to count the number of substrings with at most `k` distinct characters.
- The helper function uses a sliding window with two pointers (`left` and `right`) and a frequency array to keep track of the number of distinct characters in the current window.
- Expand the window by moving `right` and include the current character.
- If the number of distinct characters exceeds `k`, shrink the window from the left until the constraint is satisfied.
- For each position of `right`, add the number of valid substrings ending at `right` to the count.
- The final answer is `helper(s, k) - helper(s, k - 1)`.

### Algorithm

1. Define a helper function that returns the number of substrings with at most `k` distinct characters.
2. Use a sliding window to maintain the count of distinct characters in the current window.
3. For each character, expand the window and update the count.
4. If the window has more than `k` distinct characters, shrink it from the left.
5. The number of valid substrings ending at each position is added to the result.
6. The answer is the difference between the counts for `k` and `k-1`.

### Complexity

- **Time Complexity:** O(n), where n is the length of the string (each character is processed at most twice).
- **Space Complexity:** O(1), since the frequency array size is constant (256 for all ASCII characters).

### Summary

- The solution uses the sliding window technique to efficiently count substrings with at most `k` distinct characters.
- By subtracting the count for `k-1`, we get the number of substrings with exactly `k` distinct characters.
- The approach is optimal and handles large strings efficiently.

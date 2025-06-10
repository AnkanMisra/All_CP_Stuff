# Solution Explanation

## Intuition
The problem asks for the maximum difference between the frequency of a character with an odd frequency and a character with an even frequency in the string. To maximize the difference, we want the largest odd frequency and the smallest even frequency.

## Approach
- Count the frequency of each character in the string using a hash map.
- Iterate through the frequencies:
  - Track the largest odd frequency (`odd`).
  - Track the smallest even frequency (`even`).
- The answer is `odd - even`.
- If there is no character with an odd or even frequency, return -1 (though the problem guarantees at least one of each).

## Complexity
- Time Complexity: O(n), where n is the length of the string, for counting frequencies and finding min/max.
- Space Complexity: O(1), since the number of lowercase English letters is constant.

## Summary
By counting character frequencies and tracking the largest odd and smallest even frequencies, we can efficiently compute the required maximum difference.

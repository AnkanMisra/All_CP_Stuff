# Solution Explanation

## Intuition
The problem requires removing all `'*'` characters from the string, and for each `'*'`, also removing the smallest non-`'*'` character to its left. If there are multiple smallest characters, any can be chosen, but to achieve the lexicographically smallest result, we should always remove the rightmost occurrence of the smallest character.

## Approach
- Use a priority queue (min-heap) to keep track of all non-`'*'` characters and their indices as we iterate through the string.
- For each `'*'` encountered, remove the smallest character (by value, and if tied, the rightmost by index) from the priority queue and mark its index as deleted.
- After processing the string, build the result by skipping all deleted characters and all `'*'` characters.

## Complexity
- Time Complexity: O(n log n), where n is the length of the string. Each insertion and removal from the priority queue takes O(log n) time.
- Space Complexity: O(n), for the priority queue and the deleted marker array.

## Summary
By always removing the smallest available character to the left of each `'*'`, and using a priority queue to efficiently find and remove it, we ensure the resulting string is lexicographically minimal after all `'*'` characters are removed.

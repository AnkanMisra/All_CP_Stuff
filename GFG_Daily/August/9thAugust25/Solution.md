
# Solution Explanation

## Intuition
The problem asks for the **longest periodic proper prefix** that can be repeated to form a string starting with the original string. The key insight is to find the **longest suffix that matches a prefix** of the string. This is essentially finding the **failure function** or **border** of the string, which is commonly used in string matching algorithms like KMP.

## Approach
The solution uses a **two-pointer technique** to find the longest matching suffix-prefix pair:

1. **Initialize pointers**: Set `i = 0` (prefix pointer) and `j = n-1` (suffix pointer starting from the end)
2. **Track position**: Use `pos` to track the current suffix starting position
3. **Character matching**: Compare characters at positions `i` and `j`
   - If they match, increment both pointers and count the match length
   - If they don't match, reset the prefix pointer and move to the next suffix position
4. **Return result**: If a valid periodic prefix is found, return `n - ans` (length of the prefix), otherwise return `-1`

## Algorithm
1. Start with `i = 0`, `j = n-1`, `pos = n-1`, and `ans = 0`
2. While `j < n` and `pos > 0`:
   - If `s[i] == s[j]`: increment `i`, `j`, and `ans`
   - Else: reset `i = 0`, decrement `pos`, set `j = pos`, and reset `ans = 0`
3. If `pos == 0`, return `-1` (no valid prefix found)
4. Otherwise, return `n - ans` (length of the longest periodic proper prefix)

## Complexity
- **Time Complexity**: `O(n^2)` in the worst case, where `n` is the length of the string
- **Space Complexity**: `O(1)` as only constant extra space is used

## Summary
This approach works by systematically checking all possible suffix positions and finding the longest one that matches a prefix. The algorithm ensures we find a **proper prefix** (not the entire string) by checking `pos > 0`. The key insight is that if a prefix can be repeated to form the original string, then the string must have a suffix that matches this prefix exactly.


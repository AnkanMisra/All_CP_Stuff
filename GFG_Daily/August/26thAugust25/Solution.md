
# Solution Explanation

## Intuition
To check if `s1` is a subsequence of `s2`, we need to **match characters of s1 in order** within `s2`. We can use a **two-pointer approach** where one pointer tracks our position in `s1` and another tracks our position in `s2`.

## Approach
1. **Initialize two pointers:** `i` for `s1` and `j` for `s2`, both starting at 0
2. **Iterate through s2:** For each character in `s2`:
   - If the current character in `s2` matches the current character in `s1`, **advance the pointer in s1**
   - Always **advance the pointer in s2**
3. **Check completion:** If we've matched all characters in `s1` (i.e., `i` equals the length of `s1`), then `s1` is a subsequence of `s2`
4. **Return result:** Return `true` if all characters matched, `false` otherwise

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of `s2`
- **Space Complexity:** `O(1)` as we only use constant extra space

## Summary
The **two-pointer technique** works because we maintain the relative order of characters while scanning through `s2`. We only need to find each character of `s1` in `s2` in the same order, without requiring them to be consecutive. The algorithm is **efficient and handles edge cases** like empty strings naturally.
```java
class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s1.length();
    }
}
```

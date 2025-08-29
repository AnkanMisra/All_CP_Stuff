
# Solution Explanation

## Intuition
The problem asks for the **smallest substring** in `s` that contains all characters of `p`. This is a classic **sliding window** problem where we need to find the minimum window that satisfies a condition. The key insight is to use **two pointers** to maintain a dynamic window and expand/contract it based on whether it contains all required characters.

## Approach
We use the **sliding window technique** with two pointers (`left` and `right`) to find the minimum window:

1. **Frequency Counting**: First, count the frequency of each character in pattern `p` using an array.

2. **Window Expansion**: Use the `right` pointer to expand the window by including characters from `s`. For each character:
   - If it's part of pattern `p`, update the window frequency
   - Track how many required characters we still need

3. **Window Contraction**: When the window contains all characters of `p` (requiredChars becomes 0):
   - Try to minimize the window by moving the `left` pointer
   - Update the minimum window if current window is smaller
   - Remove characters from the left until the window becomes invalid

4. **Result**: Return the smallest valid window found, or empty string if none exists.

## Algorithm
1. Create frequency array for pattern `p`
2. Initialize two pointers `left = 0`, `right = 0`
3. Initialize `requiredChars = p.length()` and window frequency array
4. While `right < s.length()`:
   - Expand window by including `s[right]`
   - If character is needed, update counters
   - While window is valid (contains all characters):
     - Update minimum window if current is smaller
     - Contract window from left
   - Move `right` pointer
5. Return the minimum window substring

## Complexity
- **Time Complexity:** `O(|s| + |p|)`
  - We traverse string `s` at most twice (once with `right` pointer, once with `left` pointer)
  - Pattern `p` is traversed once for frequency counting
- **Space Complexity:** `O(1)`
  - We use fixed-size arrays of length 26 for lowercase English letters
  - All other variables use constant space

## Summary
The **sliding window approach** works efficiently because it avoids checking all possible substrings. Instead, it maintains a dynamic window that expands when we need more characters and contracts when we have all required characters. The key insight is tracking the **required character count** to know when the window is valid. This approach handles **duplicates correctly** by using frequency arrays and ensures we find the **lexicographically smallest** result by processing from left to right. **Corner cases** include when `s` is shorter than `p` (impossible to find solution) and when no valid window exists (return empty string).
```java
class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "";
        }

        int[] patternFreq = new int[26];
        for (char c : p.toCharArray()) {
            patternFreq[c - 'a']++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int requiredChars = p.length();
        int[] windowFreq = new int[26];

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (patternFreq[rightChar - 'a'] > 0) {
                windowFreq[rightChar - 'a']++;
                if (windowFreq[rightChar - 'a'] <= patternFreq[rightChar - 'a']) {
                    requiredChars--;
                }
            }

            while (requiredChars == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (patternFreq[leftChar - 'a'] > 0) {
                    windowFreq[leftChar - 'a']--;
                    if (windowFreq[leftChar - 'a'] < patternFreq[leftChar - 'a']) {
                        requiredChars++;
                    }
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
```

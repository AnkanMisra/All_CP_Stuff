
# Solution Explanation

## Intuition
The largest odd-valued substring must **end at an odd digit** because any number ending with an even digit is even. Therefore, scanning the string from right to left and stopping at the **first odd digit** immediately gives the longest (and hence largest) odd substring.

## Approach
1. Start from the **last character** of `num` and move leftwards.
2. For each character, check if it represents an **odd digit** (`1, 3, 5, 7, 9`).
3. As soon as an odd digit is found at position `i`, return the substring `num[0 .. i]` (inclusive). This is the longest possible odd substring and thus the largest in value.
4. If no odd digit is found after scanning the entire string, return the empty string `""`.

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of `num` (single pass).
- **Space Complexity:** `O(1)` since only constant extra space is used.

## Summary
By recognizing that the last digit determines the parity of the number, a single right-to-left scan suffices to locate the first odd digit and extract the largest odd substring. If no such digit exists, the answer is an empty string.
```java
class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
```

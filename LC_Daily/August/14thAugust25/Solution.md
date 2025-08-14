
# Solution Explanation

## Intuition
The problem asks us to find the **largest good integer** from all possible 3-character substrings where all characters are the same. Since we want the **maximum** value, we need to compare all valid substrings lexicographically. A string comparison will naturally give us the largest digit sequence (e.g., `"999"` > `"888"` > `"777"`).

## Approach
We use a **sliding window approach** to examine every possible 3-character substring:

1. **Iterate through the string** from index 0 to `length - 3` to ensure we can form 3-character substrings
2. **Extract each 3-character substring** using `substring(i, i + 3)`
3. **Check if all three characters are identical** by comparing `charAt(0)`, `charAt(1)`, and `charAt(2)`
4. **Track the maximum valid substring** by comparing with the current result using `compareTo()` method
5. **Return the result** or empty string if no valid substring is found

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the input string. We iterate through the string once, and each substring operation and comparison takes constant time.
- **Space Complexity:** `O(1)` as we only use a constant amount of extra space to store the result string and temporary substring.

## Summary
This approach works because **string comparison in Java is lexicographic**, which means `"999"` will always be greater than `"888"`, `"777"`, etc. The algorithm efficiently finds all valid 3-same-digit substrings and keeps track of the maximum one. **Key corner cases** include strings with no valid substrings (return empty string) and strings with leading zeros in valid substrings (like `"000"` which should be returned as is).
```java
class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            String substring = num.substring(i, i + 3);
            if (substring.charAt(0) == substring.charAt(1) &&
                substring.charAt(1) == substring.charAt(2)) {
                if (result.isEmpty() || substring.compareTo(result) > 0) {
                    result = substring;
                }
            }
        }

        return result;
    }
}

```

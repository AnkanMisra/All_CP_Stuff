
# Solution Explanation

## Intuition
The main idea is to **split the binary string into the minimum number of substrings**, where each substring represents a **power of 5** in decimal and has **no leading zeros**. Since the string is short (up to 30 characters), we can use recursion or dynamic programming to try all possible splits efficiently.

## Approach
- **Precompute all binary representations of powers of 5** that could possibly fit within the string length (up to `5^13` covers all possible substrings of length ≤ 30).
- Store these valid binary strings in a `set` for **fast lookup**.
- Use a **recursive function** (or DP) to try every possible prefix of the current string:
  - If the prefix is in the set (i.e., is a valid power of 5 and has no leading zeros), recursively solve for the remaining suffix.
  - Track the **minimum number of cuts** needed to split the string into valid pieces.
- If no valid split is possible, return `-1`.

## Complexity
- **Time Complexity:** `O(n^2)` (where `n` is the length of the string, since for each position we may check all possible substrings)
- **Space Complexity:** `O(n)` (for recursion stack or DP memoization, plus a small set of valid powers of 5)

## Summary
- The approach works because the number of possible powers of 5 is small and the string is short, allowing us to try all possible splits efficiently.
- **Key insight:** Precomputing valid binary strings for powers of 5 and using recursion or DP ensures we only consider valid splits and avoid unnecessary work.
- **Corner cases:** Strings with leading zeros, or strings that cannot be split into valid powers of 5, are handled by returning `-1`.


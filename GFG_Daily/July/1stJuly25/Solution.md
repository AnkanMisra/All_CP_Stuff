# Solution Explanation

## Intuition
The problem asks us to find **substrings of length k that have exactly k-1 distinct characters**. This means we need exactly one character to appear more than once in each valid substring. The most straightforward approach is to **examine every possible substring of length k** and count the distinct characters in each one.

## Approach
We use a **brute force sliding window approach** with a HashSet to count distinct characters:

1. **Iterate through all possible starting positions** for substrings of length `k`
2. **For each substring of length k:**
   - Create a HashSet to store unique characters
   - Add all characters from the current substring to the HashSet
   - Check if the HashSet size equals `k-1`
3. **Count valid substrings** where distinct character count equals `k-1`
4. **Return the total count**

## Algorithm
1. Initialize `count = 0` to track valid substrings
2. Loop `i` from `0` to `s.length() - k` (all valid starting positions)
3. For each position `i`:
   - Create a new HashSet `ans`
   - Loop `j` from `i` to `i + k - 1` to get substring of length `k`
   - Add `s.charAt(j)` to the HashSet
   - If HashSet size equals `k-1`, increment `count`
4. Return `count`

## Complexity
- **Time Complexity:** `O(n * k)` where `n` is the string length and `k` is the substring length
  - We iterate through `n-k+1` starting positions
  - For each position, we process `k` characters
- **Space Complexity:** `O(k)` for the HashSet storing at most `k` distinct characters

## Summary
This solution works by **systematically checking every possible substring of length k** and using a HashSet to efficiently count distinct characters. The approach is straightforward and handles all edge cases naturally. The key insight is that a substring with **exactly k-1 distinct characters** means one character appears at least twice while others appear once. The HashSet automatically handles duplicate character counting, making the implementation clean and reliable.


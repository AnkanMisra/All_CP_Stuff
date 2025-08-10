
# Solution Explanation

## Intuition
The key insight is to use the **"expand around centers"** technique. For every possible center in the string, we expand outwards to find all palindromes centered at that position. Since palindromes can have **odd length** (single character center) or **even length** (between two characters), we need to check both cases for each position.

## Approach
For each position `c` in the string, we perform two expansions:

1. **Even-length palindromes**: Start with `l = c` and `r = c + 1`, then expand outwards while characters match
2. **Odd-length palindromes**: Start with `l = c - 1` and `r = c + 1`, then expand outwards while characters match

For each valid palindrome found during expansion, we increment our count. The expansion continues as long as:
- Both pointers are within bounds (`l >= 0` and `r < n`)
- Characters at both positions match (`s.charAt(l) == s.charAt(r)`)

## Algorithm
1. Initialize `count = 0` to track palindromic substrings
2. For each center position `c` from `0` to `n-1`:
   - **Check even-length palindromes**: Set `l = c`, `r = c + 1`
     - While `l >= 0`, `r < n`, and `s[l] == s[r]`: increment count, then `l--`, `r++`
   - **Check odd-length palindromes**: Set `l = c - 1`, `r = c + 1`
     - While `l >= 0`, `r < n`, and `s[l] == s[r]`: increment count, then `l--`, `r++`
3. Return the total count

## Complexity
- **Time Complexity:** `O(n²)` - For each of the `n` centers, we potentially expand up to `n/2` positions in both directions
- **Space Complexity:** `O(1)` - Only using a few variables for counting and indexing

## Summary
This approach efficiently finds all palindromic substrings by **systematically checking every possible center**. It handles both odd and even length palindromes correctly and avoids the need for complex string manipulation. The key insight is that every palindrome has a center, and by expanding around each possible center, we can find all palindromes without missing any or counting duplicates.


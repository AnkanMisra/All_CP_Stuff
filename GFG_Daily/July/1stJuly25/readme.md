# Problem: Substrings of length k with k-1 distinct elements

## Problem Description
Given a string `s` consisting only lowercase alphabets and an integer `k`. Find the **count of all substrings of length k** which have **exactly k-1 distinct characters**.

## Input Format
- **String s:** consisting only of lowercase alphabets
- **Integer k:** the length of substrings to consider

## Output Format
- **Integer:** the count of valid substrings

## Examples

### Example 1
**Input:** `s = "abcc", k = 2`<br/>
**Output:** `1`<br/>
**Explanation:** Possible substrings of length `k = 2` are:
- `ab`: 2 distinct characters
- `bc`: 2 distinct characters  
- `cc`: 1 distinct character
Only **one valid substring** (`cc` with 1 distinct character = k-1), so count is `1`.

### Example 2
**Input:** `s = "aabab", k = 3`<br/>
**Output:** `3`<br/>
**Explanation:** Possible substrings of length `k = 3` are:
- `aab`: 2 distinct characters
- `aba`: 2 distinct characters
- `bab`: 2 distinct characters
All these substrings have **exactly k-1 = 2 distinct characters**, so the total count is `3`.

## Constraints
- **String length:** `1 ≤ s.size() ≤ 10^5`
- **Substring length:** `2 ≤ k ≤ 27`

## Notes
- The problem requires finding substrings with **exactly k-1 distinct characters**, not k distinct characters
- Only lowercase alphabets are considered
- All possible substrings of length k must be examined



# Problem: Palindrome SubStrings

## Problem Description
Given a string `s`, **count all palindromic sub-strings** present in the string. The **length of the palindromic sub-string must be greater than or equal to 2**.

**Note:** A substring is palindromic if it reads the same forwards and backwards.

## Input Format
A string `s` containing only lowercase English characters.

## Output Format
Return an integer representing the **count of all palindromic substrings** of length ≥ 2.

## Examples

### Example 1
**Input:** `s = "abaab"`<br/>

**Output:** `3`<br/>

**Explanation:** All palindromic substrings (of length > 1) are: `"aba"`, `"aa"`, `"baab"`.

### Example 2
**Input:** `s = "aaa"`<br/>

**Output:** `3`<br/>

**Explanation:** All palindromic substrings (of length > 1) are: `"aa"`, `"aa"`, `"aaa"`.

### Example 3
**Input:** `s = "abbaeae"`<br/>

**Output:** `4`<br/>

**Explanation:** All palindromic substrings (of length > 1) are: `"bb"`, `"abba"`, `"aea"`, `"eae"`.

## Constraints
- **2 ≤ s.size() ≤ 5 × 10³**
- **s contains only lowercase English characters**



# Problem: Maximum Non-Overlapping Odd Palindrome Sum

## Problem Description
Given a string `s` consisting of lowercase English letters, find the **maximum possible sum** of the lengths of any **two non-empty and non-overlapping palindromic substrings of odd length**.

Formally, choose any two substrings `s[i...j]` and `s[k...l]` such that `1 ≤ i ≤ j < k ≤ l ≤ s.size()`, both substrings are **palindromes of odd length**, and they **do not overlap**. Return the **maximum sum** of their lengths.

## Input Format
A string `s` consisting of lowercase English letters.

## Output Format
Return an integer representing the **maximum sum** of lengths of two non-overlapping odd-length palindromic substrings.

## Examples

### Input

`s = "xyabacbcz"`<br/>

### Output

`6`<br/>

**Explanation:** `"aba"` and `"cbc"` are non-overlapping odd-length palindromes. Their lengths are `3` and `3` which gives the sum as `6`.

### Input

`s = "gfgforgeeks"`<br/>

### Output

`4`<br/>

**Explanation:** `"gfg"` and `"g"` are non-overlapping odd-length palindromes. Their lengths are `3` and `1` which gives the sum as `4`.

## Constraints
`2 ≤ s.size() ≤ 10^5`

## Notes
- A **palindrome** is a string that reads the same forward and backward.
- A **substring** is a contiguous sequence of characters within the string.
- Both palindromic substrings must be of **odd length** and **non-overlapping**.


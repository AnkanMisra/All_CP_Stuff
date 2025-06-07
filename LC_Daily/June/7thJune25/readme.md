# 3170. Lexicographically Minimum String After Removing Stars

## Problem Statement

You are given a string `s` that may contain any number of `'*'` characters. Your task is to remove all `'*'` characters.

While there is a `'*'`, do the following operation:
- Delete the leftmost `'*'` and the smallest non-`'*'` character to its left. If there are several smallest characters, you can delete any of them.

Return the resulting string after removing all `'*'` characters.

## Input Format

- A single string `s` (1 ≤ s.length ≤ 10^5), consisting only of lowercase English letters and `'*'`.

## Output Format

- The resulting string after all `'*'` characters have been removed according to the rules.

## Examples

### Example 1

Input:  
s = "aaba*"

Output:  
"aab"

Explanation:  
We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.

### Example 2

Input:  
s = "abc"

Output:  
"abc"

Explanation:  
There is no '*' in the string.

## Constraints

- 1 ≤ s.length ≤ 10^5
- s consists only of lowercase English letters and '*'.
- The input is generated such that it is possible to delete all '*' characters.

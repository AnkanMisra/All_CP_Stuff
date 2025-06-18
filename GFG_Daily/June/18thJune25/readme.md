# All Palindromic Partitions

## Problem Statement

Given a string `s`, find all possible ways to partition it such that every substring in the partition is a palindrome.

## Input Format

- A string `s` (1 ≤ s.size() ≤ 20)

## Output Format

- A list of lists of strings, where each inner list represents a valid partition of `s` into palindromic substrings.

## Examples

### Example 1

Input:  
s = "geeks"

Output:  
[[g, e, e, k, s], [g, ee, k, s]]

Explanation:  
`[g, e, e, k, s]` and `[g, ee, k, s]` are the only partitions of "geeks" where each substring is a palindrome.

### Example 2

Input:  
s = "abcba"

Output:  
[[a, b, c, b, a], [a, bcb, a], [abcba]]

Explanation:  
`[a, b, c, b, a]`, `[a, bcb, a]` and `[abcba]` are the only partitions of "abcba" where each substring is a palindrome.

## Constraints

- 1 ≤ s.size() ≤ 20

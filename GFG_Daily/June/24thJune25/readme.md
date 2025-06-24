# Problem: Lexicographically Largest String After K Deletions

## Problem Description

Given a string `s` consisting of lowercase English letters and an integer `k`, your task is to remove exactly `k` characters from the string. The resulting string must be the **largest possible in lexicographical order**, while maintaining the relative order of the remaining characters.

## Input Format

- A string `s` of lowercase English letters.
- An integer `k` (0 ≤ k < s.size()).

## Output Format

- A string representing the lexicographically largest string possible after removing exactly `k` characters, maintaining the relative order of the remaining characters.

## Examples

### Example 1

**Input:**  
s = "ritz", k = 2

**Output:**  
tz

**Explanation:**  
By removing two characters in all possible ways, we get: "ri", "rt", "rz", "it", "iz", and "tz". Among these, "tz" is lexicographically largest.

### Example 2

**Input:**  
s = "zebra", k = 3

**Output:**  
zr

**Explanation:**  
Removing "e", "b", and "a" results in "zr", which is lexicographically largest.

## Constraints

- 1 ≤ s.size() ≤ 10^5
- 0 ≤ k < s.size()

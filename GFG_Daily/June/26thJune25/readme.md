# Problem: Game with String

## Problem Description

Given a string `s` consisting of lowercase alphabets and an integer `k`, your task is to find the **minimum possible value** of the string after removing exactly `k` characters.

The **value** of the string is defined as the sum of the squares of the frequencies of each distinct character present in the string.

## Input Format

- A string `s` consisting of lowercase English letters.
- An integer `k` (0 ≤ k ≤ s.length()).

## Output Format

- An integer representing the minimum possible value of the string after removing exactly `k` characters.

## Examples

### Example 1

**Input:**  
s = "abbccc", k = 2

**Output:**  
6

**Explanation:**  
We remove two 'c' to get the value as 1² + 2² + 1² = 6,  
or we remove one 'b' and one 'c' to get the value 1² + 1² + 2² = 6.

### Example 2

**Input:**  
s = "aaab", k = 2

**Output:**  
2

**Explanation:**  
We remove two 'a'. Now we get the value as 1² + 1² = 2.

## Constraints

- 0 ≤ k ≤ s.length() ≤ 10^5

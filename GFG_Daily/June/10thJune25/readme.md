# Exactly One Swap

## Problem Statement

Given a string `s`, return the number of distinct strings that can be obtained by exactly one swap of two different indices (`i < j`).

## Input Format

- A string `s` (2 ≤ s.size() ≤ 10^4)

## Output Format

- An integer representing the number of distinct strings that can be obtained by exactly one swap.

## Examples

### Example 1

Input:  
s = "geek"

Output:  
6

Explanation:  
After one swap, there are only 6 distinct strings possible:  
"egek", "eegk", "geek", "geke", "gkee", and "keeg".

### Example 2

Input:  
s = "aaaa"

Output:  
1

Explanation:  
Only one distinct string is possible after one swap: "aaaa".

## Constraints

- 2 ≤ s.size() ≤ 10^4

# 2434. Using a Robot to Print the Lexicographically Smallest String

## Problem Statement

You are given a string `s` and a robot that currently holds an empty string `t`. You can repeatedly perform one of the following operations until both `s` and `t` are empty:

1. Remove the first character of `s` and append it to the end of `t`.
2. Remove the last character of `t` and write it on paper (append it to the result string).

Return the lexicographically smallest string that can be written on the paper.

## Input Format

- A single string `s` (1 ≤ s.length ≤ 10^5), consisting of only English lowercase letters.

## Output Format

- Return the lexicographically smallest string that can be written on the paper.

## Examples

### Example 1

Input:  
s = "zza"  

Output:  
"azz"  

Explanation:  
- Initially, p = "", s = "zza", t = "".
- Perform the first operation three times: p = "", s = "", t = "zza".
- Perform the second operation three times: p = "azz", s = "", t = "".

### Example 2

Input:  
s = "bac"  

Output:  
"abc"  

Explanation:  
- Perform the first operation twice: p = "", s = "c", t = "ba".
- Perform the second operation twice: p = "ab", s = "c", t = "".
- Perform the first operation: p = "ab", s = "", t = "c".
- Perform the second operation: p = "abc", s = "", t = "".

### Example 3

Input:  
s = "bdda"  

Output:  
"addb"  

Explanation:  
- Initially, p = "", s = "bdda", t = "".
- Perform the first operation four times: p = "", s = "", t = "bdda".
- Perform the second operation four times: p = "addb", s = "", t = "".

## Constraints

- 1 ≤ s.length ≤ 10^5
- s consists of only English lowercase letters.

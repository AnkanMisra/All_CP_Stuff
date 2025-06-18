# B. Above the Clouds

## Problem Statement

You are given a string `s` of length `n`, consisting of lowercase Latin letters. Determine whether there exist three non-empty strings `a`, `b`, and `c` such that:

- `a + b + c = s` (the concatenation of `a`, `b`, and `c` equals `s`)
- The string `b` is a substring of the string `a + c` (the concatenation of `a` and `c`)

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- For each test case:
  - The first line contains a single integer `n` (3 ≤ n ≤ 10^5) — the length of the string `s`.
  - The second line contains the string `s` of length `n`, consisting of lowercase English letters.

It is guaranteed that the sum of `n` across all test cases does not exceed 2⋅10^5.

## Output Format

For each test case, output "Yes" if there exist three non-empty strings `a`, `b`, and `c` that satisfy the conditions, and "No" otherwise.

You may output the answer in any case.

## Examples

### Input
12  
3  
aaa  
3  
aba  
3  
aab  
4  
abca  
4  
abba  
4  
aabb  
5  
abaca  
5  
abcda  
5  
abcba  
6  
abcbbf  
6  
abcdaa  
3  
abb  

### Output
Yes  
No  
Yes  
No  
Yes  
Yes  
Yes  
No  
Yes  
Yes  
Yes  
Yes  

## Explanation

- In the first test case, `a = "a"`, `b = "a"`, `c = "a"`. `b` is a substring of `a + c = "aa"`.
- In the second test case, no such split exists.
- In the third test case, `a = "a"`, `b = "a"`, `c = "b"`. `b` is a substring of `a + c = "ab"`.
- In the sixth test case, `a = "a"`, `b = "ab"`, `c = "b"`. `b` is a substring of `a + c = "ab"`.

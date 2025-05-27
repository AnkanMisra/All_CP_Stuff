# Problem: B. Not Quite a Palindromic String

## Problem Description

You are given a binary string `s` of even length `n`. A pair of indices `(i, n - i + 1)` (1 ≤ i < n - i + 1) is considered a **good pair** if `s[i] == s[n - i + 1]`.

Vlad wants to **rearrange** the characters of the string so that **exactly `k` good pairs** exist.

Your task is to determine for each test case whether it is **possible** to rearrange the given string to get exactly `k` good pairs.

### Definitions

- A binary string: a string consisting only of the characters '0' and '1'.
- A good pair: For a pair `(i, n - i + 1)`, `s[i] == s[n - i + 1]`.

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 10⁴): the number of test cases.
- Each test case consists of two lines:
  - The first line contains two integers `n` and `k` (2 ≤ n ≤ 2 × 10⁵, 0 ≤ k ≤ n²), where `n` is even.
  - The second line contains the binary string `s` of length `n`.

It is guaranteed that the sum of all `n` across test cases will not exceed 2 × 10⁵.

## Output Format

- For each test case, output "YES" if it is possible to rearrange the string to get exactly `k` good pairs.
- Otherwise, output "NO".

You can print each answer in any case (e.g., "Yes", "YES", "yes" are all accepted).

## Example

### Input
```
6
6 2
000000
2 1
01
4 1
1011
10 2
1101011001
10 1
1101011001
2 1
11
```

### Output
```
NO
NO
YES
NO
YES
YES
```

## Goal

Rearrange characters of the string so that the **number of good pairs** is **exactly `k`**.

# A. Equal Subsequences

## Problem Statement

A **bitstring** is called **perfect** if it has the same number of "101" subsequences and "010" subsequences.
Construct a perfect bitstring of length `n` where the number of '1' characters it contains is exactly `k`.

It can be proven that the construction is always possible. If there are multiple solutions, output any of them.

## Input Format

- The first line contains the number of test cases `t` (1 ≤ t ≤ 500).
- For each test case:
  - The first line contains two integers `n` and `k` (1 ≤ n ≤ 100, 0 ≤ k ≤ n) — the size of the bitstring and the number of '1' characters.

## Output Format

For each test case, output the constructed bitstring.

## Examples

### Input
5  
4 2  
5 3  
5 5  
6 2  
1 1  

### Output
1010  
10110  
11111  
100010  
1  

## Note

- In the first test case, the number of "101" and "010" subsequences is the same, both being 1, and the sequence contains exactly two '1' characters.
- In the second test case, the number of "101" and "010" subsequences is the same, both being 2, and the sequence contains exactly three '1' characters.
- In the third test case, the number of "101" and "010" subsequences is the same, both being 0, and the sequence contains exactly five '1' characters.

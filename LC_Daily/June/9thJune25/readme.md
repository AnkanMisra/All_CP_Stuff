# 440. K-th Smallest in Lexicographical Order

## Problem Statement

Given two integers `n` and `k`, return the k-th lexicographically smallest integer in the range `[1, n]`.

## Input Format

- Two integers `n` and `k` (1 ≤ k ≤ n ≤ 10^9)

## Output Format

- An integer representing the k-th lexicographically smallest number in the range `[1, n]`.

## Examples

### Example 1

Input:  
n = 13, k = 2

Output:  
10

Explanation:  
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

### Example 2

Input:  
n = 1, k = 1

Output:  
1

## Constraints

- 1 ≤ k ≤ n ≤ 10^9

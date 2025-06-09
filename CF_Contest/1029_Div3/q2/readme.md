# B. Shrink

## Problem Statement

A shrink operation on an array `a` of size `m` is defined as follows:
- Choose an index `i` (`2 ≤ i ≤ m−1`) such that `a[i] > a[i−1]` and `a[i] > a[i+1]`.
- Remove `a[i]` from the array.

Define the **score** of a permutation `p` as the **maximum number of times** that you can perform the shrink operation on `p`.

Yousef has given you a single integer `n`. Construct a permutation `p` of length `n` with the **maximum possible score**. If there are multiple answers, you can output any of them.

*A permutation of length n is an array consisting of n distinct integers from 1 to n in arbitrary order.*

## Input Format

- The first line contains an integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- Each test case contains an integer `n` (3 ≤ n ≤ 2⋅10^5) — the size of the permutation.

It is guaranteed that the sum of `n` over all test cases does not exceed 2⋅10^5.

## Output Format

For each test case, output any permutation `p1, p2, ..., pn` that maximizes the number of shrink operations.

## Examples

### Input
2  
3  
6  

### Output
1 3 2  
2 3 6 4 5 1  

## Explanation

- In the first test case:
    - One valid answer is `1 3 2`. You can remove `3` (index 2), leaving `[1, 2]`. The maximum number of shrink operations is 1. Another valid answer is `2 3 1`.
- In the second test case:
    - One valid answer is `2 3 6 4 5 1`. You can remove `5`, then `4`, then `6`, then `3`, leaving `[2, 1]`. The maximum number of shrink operations is 4. Any permutation with a score of 4 is valid.

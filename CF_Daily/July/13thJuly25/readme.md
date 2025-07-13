
# Problem: Zero Remainder Array

## Problem Description
You are given an array `a` consisting of **n positive integers**. Initially, you have an integer `x = 0`. In each move, you can perform one of the following two operations:

- **Choose exactly one index `i` (from 1 to n) and increase `a[i]` by `x` (i.e., `a[i] := a[i] + x`), then increase `x` by 1 (i.e., `x := x + 1`).** This operation can be applied **no more than once to each index**.
- **Just increase `x` by 1 (i.e., `x := x + 1`).**

Your task is to find the **minimum number of moves** required to make every element of the array divisible by `k` (i.e., for each `i`, `a[i] % k == 0`).

You have to answer **t independent test cases**.

## Input Format
- The first line contains one integer `t` — **the number of test cases**.
- For each test case:
  - The first line contains two integers `n` and `k` — **the length of the array** and **the required divisor**.
  - The second line contains `n` integers `a[1], a[2], ..., a[n]` — **the elements of the array**.

## Output Format
- For each test case, print the answer — **the minimum number of moves required** to make every element of the array divisible by `k`.

## Examples

### Input
`5`
`4 3`
`1 2 1 3`
`10 6`
`8 7 1 8 3 7 5 10 8 9`
`5 10`
`20 100 50 20 100500`
`10 25`
`24 24 24 24 24 24 24 24 24 24`
`8 8`
`1 2 3 4 5 6 7 8`
<br/>

### Output
`6`
`18`
`0`
`227`
`8`
<br/>

## Constraints
- `1 ≤ t ≤ 2⋅10^4`
- `1 ≤ n ≤ 2⋅10^5`
- `1 ≤ k ≤ 10^9`
- `1 ≤ a[i] ≤ 10^9`
- The sum of `n` over all test cases does not exceed `2⋅10^5`.

## Notes
- In each move, you can only apply the first operation to each index at most once.
- You may choose to only increase `x` in some moves without modifying the array.
- The goal is to **minimize the total number of moves** needed to make all elements divisible by `k`.


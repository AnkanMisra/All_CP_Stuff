
# Power of k in Factorial of n

## Problem Description
Given two positive integers, **n** and **k**, determine the highest value of **x** such that `k^x` divides `n!` (n factorial) completely (i.e., `n! % (k^x) == 0`).

## Input Format
- **Two positive integers:** `n` and `k`

## Output Format
- **A single integer:** The highest value of `x` such that `k^x` divides `n!` completely

## Examples

### Input
`n = 7, k = 2`<br/>

### Output
`4`<br/>

### Input
`n = 10, k = 9`<br/>

### Output
`2`<br/>

## Constraints
- `1 ≤ n ≤ 10^5`
- `2 ≤ k ≤ 10^5`

## Notes
- You need to find the largest integer `x` such that `k^x` divides `n!` without leaving a remainder.
- The value of `x` depends on the prime factorization of `k` and the number of times each prime divides `n!`.


# C. Equal Values

## Problem Statement

You are given an array `a1, a2, ..., an` of `n` integers.

In one operation, you can:
- Choose a position `i` (`1 < i ≤ n`) and make all elements to the left of `i` equal to `ai`. The cost is `(i-1) * ai`.
- Choose a position `i` (`1 ≤ i < n`) and make all elements to the right of `i` equal to `ai`. The cost is `(n-i) * ai`.

You can perform any number of operations (including zero). The elements affected by an operation may already be equal to `ai`, but the cost is still incurred.

Find the minimum total cost to make all elements of the array equal.

## Input Format

- The first line contains one integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- For each test case:
  - The first line contains a single integer `n` (2 ≤ n ≤ 5⋅10^5).
  - The second line contains `n` integers `a1, a2, ..., an` (1 ≤ ai ≤ n).

The sum of `n` over all test cases does not exceed 5⋅10^5.

## Output Format

For each test case, print a single integer — the minimum total cost to make all elements of the array equal.

## Examples

### Input
3  
4  
2 4 1 3  
3  
1 1 1  
10  
7 5 5 5 10 9 9 4 6 10  

### Output
3  
0  
35  

## Explanation

- In the first test case, you can perform the operation twice:
  - Choose `i=3` and make all elements to the left of it equal to 1, cost = 2*1 = 2.
  - Choose `i=3` and make all elements to the right of it equal to 1, cost = 1*1 = 1.
  - Total cost = 2 + 1 = 3.

- In the second test case, all elements are already equal, so the cost is 0.

- In the third test case, the minimum cost is 35.

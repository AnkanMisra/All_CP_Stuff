# B. Make It Permutation

## Problem Statement

You are given a matrix `A` of size `n × n` where `A[i, j] = j` for all `1 ≤ i, j ≤ n`.
In one operation, you can select a row and reverse any subarray within that row.

Find a sequence of at most `2n` operations such that every column will contain a permutation of length `n` (i.e., each column contains all numbers from 1 to n exactly once, in any order).

It can be proven that the construction is always possible. If there are multiple solutions, output any of them.

## Input Format

- Each test contains multiple test cases.
- The first line contains the number of test cases `t` (1 ≤ t ≤ 100).
- The first line of each test case contains one integer `n` (3 ≤ n ≤ 5000) — the number of rows and columns in the matrix.

It is guaranteed that the sum of `n` over all test cases does not exceed 5000.

## Output Format

For each test case:
- On the first line, print an integer `k` (0 ≤ k ≤ 2n), the number of operations you wish to perform.
- On the next `k` lines, print the operations.
  - To print an operation, use the format `"i l r"` (1 ≤ l ≤ r ≤ n and 1 ≤ i ≤ n) which reverses the subarray `A[i, l], A[i, l+1], ..., A[i, r]`.

## Examples

### Input
2  
3  
4  

### Output
4  
2 1 3  
2 2 3  
3 1 2  
3 2 3  
5  
2 1 4  
3 1 3  
3 2 4  
4 3 4  
4 1 2  

## Explanation

In the first test case, the initial matrix is:
1 2 3  
1 2 3  
1 2 3

The operations transform it as follows:
- **`2 1 3`**: Reverse row 2, subarray from col 1 to 3.
  Matrix becomes:
  1 2 3  
  3 2 1  
  1 2 3
- **`2 2 3`**: Reverse row 2, subarray from col 2 to 3.
  Matrix becomes:
  1 2 3  
  3 1 2  
  1 2 3
- **`3 1 2`**: Reverse row 3, subarray from col 1 to 2.
  Matrix becomes:
  1 2 3  
  3 1 2  
  2 1 3
- **`3 2 3`**: Reverse row 3, subarray from col 2 to 3.
  Matrix becomes:
  1 2 3  
  3 1 2  
  2 3 1

After these operations, every column contains a permutation of [1, 2, 3].
- Column 1: [1, 3, 2] (permutation of [1,2,3])
- Column 2: [2, 1, 3] (permutation of [1,2,3])
- Column 3: [3, 2, 1] (permutation of [1,2,3])

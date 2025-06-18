# C. Those Who Are With Us

## Constraints
- 1 ≤ t ≤ 10^4 (number of test cases)
- 1 ≤ n * m ≤ 10^5 (for each test case)
- 1 ≤ a_ij ≤ 100 (matrix elements)
- The sum of n * m across all test cases does not exceed 2 * 10^5

## Problem Statement
You are given a matrix of integers with n rows and m columns. The cell at the intersection of the i-th row and the j-th column contains the number a_ij.

You can perform the following operation exactly once:
- Choose two numbers 1 ≤ r ≤ n and 1 ≤ c ≤ m.
- For all cells (i, j) in the matrix such that i = r or j = c, decrease a_ij by one.

You need to find the minimal possible maximum value in the matrix after performing exactly one such operation.

## Input Format
- The first line contains a single integer t — the number of test cases.
- For each test case:
  - The first line contains two integers n and m — the number of rows and columns in the matrix.
  - The next n lines each contain m integers, representing the matrix.

## Output Format
- For each test case, output the minimum possible maximum value in the matrix after performing the operation.

## Example

Input:
10
1 1
1
1 2
1 2
2 1
2
1
2 2
4 2
3 4
3 4
1 2 3 2
3 2 1 3
2 1 3 2
4 3
1 5 1
3 1 3
5 5 5
3 5 1
4 4
1 3 3 2
2 3 2 2
1 2 2 1
3 3 2 3
2 2
2 2
1 2
3 2
1 2
2 1
1 2
3 3
2 1 1
1 2 1
1 1 2

Output:
0
1
1
3
2
4
3
1
1
2

## Notes

In the first three test cases, you can choose r = 1 and c = 1.

In the fourth test case, you can choose r = 1 and c = 2.

In the fifth test case, you can choose r = 2 and c = 3.

In the sixth test case, you can choose r = 3 and c = 2.

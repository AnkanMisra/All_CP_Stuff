# D. 1709

## Constraints
- 1 ≤ t ≤ 100 (number of test cases)
- 1 ≤ n ≤ 40 (length of each array)
- 1 ≤ a_i, b_i ≤ 2n
- Each integer from 1 to 2n appears in exactly one of the arrays a or b

## Problem Statement
You are given two arrays of integers a1, a2, ..., an and b1, b2, ..., bn. Each integer from 1 to 2n appears in exactly one of the arrays.

You can perform a sequence of operations (possibly zero) to make both of the following conditions true:
- For each 1 ≤ i < n, a_i < a_{i+1} and b_i < b_{i+1}
- For each 1 ≤ i ≤ n, a_i < b_i

During each operation, you can perform exactly one of the following:
- Choose an index 1 ≤ i < n and swap a_i and a_{i+1}
- Choose an index 1 ≤ i < n and swap b_i and b_{i+1}
- Choose an index 1 ≤ i ≤ n and swap a_i and b_i

You do not need to minimize the number of operations, but the total number must not exceed 1709. Find any sequence of operations that satisfies both conditions.

## Input Format
- The first line contains a single integer t — the number of test cases.
- For each test case:
  - The first line contains a single integer n — the length of the arrays.
  - The second line contains n integers a1, a2, ..., an.
  - The third line contains n integers b1, b2, ..., bn.

## Output Format
For each test case:
- Output the number of operations k (0 ≤ k ≤ 1709).
- Then output k lines, each describing an operation:
  - If you want to swap a_i and a_{i+1}, output: 1 i
  - If you want to swap b_i and b_{i+1}, output: 2 i
  - If you want to swap a_i and b_i, output: 3 i

## Example

Input:
6
1
1
2
1
2
1
2
1 3
4 2
2
1 4
3 2
3
6 5 4
3 2 1
3
5 3 4
2 6 1

Output:
0
1
3 1
1
2 1
1
3 2
9
3 1
3 2
3 3
1 1
2 1
2 2
1 2
1 1
2 1
6
2 2
1 1
1 2
2 1
3 1
3 2

## Notes

- In the first test case, a1 < b1, so no operations are needed.
- In the second test case, a1 > b1. After applying the operation, these values will be swapped.
- In the third test case, after applying the operation, a = [1, 3] and b = [2, 4].
- In the fourth test case, after applying the operation, a = [1, 2] and b = [3, 4].

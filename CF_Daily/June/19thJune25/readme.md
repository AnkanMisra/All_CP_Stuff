# C. Maximum Subarray Sum

## Constraints
- 1 ≤ t ≤ 10^4 (number of test cases)
- 1 ≤ n ≤ 2⋅10^5 (length of the array)
- 1 ≤ k ≤ 10^12
- |a_i| ≤ 10^6 for known values
- For unknown values, you may use |a_i| ≤ 10^18
- The sum of n over all test cases does not exceed 2⋅10^5

## Problem Statement
You are given an array **a** of length **n** and a positive integer **k**, but some parts of the array **a** are missing. Your task is to fill the missing parts so that the **maximum subarray sum** of **a** is exactly **k**, or report that no solution exists.

Formally, you are given:
- A binary string **s** and a partially filled array **a**,
  - If you remember the value of **a_i**, then **s_i = 1** and you are given the real value of **a_i**.
  - If you don't remember the value of **a_i**, then **s_i = 0** and you are given **a_i = 0**.

All the values that you remember satisfy |a_i| ≤ 10^6. However, you may use values up to 10^18 to fill in the values that you do not remember. It can be proven that if a solution exists, a solution also exists satisfying |a_i| ≤ 10^18.

The **maximum subarray sum** of an array **a** of length **n** is defined as max_{1 ≤ i ≤ j ≤ n} S(i, j) where S(i, j) = a_i + a_{i+1} + ... + a_j.

## Input Format
- The first line contains the number of test cases **t**.
- For each test case:
  - The first line contains two numbers **n, k**.
  - The second line contains a binary string **s** of length **n**.
  - The third line contains **n** numbers **a_1, a_2, ..., a_n** (if **s_i = 0**, then **a_i = 0**).

## Output Format
- For each test case, first output **Yes** if a solution exists or **No** if no solution exists.
- If there's at least one solution, print **n** numbers **a_1, a_2, ..., a_n** on the second line. |a_i| ≤ 10^18 must hold.

## Example

Input:
10
3 5
011
0 0 1
5 6
11011
4 -3 0 -2 1
4 4
0011
0 0 -4 -5
6 12
110111
1 2 0 5 -1 9
5 19
00000
0 0 0 0 0
5 19
11001
-8 6 0 0 -5
5 10
10101
10 0 10 0 10
1 1
1
0
3 5
111
3 -1 3
4 5
1011
-2 0 1 -5

Output:
Yes
4 0 1
Yes
4 -3 5 -2 1
Yes
2 2 -4 -5
No
Yes
5 1 9 2 2
Yes
-8 6 6 7 -5
Yes
10 -20 10 -20 10
No
Yes
3 -1 3
Yes
-2 4 1 -5

## Notes

- In test case 1, only the first position is not filled. We can fill it with 4 to get the array [4, 0, 1] which has maximum subarray sum of 5.
- In test case 2, only the third position is not filled. We can fill it with 5 to get the array [4, -3, 5, -2, 1]. Here the maximum subarray sum comes from the subarray [4, -3, 5] and it is 6, as required.
- In test case 3, the first and second positions are unfilled. We can fill both with 2 to get the array [2, 2, -4, -5] which has a maximum subarray sum of 4. Other outputs are also possible such as [0, 4, -4, -5].
- In test case 4, it is impossible to get a valid array. For example, if we filled the third position with 0, we get [1, 2, 0, 5, -1, 9], but this has a maximum subarray sum of 16, not 12 as required.

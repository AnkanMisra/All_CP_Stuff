# Square Year

## Problem Description

You are given a year represented as a 4-character string `s`. This year can have leading zeros (e.g., "0001", "0185", "1375"). The problem asks you to determine if this year can be expressed in the form $(a+b)^2$, where $a$ and $b$ are non-negative integers. If it is possible, you need to output any pair of such $a$ and $b$. Otherwise, you should report that it is impossible.

For example, if the input string is "0001", you can choose $a=0$ and $b=1$, since $(0+1)^2 = 1$.

## Input

The input starts with an integer $t$ ($1 \leq t \leq 10^4$), representing the number of test cases.
Each subsequent line contains a single test case, which is a 4-character string `s` consisting of digits '0' through '9'.

## Output

For each test case, output:
- Two non-negative integers $a$ and $b$ separated by a space, such that $(a+b)^2 = \text{year represented by } s$. If multiple pairs exist, any one is acceptable.
- Output -1 if the year cannot be expressed in the form $(a+b)^2$.

## Example

Input:

5
0001
1001
1000
4900
2025

Output:

0 1
-1
-1
34 36
20 25

## Constraints

The number of test cases $t$ is between 1 and 10,000, inclusive.
The string `s` has a length of exactly 4 characters, and each character is a digit from '0' to '9'.

# A. Mex in the Grid

## Problem Statement

You are given n^2 cards with values from 0 to n^2−1. You must arrange them in an n x n grid so that there is exactly one card in each cell.

The MEX (minimum excluded value) of a subgrid is the smallest non-negative integer that does not appear in the subgrid.

Your task is to arrange the cards such that the sum of MEX values over all possible subgrids is maximized.

A subgrid of an n x n grid is specified by four numbers l1, r1, l2, r2 (1 ≤ l1 ≤ r1 ≤ n and 1 ≤ l2 ≤ r2 ≤ n). The element in the i-th row and j-th column is part of the subgrid if and only if l1 ≤ i ≤ r1 and l2 ≤ j ≤ r2.

## Input Format

- The first line contains the number of test cases t (1 ≤ t ≤ 100).
- For each test case:
  - The first line contains a single integer n (1 ≤ n ≤ 500) — the side length of the grid.

It is guaranteed that the sum of n over all test cases does not exceed 1000.

## Output Format

For each test case, output n lines, each containing n integers representing the elements of the grid.

If there are multiple answers, you can output any of them.

## Example

### Input
2  
2  
3  

### Output
0 1  
2 3  
8 4 5  
6 0 1  
7 2 3  

## Explanation

In the first test case, one valid arrangement is:

0 1  
2 3

There are 9 subgrids in total, and the 4 of them with non-zero MEX are:
- [0] — MEX: 1
- [0, 1] — MEX: 2
- [0, 2] — MEX: 1
- [0, 1, 2, 3] — MEX: 4

The sum of MEX over all subgrids is 1 + 2 + 1 + 4 = 8, which is maximal for this case.

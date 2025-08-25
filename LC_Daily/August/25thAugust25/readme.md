
# Problem: Diagonal Traverse

## Problem Description
Given an `m x n` matrix `mat`, return **an array of all the elements** of the array in **diagonal order**.

## Input Format
- A 2D matrix `mat` of size `m x n`

## Output Format
- An integer array containing all elements traversed diagonally

## Examples

### Example 1:

![Example 1](https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg)

**Input:** `mat = [[1,2,3],[4,5,6],[7,8,9]]`<br/>

**Output:** `[1,2,4,7,5,3,6,8,9]`<br/>

### Example 2:
**Input:** `mat = [[1,2],[3,4]]`<br/>

**Output:** `[1,2,3,4]`<br/>

## Constraints
- `m == mat.length`
- `n == mat[i].length`
- **1 <= m, n <= 10^4**
- **1 <= m * n <= 10^4**
- **-10^5 <= mat[i][j] <= 10^5**


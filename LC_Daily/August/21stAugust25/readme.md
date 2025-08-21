
# Problem: Count Submatrices With All Ones

## Problem Description
Given an **m x n binary matrix** `mat`, return **the number of submatrices that have all ones**.

## Input Format
- `mat`: An **m x n binary matrix** where each element is either `0` or `1`.

## Output Format
- Return an **integer** representing the total number of submatrices that contain only `1`s.

## Examples

### Input

![ones1-grid](https://assets.leetcode.com/uploads/2021/10/27/ones1-grid.jpg)

`mat = [[1,0,1],[1,1,0],[1,1,0]]`<br/>

### Output

`13`<br/>

**Explanation:**
There are `6` rectangles of side `1x1`.
There are `2` rectangles of side `1x2`.
There are `3` rectangles of side `2x1`.
There is `1` rectangle of side `2x2`.
There is `1` rectangle of side `3x1`.
Total number of rectangles = `6 + 2 + 3 + 1 + 1 = 13`.

### Input

![ones2-grid](https://assets.leetcode.com/uploads/2021/10/27/ones2-grid.jpg)

`mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]`<br/>

### Output

`24`<br/>

**Explanation:**
There are `8` rectangles of side `1x1`.
There are `5` rectangles of side `1x2`.
There are `2` rectangles of side `1x3`.
There are `4` rectangles of side `2x1`.
There are `2` rectangles of side `2x2`.
There are `2` rectangles of side `3x1`.
There is `1` rectangle of side `3x2`.
Total number of rectangles = `8 + 5 + 2 + 4 + 2 + 2 + 1 = 24`.

## Constraints
- **1 <= m, n <= 150**
- **mat[i][j] is either 0 or 1**

## Notes
A **submatrix** is a contiguous rectangular region within the matrix. The goal is to count all possible rectangular regions that contain only `1`s.


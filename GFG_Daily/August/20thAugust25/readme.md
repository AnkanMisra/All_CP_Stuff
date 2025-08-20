
# Problem: Search in Fully Rotated Sorted 2D Matrix

## Problem Description
You are given a **2D matrix** `mat[][]` of size `n x m` that was initially filled in the following manner:
- Each row is sorted in **increasing order** from left to right.
- The **first element** of every row is **greater than the last element** of the previous row.

This implies that if the matrix is flattened row-wise, it forms a **strictly sorted 1D array**.
Later, this sorted 1D array was **rotated at some unknown pivot**. The rotated array was then written back into the matrix row-wise to form the current matrix.

Given such a matrix `mat[][]` and an integer `x`, determine whether **x exists in the matrix**.

## Input Format
- An integer `x` to search for
- A 2D matrix `mat[][]` of size `n x m`

## Output Format
- Return `true` if `x` exists in the matrix, `false` otherwise

## Examples

### Input
`x = 3`<br/>
`mat[][] = [[7, 8, 9, 10], [11, 12, 13, 1], [2, 3, 4, 5]]`<br/>

### Output
`true`<br/>
**Explanation:** `3` is located at the **3rd row and 2nd column**.

### Input
`x = 10`<br/>
`mat[][] = [[6, 7, 8], [9, 1, 2], [3, 4, 5]]`<br/>

### Output
`false`<br/>
**Explanation:** The value `10` **does not exist** in the matrix.

## Constraints
- **1 ≤ n × m ≤ 10^5**
- **1 ≤ mat[i][j], x ≤ 10^6**

## Notes
- The matrix represents a **rotated sorted array** when flattened row-wise
- Use the **rotation property** to efficiently search for the target element


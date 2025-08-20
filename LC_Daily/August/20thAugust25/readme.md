# Problem: Count Square Submatrices with All Ones

## Problem Description
Given an `m` x `n` binary matrix, count the total number of **square submatrices that contain only ones**. Every square submatrix whose all elements are `1` contributes 1 to the count regardless of its size.

## Input Format
- The first line contains two integers representing `m` and `n`, the number of rows and columns.
- The next `m` lines each contain `n` integers (`0` or `1`) separated by spaces representing the matrix elements.

## Output Format
- Print a single integer — the total number of square sub-matrices composed entirely of ones.

## Examples

### Input

`3 4`<br/>
`0 1 1 1`<br/>
`1 1 1 1`<br/>
`0 1 1 1`<br/>

### Output

`15`<br/>

### Explanation
- **10** squares of side `1`
- **4** squares of side `2`
- **1** square of side `3`
Total `= 10 + 4 + 1 = 15`.

---

### Input

`3 3`<br/>
`1 0 1`<br/>
`1 1 0`<br/>
`1 1 0`<br/>

### Output

`7`<br/>

### Explanation
- **6** squares of side `1`
- **1** square of side `2`
Total `= 6 + 1 = 7`.

## Constraints
- **1 ≤ m ≤ 300**
- **1 ≤ n ≤ 300**
- **0 ≤ matrix[i][j] ≤ 1**






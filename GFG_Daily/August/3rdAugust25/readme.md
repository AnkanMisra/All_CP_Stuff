
# Problem: 2D Difference Array

## Problem Description
You are given a **2D integer matrix** `mat[][]` of size `n × m` and a list of `q` **operations** `opr[][]`. Each operation is represented as an array `[v, r1, c1, r2, c2]`, where:
- `v` is the **value to be added**
- `(r1, c1)` is the **top-left cell** of a submatrix
- `(r2, c2)` is the **bottom-right cell** of the submatrix (inclusive)

For each of the `q` operations, **add** `v` **to every element** in the submatrix from `(r1, c1)` to `(r2, c2)`. Return the **final matrix** after applying all operations.

## Input Format
- First line contains the **2D matrix** `mat[][]` of size `n × m`
- Second line contains the **operations array** `opr[][]` where each operation is `[v, r1, c1, r2, c2]`

## Output Format
Return the **final matrix** after applying all the given operations.

## Examples

### Input

`mat[][] = [[1, 2, 3], [1, 1, 0], [4, -2, 2]]`<br/>
`opr[][] = [[2, 0, 0, 1, 1], [-1, 1, 0, 2, 2]]`<br/>

### Output

`[[3, 4, 3], [2, 2, -1], [3, -3, 1]]`<br/>

## Constraints
- **1 ≤ n×m, q ≤ 10^5**
- **0 ≤ r1 ≤ r2 ≤ n - 1**
- **0 ≤ c1 ≤ c2 ≤ m - 1**
- **-10^4 ≤ mat[i][j], v ≤ 10^4**

## Notes
This problem involves efficiently applying **range updates** on a 2D matrix. The key insight is to use a **2D difference array** technique to handle multiple range updates efficiently rather than updating each cell individually for every operation.


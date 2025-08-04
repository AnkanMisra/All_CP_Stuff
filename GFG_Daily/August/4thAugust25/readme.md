
# Problem: Maximum Sum Rectangle

## Problem Description
Given a **2D matrix** `mat[][]` with dimensions `n×m`, find the **maximum possible sum** of any submatrix within the given matrix.

## Input Format

- A 2D matrix `mat[][]` with dimensions `n×m`
- Each element `mat[i][j]` represents an integer value in the matrix

## Output Format

- Return the **maximum sum** of any submatrix within the given matrix

## Examples

### Example 1
**Input:** `mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3], [-4, -1, 1, 7, -6]]`<br/>
**Output:** `29`<br/>

**Explanation:** The matrix contains a submatrix with **maximum sum equal to 29**.

### Example 2
**Input:** `mat[][] = [[-1, -2], [-3, -4]]`<br/>
**Output:** `-1`<br/>

**Explanation:** Taking only the **first cell** is the optimal choice when all elements are negative.

## Constraints
- `1 ≤ n, m ≤ 300`
- `-1000 ≤ mat[i][j] ≤ 1000`


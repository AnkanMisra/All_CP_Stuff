# Find Rectangle with Corners as 1

Given an `n x m` binary matrix `mat[][]` containing only 0s and 1s, determine if there exists a rectangle within the matrix such that all four corners of the rectangle are 1. If such a rectangle exists, return `true`; otherwise, return `false`.

---

## Examples

### Example 1

**Input:**  
mat[][] =  
[[1, 0, 0, 1, 0],  
 [0, 0, 1, 0, 1],  
 [0, 0, 0, 1, 0],  
 [1, 0, 1, 0, 1]]

**Output:**  
true

**Explanation:**  
Valid corners are at index (1,2), (1,4), (3,2), (3,4).

---

### Example 2

**Input:**  
mat[][] =  
[[0, 0, 0],  
 [0, 0, 0],  
 [0, 0, 0]]

**Output:**  
false

**Explanation:**  
There are no valid corners.

---

## Constraints

- 1 <= n, m <= 200
- 0 <= mat[i] <= 1

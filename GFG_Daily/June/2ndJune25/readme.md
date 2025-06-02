# Unique Paths in a Grid

You are given a 2d list `grid[][]` of size `n x m` consisting of values 0 and 1.

- A value of 0 means that you can enter that cell.
- A value of 1 implies that entry to that cell is not allowed.

You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m) such that you can only move in the right or down direction from every cell.

Your task is to calculate the total number of ways of reaching the target.

**Note:** The first (1, 1) and last (n, m) cell of the grid can also be 1.  
It is guaranteed that the total number of ways will fit within a 32-bit integer.

---

## Examples

### Example 1

**Input:**  
n = 3, m = 3  
grid = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]

**Output:**  
2

**Explanation:**  
There are two ways to reach the bottom-right corner:  
1. Right -> Right -> Down -> Down  
2. Down -> Down -> Right -> Right

---

### Example 2

**Input:**  
n = 1, m = 3  
grid = [[1, 0, 1]]

**Output:**  
0

**Explanation:**  
There is no possible path to reach the end.

---

## Constraints

- 1 ≤ n*m ≤ 10^6

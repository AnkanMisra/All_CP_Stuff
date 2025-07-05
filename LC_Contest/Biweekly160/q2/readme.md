# Problem: Minimum Cost Path with Alternating Directions II

## Problem Description
You are given two integers, **`m`** and **`n`**, representing the number of rows and columns of a grid, respectively.

- The **cost to enter cell** `(i, j)` is **`(i + 1) * (j + 1)`**.
- You are also given a 2D integer array **`waitCost`** where **`waitCost[i][j]`** defines the cost to **wait** on that cell.
- You **start at cell** `(0, 0)` at **second 1**.
- At each step, you follow an **alternating pattern**:
  - On **odd-numbered seconds**, you must **move right or down** to an adjacent cell, paying its entry cost.
  - On **even-numbered seconds**, you must **wait in place**, paying `waitCost[i][j]`.

Your task is to **return the minimum total cost required to reach** `(m - 1, n - 1)`.

## Input Format
- **`m`**: number of rows
- **`n`**: number of columns
- **`waitCost`**: a 2D array of size `m x n`, where `waitCost[i][j]` is the cost to wait at cell `(i, j)`

## Output Format
- **Output:** The **minimum total cost** required to reach cell `(m - 1, n - 1)`

## Examples

### Input
m = 1, n = 2, waitCost = `[[1,2]]`<br/>

### Output
`3`<br/>

### Input
m = 2, n = 2, waitCost = `[[3,5],[2,4]]`<br/>

### Output
`9`<br/>

### Input
m = 2, n = 3, waitCost = `[[6,1,4],[3,2,5]]`<br/>

### Output
`16`<br/>

## Constraints
- **`1 <= m, n <= 10^5`**
- **`2 <= m * n <= 10^5`**
- **`waitCost.length == m`**
- **`waitCost[0].length == n`**
- **`0 <= waitCost[i][j] <= 10^5`**

## Notes
- You must alternate between moving (right or down) and waiting, starting with a move at second 1.
- The cost to enter a cell is always paid when you move into it.
- The cost to wait is only paid when you stay in the same cell on an even-numbered second.


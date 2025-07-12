
# Gold Mine Problem

## Problem Description
You are given a gold mine represented as a 2D array `mat[][]`. Each cell in this mine contains a positive integer representing the amount of gold in tons. A miner can start from **any row in the first column**. From a given cell, the miner can move to:
- The cell **diagonally up towards the right**
- The cell **directly to the right**
- The cell **diagonally down towards the right**

The miner collects the gold from each cell he visits. **Find the maximum amount of gold the miner can collect until he can no longer move.**

## Input Format
- The first line contains two integers: `n` (number of rows) and `m` (number of columns).
- The next `n` lines each contain `m` space-separated integers, where each integer represents `mat[i][j]`, the amount of gold in the cell at row `i` and column `j`.

## Output Format
- Print a single integer: the **maximum amount of gold** that can be collected.

## Examples

### Input
`mat[][] = [[1, 3, 3], [2, 1, 4], [0, 6, 4]]`<br/>

### Output
`12`<br/>

**Explanation:** The path is `(1, 0) -> (2, 1) -> (2, 2)`. Total gold collected is `2 + 6 + 4 = 12`.

### Input
`mat[][] = [[1, 3, 1, 5], [2, 2, 4, 1], [5, 0, 2, 3], [0, 6, 1, 2]]`<br/>

### Output
`16`<br/>

**Explanation:** The path is `(2, 0) -> (3, 1) -> (2, 2) -> (2, 3)` or `(2, 0) -> (1, 1) -> (1, 2) -> (0, 3)`.<br/>
Total gold collected is `(5 + 6 + 2 + 3)` or `(5 + 2 + 4 + 5) = 16`.

### Input
`mat[][] = [[1, 3, 3], [2, 1, 4], [0, 7, 5]]`<br/>

### Output
`14`<br/>

**Explanation:** The path is `(1, 0) -> (2, 1) -> (2, 2)`. Total gold collected is `2 + 7 + 5 = 14`.

## Constraints
- **1 ≤ n, m ≤ 500**
- **0 ≤ mat[i][j] ≤ 100**


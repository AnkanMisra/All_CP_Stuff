
# Problem: Find the Minimum Area to Cover All Ones I

## Problem Description
You are given a 2D binary array `grid`. You must find an axis-aligned rectangle of **minimum possible area** such that **all the cells containing 1** lie inside it. Return that area.

## Input Format
- A 2D array `grid` of size `m × n` where `1 ≤ m, n ≤ 1000`.
- Each element `grid[i][j]` is either `0` or `1`.

## Output Format
- A single integer — the minimum possible area of a rectangle that covers every `1` in `grid`.

## Examples

### Example 1
**Input:** <br/>

`grid = [[0,1,0],[1,0,1]]`<br/>

**Output:** <br/>

`6`<br/>

**Explanation:**

![Example 1](https://assets.leetcode.com/uploads/2024/05/08/examplerect0.png)

The smallest rectangle has **height 2** and **width 3**, so its area is **2 * 3 = 6**.

### Example 2
**Input:** <br/>

`grid = [[1,0],[0,0]]`<br/>

**Output:** <br/>

`1`<br/>

**Explanation:**

![Example 2](https://assets.leetcode.com/uploads/2024/05/08/examplerect1.png)

The smallest rectangle has **height 1** and **width 1**, so the area is **1 * 1 = 1**.

## Constraints
- **1 ≤ grid.length, grid[i].length ≤ 1000**
- `grid[i][j]` is `0` or `1`.
- The input contains **at least one `1`**.



# Problem: Find the Minimum Area to Cover All Ones II

## Problem Description
You are given a **2D binary array** `grid`. You need to find **3 non-overlapping rectangles** having **non-zero areas** with horizontal and vertical sides such that **all the 1's in grid lie inside these rectangles**.

Return the **minimum possible sum of the area** of these rectangles.

**Note** that the rectangles are allowed to touch.

## Input Format
- `grid`: A 2D binary array where `grid[i][j]` is either `0` or `1`

## Output Format
- Return an integer representing the **minimum possible sum of the area** of the 3 rectangles

## Examples

### Example 1:

![Example 1](https://assets.leetcode.com/uploads/2024/05/14/example0rect21.png)

**Input:** `grid = [[1,0,1],[1,1,1]]`<br/>

**Output:** `5`<br/>

**Explanation:**
- The 1's at `(0, 0)` and `(1, 0)` are covered by a rectangle of area `2`
- The 1's at `(0, 2)` and `(1, 2)` are covered by a rectangle of area `2`
- The 1 at `(1, 1)` is covered by a rectangle of area `1`
- Total area = `2 + 2 + 1 = 5`

### Example 2:

![Example 2](https://assets.leetcode.com/uploads/2024/05/14/example1rect2.png)

**Input:** `grid = [[1,0,1,0],[0,1,0,1]]`<br/>

**Output:** `5`<br/>

**Explanation:**
- The 1's at `(0, 0)` and `(0, 2)` are covered by a rectangle of area `3`
- The 1 at `(1, 1)` is covered by a rectangle of area `1`
- The 1 at `(1, 3)` is covered by a rectangle of area `1`
- Total area = `3 + 1 + 1 = 5`

## Constraints
- `1 <= grid.length, grid[i].length <= 30`
- `grid[i][j]` is either `0` or `1`
- The input is generated such that there are **at least three 1's** in `grid`

## Notes
- The rectangles must be **non-overlapping** but are allowed to touch
- Each rectangle must have a **non-zero area**
- All 1's in the grid must be covered by exactly one of the three rectangles


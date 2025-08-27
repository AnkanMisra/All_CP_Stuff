
# Problem: Length of Longest V-Shaped Diagonal Segment

## Problem Description
You are given a **2D integer matrix** `grid` of size `n x m`, where each element is either `0`, `1`, or `2`.

A **V-shaped diagonal segment** is defined as:
- The segment **starts with** `1`
- The subsequent elements follow this **infinite sequence**: `2, 0, 2, 0, ...`
- The segment:
  - Starts along a **diagonal direction** (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right)
  - Continues the sequence in the **same diagonal direction**
  - Makes **at most one clockwise 90-degree turn** to another diagonal direction while **maintaining the sequence**

![length_of_longest3.jpg](https://assets.leetcode.com/uploads/2025/01/11/length_of_longest3.jpg)

Return the **length of the longest V-shaped diagonal segment**. If **no valid segment exists**, return `0`.

## Input Format

- A 2D integer matrix `grid` of size `n x m`
- Each element `grid[i][j]` is either `0`, `1`, or `2`

## Output Format

- An integer representing the **length of the longest V-shaped diagonal segment**
- Return `0` if no valid segment exists

## Examples

### Example 1
**Input:** `grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]`<br/>
**Output:** `5`<br/>

![matrix_1-2.jpg](https://assets.leetcode.com/uploads/2024/12/09/matrix_1-2.jpg)

**Explanation:** The longest V-shaped diagonal segment has a length of `5` and follows these coordinates: `(0,2) → (1,3) → (2,4)`, takes a **90-degree clockwise turn** at `(2,4)`, and continues as `(3,3) → (4,2)`.

### Example 2
**Input:** `grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]`<br/>
**Output:** `4`<br/>

![matrix_2.jpg](https://assets.leetcode.com/uploads/2024/12/09/matrix_2.jpg)

**Explanation:** The longest V-shaped diagonal segment has a length of `4` and follows these coordinates: `(2,3) → (3,2)`, takes a **90-degree clockwise turn** at `(3,2)`, and continues as `(2,1) → (1,0)`.

### Example 3
**Input:** `grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]`<br/>
**Output:** `5`<br/>

![matrix_3.jpg](https://assets.leetcode.com/uploads/2024/12/09/matrix_3.jpg)

**Explanation:** The longest V-shaped diagonal segment has a length of `5` and follows these coordinates: `(0,0) → (1,1) → (2,2) → (3,3) → (4,4)`.

### Example 4
**Input:** `grid = [[1]]`<br/>
**Output:** `1`<br/>

**Explanation:** The longest V-shaped diagonal segment has a length of `1` and follows these coordinates: `(0,0)`.

## Constraints
- `n == grid.length`
- `m == grid[i].length`
- **1 <= n, m <= 500**
- `grid[i][j]` is either **0, 1, or 2**


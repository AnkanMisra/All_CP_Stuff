# 3443. Maximum Manhattan Distance After K Changes

## Constraints
- 1 ≤ s.length ≤ 10^5
- 0 ≤ k ≤ s.length
- s consists of only 'N', 'S', 'E', and 'W'

## Problem Statement
You are given a string **s** consisting of the characters 'N', 'S', 'E', and 'W', where **s[i]** indicates movements in an infinite grid:
- 'N' : Move north by 1 unit.
- 'S' : Move south by 1 unit.
- 'E' : Move east by 1 unit.
- 'W' : Move west by 1 unit.

Initially, you are at the origin (0, 0). You can change at most **k** characters to any of the four directions.

Find the **maximum Manhattan distance** from the origin that can be achieved at any time while performing the movements in order.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

## Input Format
- A string **s** of length n.
- An integer **k**.

## Output Format
- An integer representing the maximum Manhattan distance from the origin that can be achieved at any time.

## Examples

**Example 1:**

Input:  
s = "NWSE", k = 1

Output:  
3

Explanation:  
Change s[2] from 'S' to 'N'. The string s becomes "NWNE".

| Step | Movement | Position (x, y) | Manhattan Distance | Maximum |
|------|----------|-----------------|-------------------|---------|
| 0    | 'N'      | (0, 1)          | 1                 | 1       |
| 1    | 'W'      | (-1, 1)         | 2                 | 2       |
| 2    | 'N'      | (-1, 2)         | 3                 | 3       |
| 3    | 'E'      | (0, 2)          | 2                 | 3       |

The maximum Manhattan distance from the origin that can be achieved is 3.

**Example 2:**

Input:  
s = "NSWWEW", k = 3

Output:  
6

Explanation:  
Change s[1] from 'S' to 'N', and s[4] from 'E' to 'W'. The string s becomes "NNWWWW".

The maximum Manhattan distance from the origin that can be achieved is 6.

# Codeforces 1038 Div2 - Problem A: Greedy Grid

## Problem Statement

A path in a grid is called greedy if it starts at the top-left cell and moves only to the right or downward, always moving to its neighbor with the greater value (or either if the values are equal).

The value of a path is the sum of the values of the cells it visits, including the start and end.

Does there exist an n × m grid of nonnegative integers such that no greedy path achieves the maximum value among all down/right paths?

## Input
- First line: number of test cases t (1 ≤ t ≤ 5000)
- Each test case: two integers n, m (1 ≤ n, m ≤ 100)

## Output
For each test case, output "YES" if the required grid exists, "NO" otherwise.

## Example
```
Input:
2
3 3
1 2

Output:
 YES
 NO
```

## Solution Approach

The key insight is that we need enough "room" in the grid to create a situation where:
1. A greedy path gets trapped by locally optimal choices
2. A non-greedy path can achieve a higher total sum

This is impossible when:
- n=1 or m=1: Only one path exists
- n=2 and m=2: All paths are essentially the same

For all other cases, we can construct such a grid.
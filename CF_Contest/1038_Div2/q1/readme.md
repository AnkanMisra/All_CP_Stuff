# Problem: Greedy Grid

## Problem Description
Given an `n × m` grid of **nonnegative integers**, a path is called **greedy** if it starts at the **top-left cell** and moves only **right** or **downward**, always moving to its neighbor with the **greater value** (or either if the values are equal). The value of a path is the **sum of the values of the cells it visits**, including the start and end.

Does there exist an `n × m` grid such that **no greedy path achieves the maximum value among all down/right paths**?

## Input Format
- The first line contains a single integer `t` — **the number of test cases** (`1 ≤ t ≤ 5000`).
- Each of the next `t` lines contains two integers `n` and `m` (`1 ≤ n, m ≤ 100`) — **the number of rows and columns** in the grid for that test case.

## Output Format
- For each test case, output `YES` if such a grid exists, or `NO` otherwise, on a separate line.
- You may print each letter in any case (e.g., `YES`, `Yes`, `yes`).

## Examples

### Input

2
3 3
1 2
<br/>

### Output

YES
NO
<br/>

## Constraints
- `1 ≤ t ≤ 5000`
- `1 ≤ n, m ≤ 100`

## Notes
In the **first test case**, an example of a grid in which no greedy path achieves the maximum value out of all down/right paths is:

325
514
123

Let `a_{i,j}` denote the value of the cell in the `i`-th row and `j`-th column. The maximum value of a down/right path is `a_{1,1} + a_{2,1} + a_{3,1} + a_{3,2} + a_{3,3} = 3 + 5 + 1 + 2 + 3 = 14`. This path is **not greedy** because `a_{1,2}` is greater than `a_{2,1}`; thus, a greedy path must move right in the first step. The maximum value of a greedy path is `a_{1,1} + a_{1,2} + a_{2,2} + a_{3,2} + a_{3,3} = 3 + 2 + 1 + 2 + 3 = 11`.

In the **second test case**, it can be proven that **no grid** satisfies the conditions.


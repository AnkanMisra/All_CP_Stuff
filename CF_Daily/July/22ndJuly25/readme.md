
# Problem: Woodcutters

## Problem Description
Little Susie listens to fairy tales before bed every day. Today's fairy tale was about woodcutters, and she imagined the following situation:

There are **n trees** located along a road at points with coordinates `x_1, x_2, ..., x_n`. Each tree has a height `h_i`. Woodcutters can cut down a tree and fell it to the **left** or **right**. After felling, the tree occupies one of the segments `[x_i - h_i, x_i]` (left) or `[x_i, x_i + h_i]` (right). A tree that is not cut down occupies a single point at `x_i`.

A tree can be felled **only if** the segment it would occupy does **not contain any occupied point**. The goal is to **maximize the number of trees that can be felled**.

## Input Format
- The first line contains an integer `n` (**1 ≤ n ≤ 10^5**) — the number of trees.
- The next `n` lines each contain two integers `x_i` and `h_i` (**1 ≤ x_i, h_i ≤ 10^9**) — the coordinate and height of the `i`-th tree.
- The pairs are given in order of **ascending `x_i`**. No two trees have the same coordinate.

## Output Format
- Print a single integer — the **maximum number of trees** that can be cut down by the given rules.

## Examples

### Input

5
1 2
2 1
5 10
10 9
19 1
<br/>

### Output

3
<br/>

### Input

5
1 2
2 1
5 10
10 9
20 1
<br/>

### Output

4
<br/>

## Constraints
- `1 ≤ n ≤ 10^5`
- `1 ≤ x_i, h_i ≤ 10^9`
- All `x_i` are distinct and sorted in ascending order.

## Notes
- In the first sample, you can fell the 1st tree to the left, the 2nd tree to the right, leave the 3rd and 4th trees standing, and fell the 5th tree to the right.
- In the second sample, you can also fell the 4th tree to the right, as it will occupy `[10, 19]`.


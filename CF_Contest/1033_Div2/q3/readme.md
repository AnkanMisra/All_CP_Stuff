# Problem: C. Divine Tree

## Problem Description

Harshith attained enlightenment in Competitive Programming by training under a Divine Tree. A divine tree is a rooted tree* with `n` nodes, labelled from 1 to `n`. The divineness of a node `v`, denoted `d(v)`, is defined as the smallest node label on the unique simple path from the root to node `v`.

Aryan, being a hungry Competitive Programmer, asked Harshith to pass on the knowledge. Harshith agreed on the condition that Aryan would be given two positive integers `n` and `m`, and he had to construct a divine tree with `n` nodes such that the total divineness of the tree is `m`, i.e.,

```d(1) + d(2) + ... + d(n) = m```

If no such tree exists, Aryan must report that it is impossible.

> *A tree is a connected graph without cycles. A rooted tree is a tree where one vertex is special and called the root.*

## Input Format

- The first line contains the number of test cases `t` (1 ≤ t ≤ 10⁴).
- For each test case:
  - The first line contains two integers `n` and `m` (1 ≤ n ≤ 10⁶, 1 ≤ m ≤ 10¹²).

It is guaranteed that the sum of `n` over all test cases does not exceed 10⁶.

## Output Format

For each test case:
- Output a single integer `k` in one line — the root of the tree, or `-1` if there is no solution.
- Then, if there is a solution, output `n - 1` lines, each containing a description of an edge of the tree — a pair of positive integers `ui`, `vi` (1 ≤ ui, vi ≤ n, ui ≠ vi), denoting the i-th edge connects vertices `ui` and `vi`.
- The edges and vertices of the edges can be printed in any order. If there are multiple solutions, print any of them.

If there is no solution, print `-1` instead.

## Examples

### Input
2<br />
1 2<br />
4 6<br />

### Output
-1<br />
3<br />
3 1<br />
1 2<br />
2 4<br />

## Notes

- In the first test case, there is a single node with a value of 1, so getting a sum of 2 is impossible.
- In the second test case, getting a sum of 6 is possible with the given tree rooted at 3.

## Constraints

- 1 ≤ t ≤ 10⁴
- 1 ≤ n ≤ 10⁶
- 1 ≤ m ≤ 10¹²
- The sum of n over all test cases does not exceed 10⁶.
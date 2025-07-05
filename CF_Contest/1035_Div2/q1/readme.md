# Problem: Add or XOR

## Problem Description
You are given two non-negative integers, **a** and **b**. You can perform the following two operations on **a** any number of times and in any order:
- **Add 1:** Set `a = a + 1`. The cost of this operation is **x**.
- **XOR 1:** Set `a = a ⊕ 1` (where ⊕ denotes the bitwise XOR operation). The cost of this operation is **y**.

Your goal is to make `a = b` using these operations. If it is possible, output the **minimum total cost** required. If it is impossible, output `-1`.

## Input Format
- The first line contains an integer `t` — the number of test cases.
- Each test case consists of a single line containing four integers: `a`, `b`, `x`, `y` — the two integers and the respective costs of the two operations.

## Output Format
- For each test case, output a single integer — the minimum cost to make `a = b`, or `-1` if it is impossible.

## Examples

### Input
7<br/>
1 4 1 2<br/>
1 5 2 1<br/>
3 2 2 1<br/>
1 3 2 1<br/>
2 1 1 2<br/>
3 1 1 2<br/>
1 100 10000000 10000000<br/>

### Output
3<br/>
6<br/>
1<br/>
3<br/>
-1<br/>
-1<br/>
990000000<br/>

## Constraints
- `1 ≤ t ≤ 10000`
- `1 ≤ a, b ≤ 100`
- `1 ≤ x, y ≤ 10000000`

## Notes
- In the first test case, the optimal strategy is to apply `a = a + 1` three times. The total cost is `1 + 1 + 1 = 3`.
- In the second test case, the optimal strategy is to apply `a = a + 1`, `a = a ⊕ 1`, `a = a + 1`, `a = a ⊕ 1` in order. The total cost is `2 + 1 + 2 + 1 = 6`.
- In the fifth and sixth test cases, it is impossible to make `a = b` using the allowed operations.
- In the last test case, the only way is to apply `a = a + 1` ninety-nine times, each costing `10000000`.



# Problem: Manhattan Pairs

## Problem Description
You are given **n points** (`(x_i, y_i)`) on a 2D plane, where **n is even**. Your task is to **select n/2 disjoint pairs** `(a_i, b_i)` of these points to **maximize the sum of Manhattan distances** between the points in each pair. In other words, maximize:

**Sum =** `|x_{a_1} - x_{b_1}| + |y_{a_1} - y_{b_1}| + ... + |x_{a_{n/2}} - x_{b_{n/2}}| + |y_{a_{n/2}} - y_{b_{n/2}}|`

If there are multiple solutions, you can print any of them.

## Input Format
- The first line contains a single integer `t` — **the number of test cases**.
- For each test case:
  - The first line contains a single even integer `n` — **the number of points**.
  - The next `n` lines each contain two integers `x_i` and `y_i` — **the coordinates of the i-th point**.

## Output Format
- For each test case, output `n/2` lines.
- Each line should contain two integers `a_i` and `b_i` — **the indices of the points in the i-th pair**.
- Each point must appear in exactly one pair.
- If there are multiple solutions, print any of them.

## Constraints
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 2⋅10^5` (**n is even**)
- `-10^6 ≤ x_i, y_i ≤ 10^6`
- The sum of `n` over all test cases does not exceed `2⋅10^5`

## Examples

### Input

2<br/>
4<br/>
1 1<br/>
3 0<br/>
4 2<br/>
3 4<br/>
10<br/>
-1 -1<br/>
-1 2<br/>
-2 -2<br/>
-2 0<br/>
0 2<br/>
2 -3<br/>
-4 -4<br/>
-4 -2<br/>
0 1<br/>
-4 -2<br/>

### Output

4 1<br/>
2 3<br/>
8 1<br/>
9 10<br/>
7 5<br/>
2 3<br/>
6 4<br/>

## Notes
- In the first test case, an optimal solution is to select the pairs `(1, 4)` and `(2, 3)`, which achieves a distance sum of `5 + 3 = 8`.
- In the second test case, an optimal solution is to select the pairs `(1, 8)`, `(9, 10)`, `(5, 7)`, `(2, 3)`, `(4, 6)`, which achieves a distance sum of `4 + 7 + 10 + 5 + 7 = 33`.


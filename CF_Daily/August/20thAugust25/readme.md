
# Problem: Array Walk

## Problem Description
You are given an array `a1, a2, …, an` of **n positive integers**. You start at index **1** with an initial score equal to `a1`. You must make **exactly k moves** using the following rules:
- **Move right:** From index `x` go to `x + 1` (allowed only if `x < n`) and add `a_{x+1}` to your score.
- **Move left:** From index `x` go to `x − 1` (allowed only if `x > 1`) and add `a_{x−1}` to your score. You **cannot** move left twice in a row.

You may use **at most z left moves** in total. Calculate the **maximum score** achievable after exactly **k moves**.

## Input Format
- **t** — number of test cases.
- For each test case:
  - **n k z** — number of elements, total moves, maximum left moves.
  - **n integers** — the array values `a1 … an`.

## Output Format
For each test case output a single integer: the maximum score obtainable.

## Examples

### Input

```
4
5 4 0
1 5 4 3 2
5 4 1
1 5 4 3 2
5 4 4
10 20 30 40 50
10 7 3
4 6 8 2 9 9 7 4 10 9
```

### Output


```
15
19
150
56
```

## Constraints
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 10^5`
- `1 ≤ k ≤ n − 1`
- `0 ≤ z ≤ min(5, k)`
- `1 ≤ ai ≤ 10^4`
- The sum of `n` over all test cases ≤ `3·10^5`

## Notes
- In the first sample **no left moves** are allowed, so you go right four times: score = `a1 + a2 + a3 + a4 + a5 = 15`.
- In the second sample one left move is used: right, right, left, right → score `a1 + a2 + a3 + a2 + a3 = 19`.
- In the third sample, despite `z = 4`, the optimal strategy is moving right only, giving `150`.
- The fourth sample illustrates mixing right and left moves within the limits to achieve the maximum `56`.




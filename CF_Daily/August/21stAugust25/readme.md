# Problem: k-LCM (Hard Version)

## Problem Description
You are given two positive integers `n` and `k`. Your task is to find **k positive integers** `a1, a2, …, ak` such that
* `a1 + a2 + … + ak = n`
* **LCM** (`a1, a2, …, ak`) ≤ `n²`

It is guaranteed that a solution exists for the given constraints.

## Input Format
* **The first line** contains an integer `t` — the number of test cases.
* **Each of the next `t` lines** contains two integers `n` and `k` (`3 ≤ n ≤ 10⁹`, `3 ≤ k ≤ n`).

## Output Format
For every test case, output **k positive integers** that satisfy the above conditions. The numbers may be printed in any order. If multiple valid answers exist, print any of them.

## Examples

### Input

`2`
`6 4`
`9 5`  <br/>

### Output

`1 2 2 1`
`1 3 3 1 1`  <br/>

## Constraints
* `1 ≤ t ≤ 10⁴`
* `3 ≤ n ≤ 10⁹`
* `3 ≤ k ≤ n`
* The total sum of all `k` over all test cases does not exceed `10⁵`.

## Notes
*The sample demonstrates one valid distribution for each test case; other correct answers are possible.*



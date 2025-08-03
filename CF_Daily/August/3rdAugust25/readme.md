
# Problem: Minimize Fixed Points

## Problem Description
Call a permutation `p` of length `n` **good** if `gcd(p_i, i) > 1` for all `2 ≤ i ≤ n`. Find a **good permutation with the minimum number of fixed points** across all good permutations of length `n`. If there are multiple such permutations, print any of them.

**Definitions:**
- A **permutation** of length `n` is an array that contains every integer from `1` to `n` exactly once, in any order.
- `gcd(x, y)` denotes the **greatest common divisor (GCD)** of `x` and `y`.
- A **fixed point** of a permutation `p` is an index `j` (`1 ≤ j ≤ n`) such that `p_j = j`.

## Input Format

The first line contains an integer `t` (`1 ≤ t ≤ 10^4`) — the **number of test cases**.

The only line of each test case contains an integer `n` (`2 ≤ n ≤ 10^5`) — the **length of the permutation**.

## Output Format

For each test case, output on a single line an example of a **good permutation** of length `n` with the **minimum number of fixed points**.

## Examples

### Input
`4`<br/>
`2`<br/>
`3`<br/>
`6`<br/>
`13`<br/>

### Output
`1 2`<br/>
`1 2 3`<br/>
`1 4 6 2 5 3`<br/>
`1 12 9 6 10 8 7 4 3 5 11 2 13`<br/>

## Constraints
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 10^5`
- It is guaranteed that the **sum of n over all test cases** does not exceed `10^5`.

## Notes
In the third sample, we construct the permutation:

| i | p_i | gcd(p_i, i) |
|---|-----|-------------|
| 1 | 1   | 1           |
| 2 | 4   | 2           |
| 3 | 6   | 3           |
| 4 | 2   | 2           |
| 5 | 5   | 5           |
| 6 | 3   | 3           |

We see that `gcd(p_i, i) > 1` for all `2 ≤ i ≤ 6`. Furthermore, there are only **two fixed points**, namely `1` and `5`. It can be shown that it is **impossible to build a good permutation** of length `6` with fewer fixed points.




# Row GCD

## Problem Description
You are given two **positive integer sequences** `a1, a2, …, an` and `b1, b2, …, bm`. For each value `bj` you must find the **greatest common divisor** (GCD) of the numbers `a1 + bj, a2 + bj, …, an + bj`.

## Input Format
- The first line contains two integers **n** and **m** — the lengths of the sequences (`1 ≤ n, m ≤ 2⋅10^5`).
- The second line contains **n** integers `a1, a2, …, an` (`1 ≤ ai ≤ 10^18`).
- The third line contains **m** integers `b1, b2, …, bm` (`1 ≤ bj ≤ 10^18`).

## Output Format
Print **m** integers separated by spaces. The `j`-th integer must be `GCD(a1 + bj, a2 + bj, …, an + bj)`.

## Examples

### Example 1
**Input**
`4 4`
`1 25 121 169`
`1 2 7 23`
<br/>

**Output**
`2 3 8 24`
<br/>

### Example 2
**Input**
`3 2`
`6 10 14`
`2 4`
<br/>

**Output**
`4 2`
<br/>

## Constraints
- `1 ≤ n, m ≤ 2⋅10^5`
- `1 ≤ ai, bj ≤ 10^18`

## Notes
For each query value `bj`, the task asks for the GCD of the entire row after adding `bj` to every element of `a`. Computing this efficiently requires using properties of the GCD function rather than recomputing from scratch for every query.




# Problem: k-Tree

## Problem Description
A **k-tree** is an infinite rooted tree where:
- Each vertex has exactly **k children**
- Each edge has some weight
- If we look at the edges that go from some vertex to its children (exactly k edges), then their weights will equal `1, 2, 3, ..., k`

The problem asks: **How many paths of total weight `n`** (the sum of all weights of the edges in the path) are there, starting from the root of a k-tree and also **containing at least one edge of weight at least `d`**?


![k-Tree Example](https://espresso.codeforces.com/5f44e910ac6f25b7db3084c9a710bdc243bed406.png)


## Input Format

A single line contains three space-separated integers: `n`, `k` and `d`

## Output Format

Print a single integer — the answer to the problem modulo `1000000007` (`10^9 + 7`)

## Examples

### Input
`3 3 2`<br/>

### Output
`3`<br/>

### Input
`3 3 3`<br/>

### Output
`1`<br/>

### Input
`4 3 2`<br/>

### Output
`6`<br/>

### Input
`4 5 2`<br/>

### Output
`7`<br/>

## Constraints
- `1 ≤ n, k ≤ 100`
- `1 ≤ d ≤ k`

## Notes
The answer should be calculated modulo `1000000007` (`10^9 + 7`) as the number of ways can be rather large.



# Problem: Count the Coprimes

## Problem Description
Given an array `arr[]` of positive integers, your task is to **count the number of unordered pairs** `(i, j)` such that:
- `0 ≤ i < j ≤ n-1`
- `gcd(arr[i], arr[j]) = 1`

In other words, count the number of unordered pairs of indices `(i, j)` where the elements at those positions are **co-prime**.

## Input Format
- **The first line contains an integer** `n` — the size of the array.
- **The second line contains** `n` **space-separated positive integers** — the elements of the array `arr[]`.

## Output Format
- **Print a single integer** — the number of unordered pairs `(i, j)` such that `gcd(arr[i], arr[j]) = 1`.

## Examples

### Input

`3`
`1 2 3`<br/>

### Output

`3`<br/>

**Explanation:** `(0,1)`, `(0,2)`, `(1,2)` are the pairs where `gcd(arr[i], arr[j]) = 1`.

### Input

`4`
`4 8 3 9`<br/>

### Output

`4`<br/>

**Explanation:** `(0,2)`, `(0,3)`, `(1,2)`, `(1,3)` are the pairs where `gcd(arr[i], arr[j]) = 1`.

## Constraints
- `2 ≤ n ≤ 10000`
- `1 ≤ arr[i] ≤ 10000`


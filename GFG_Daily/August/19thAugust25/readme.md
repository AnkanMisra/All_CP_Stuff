
# Problem: **Farthest Smaller Right**

## Problem Description
You are given an integer array `arr[]`.
For every index `i` (**0-based**), you must find the **farthest index** `j` to its right (`j > i`) such that `arr[j] < arr[i]`.
If no such index exists, output `-1` for that position.
Return the resulting array of answers.

## Input Format
- **First line:** an integer `n` — the size of the array.
- **Second line:** `n` space-separated integers representing the array `arr[]`.

## Output Format
- Print `n` space-separated integers where the `i`-th value is the required farthest index for `arr[i]`; print `-1` if none exists.

## Examples

### Input

`5`
`2 5 1 3 2`<br/>

### Output

`2 4 -1 4 -1`<br/>

---

### Input

`5`
`2 3 5 4 1`<br/>

### Output

`4 4 4 4 -1`<br/>

## Constraints
- **1 ≤ n ≤ 10^6**
- **1 ≤ arr[i] ≤ 10^6**

## Notes
An efficient algorithm is required because the array can be as large as `10^6`.


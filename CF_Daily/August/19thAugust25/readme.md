# Constructing the Array

## Problem Description
You are given an array `a` of length `n` initially filled with zeros.
You will perform **n actions**; during the `i`-th action:

1. Choose the longest contiguous subarray that consists only of zeros.
   If there are several, choose the **leftmost** one.
2. Let the chosen segment be `[l; r]`.
   * If its length `r − l + 1` is **odd**, set
     `a[(l + r) / 2] = i`.
   * Otherwise (length is **even**), set
     `a[(l + r − 1) / 2] = i`.

After performing all actions the array becomes fully filled with the numbers `1 … n`.
The resulting array is **unique**.

Your task is to output this final array for each test case.

## Input Format
- The first line contains an integer **t** — the number of test cases.
- Each of the next **t** lines contains one integer **n** — the length of the array.

## Output Format
For every test case output `n` integers — the final state of the array after all actions.

## Examples

### Input

```
6
1
2
3
4
5
6
```
a
### Output

1
1 2
2 1 3
3 1 2 4
2 4 1 3 5
3 4 1 5 2 6

## Constraints
- `1 ≤ t ≤ 10^4`
- `1 ≤ n ≤ 2·10^5`
- Sum of `n` over all test cases does not exceed `2·10^5`.

## Notes
The sample demonstrates how the array evolves for `n = 5`:
`[0,0,0,0,0] → [0,0,1,0,0] → [2,0,1,0,0] → [2,0,1,3,0] → [2,4,1,3,0] → [2,4,1,3,5]`.



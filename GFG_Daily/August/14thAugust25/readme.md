
# Problem: Count Reverse Pairs

## Problem Description
You are given an array `arr[]` of **positive integers**, find the **count of reverse pairs**. A pair of indices `(i, j)` is said to be a **reverse pair** if both the following conditions are met:
- `0 ≤ i < j < arr.size()`
- `arr[i] > 2 * arr[j]`

## Input Format
An array `arr[]` of positive integers.

## Output Format
Return the **count of reverse pairs** in the array.

## Examples

### Input

`arr[] = [3, 2, 4, 5, 1, 20]`

### Output

`3`

**Explanation:**
The Reverse pairs are:
- `(0, 4)`, `arr[0] = 3`, `arr[4] = 1`, `3 > 2*1`
- `(2, 4)`, `arr[2] = 4`, `arr[4] = 1`, `4 > 2*1`
- `(3, 4)`, `arr[3] = 5`, `arr[4] = 1`, `5 > 2*1`

### Input

`arr[] = [5, 4, 3, 2, 2]`

### Output

`2`

**Explanation:**
The Reverse pairs are:
- `(0, 3)`, `arr[0] = 5`, `arr[3] = 2`, `5 > 2*2`
- `(0, 4)`, `arr[0] = 5`, `arr[4] = 2`, `5 > 2*2`

## Constraints
- `1 ≤ arr.size() ≤ 5*10^4`
- `1 ≤ arr[i] ≤ 10^9`


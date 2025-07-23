

# Problem: Sum of Subarrays

## Problem Description
Given an array `arr[]`, find the **sum of all the subarrays** of the given array.

**Note:** It is guaranteed that the total sum will fit within a 32-bit integer range.

## Input Format
- **The first line contains** the array `arr[]` of integers.

## Output Format
- **Print the sum of all subarrays** of the given array.

## Examples

### Input
`arr[] = [1, 2, 3]`<br/>

### Output
`20`<br/>

**Explanation:** All subarray sums are: `[1] = 1`, `[2] = 2`, `[3] = 3`, `[1, 2] = 3`, `[2, 3] = 5`, `[1, 2, 3] = 6`. Thus total sum is `1 + 2 + 3 + 3 + 5 + 6 = 20`.

### Input
`arr[] = [1, 3]`<br/>

### Output
`8`<br/>

**Explanation:** All subarray sums are: `[1] = 1`, `[3] = 3`, `[1, 3] = 4`. Thus total sum is `1 + 3 + 4 = 8`.

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `0 ≤ arr[i] ≤ 10^4`




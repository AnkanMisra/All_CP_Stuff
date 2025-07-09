
# Problem: Sum of Subarray Minimum

## Problem Description
Given an array `arr[]` of positive integers, find the **total sum of the minimum elements of every possible subarray**.

- It is guaranteed that the total sum will fit within a **32-bit unsigned integer**.

## Input Format
- **A single array** `arr[]` of positive integers.
- **1 ≤ arr.size() ≤ 3*10^4**
- **1 ≤ arr[i] ≤ 10^3**

## Output Format
- **A single integer** representing the sum of the minimum elements of all possible subarrays.

## Examples

### Input
`arr[] = [3, 1, 2, 4]`<br/>

### Output
`17`<br/>

**Explanation:**
Subarrays are `[3]`, `[1]`, `[2]`, `[4]`, `[3, 1]`, `[1, 2]`, `[2, 4]`, `[3, 1, 2]`, `[1, 2, 4]`, `[3, 1, 2, 4]`. Minimums are `3, 1, 2, 4, 1, 1, 2, 1, 1, 1`. Sum of all these is `17`.

### Input
`arr[] = [71, 55, 82, 55]`<br/>

### Output
`593`<br/>

**Explanation:**
The sum of the minimum of all the subarrays is `593`.

## Constraints
- `1 ≤ arr.size() ≤ 3*10^4`
- `1 ≤ arr[i] ≤ 10^3`

## Notes
- The sum will always fit within a 32-bit unsigned integer.


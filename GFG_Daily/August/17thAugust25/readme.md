
# Problem: Sort by Absolute Difference

## Problem Description
You are given a number **x** and array **arr[]**. Your task is to **rearrange** the elements of the array according to the **absolute difference** with x, i.e., an element having **minimum difference** comes first, and so on.

## Input Format
- A number `x`
- An array `arr[]` of integers

## Output Format
Rearranged array where elements are sorted by their **absolute difference** with `x`

## Examples

### Example 1
**Input:** `x = 7, arr[] = [10, 5, 3, 9, 2]`<br/>

**Output:** `[5, 9, 10, 3, 2]`<br/>

**Explanation:** Sorting the numbers according to the absolute difference with 7, we have array elements as 5, 9, 10, 3, 2.

### Example 2
**Input:** `x = 6, arr[] = [1, 2, 3, 4, 5]`<br/>

**Output:** `[5, 4, 3, 2, 1]`<br/>

**Explanation:** Sorting the numbers according to the absolute difference with 6, we have array elements as 5, 4, 3, 2, 1.

## Constraints
- **1 ≤ x ≤ 10^5**
- **1 ≤ arr.size() ≤ 10^5**
- **1 ≤ arr[i] ≤ 10^5**

## Notes
**Important:** If two or more elements are at **equal distances** arrange them in the **same sequence** as in the given array.


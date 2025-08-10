
# Problem: Median of 2 Sorted Arrays of Different Sizes

## Problem Description
Given two sorted arrays `a[]` and `b[]`, find and return the **median of the combined array** after **merging them into a single sorted array**.

## Input Format
Two sorted arrays `a[]` and `b[]` of different or same sizes.

## Output Format
Return the median of the merged array as a double value.

## Examples

### Input
`a[] = [3, 5, 6, 12, 15], b[] = [3, 4, 6, 10, 10, 12]`<br/>

### Output
`6`<br/>
**Explanation:** The merged array is `[3, 3, 4, 5, 6, 6, 10, 10, 12, 12, 15]`. So the median of the merged array is `6`.

### Input
`a[] = [2, 3, 5, 8], b[] = [10, 12, 14, 16, 18, 20]`<br/>

### Output
`11`<br/>
**Explanation:** The merged array is `[2, 3, 5, 8, 10, 12, 14, 16, 18, 20]`. So the median of the merged array is `(10 + 12) / 2 = 11`.

### Input
`a[] = [], b[] = [2, 4, 5, 6]`<br/>

### Output
`4.5`<br/>
**Explanation:** The merged array is `[2, 4, 5, 6]`. So the median of the merged array is `(4 + 5) / 2 = 4.5`.

## Constraints
- **1 ≤ a.size(), b.size() ≤ 10^6**
- **1 ≤ a[i], b[i] ≤ 10^9**
- **a.size() + b.size() > 0**

## Notes
- **Difficulty:** Hard
- **Accuracy:** 28.4%
- **Average Time:** 35m
- The arrays are already sorted in ascending order
- Handle edge cases where one array might be empty


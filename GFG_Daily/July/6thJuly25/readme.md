# Problem: Maximum Sum Combination

## Problem Description
You are given two integer arrays `a[]` and `b[]` of **equal size**. A **sum combination** is formed by adding one element from `a[]` and one from `b[]`, using each index pair `(i, j)` at most once. Your task is to **return the top `k` maximum sum combinations**, sorted in non-increasing order.

## Input Format
- Two integer arrays: `a[]` and `b[]`, each of size `n`.
- An integer `k` representing the number of maximum sum combinations to return.

## Output Format
- An array of `k` integers representing the top `k` maximum sum combinations, sorted in non-increasing order.

## Examples

### Input
`a[] = [3, 2], b[] = [1, 4], k = 2`<br/>

### Output
`[7, 6]`<br/>

### Input
`a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3`<br/>

### Output
`[10, 9, 9]`<br/>

## Constraints
- **1 ≤ a.size() = b.size() ≤ 10^5**
- **1 ≤ k ≤ a.size()**
- **1 ≤ a[i], b[i] ≤ 10^4**

## Notes
- Each index pair `(i, j)` can be used at most once in the combinations.
- The output must be sorted in non-increasing order.



# Problem: Maximum sum of elements not part of LIS

## Problem Description
Given an array `arr[]` of positive integers, your task is to find the **maximum possible sum of all elements that are not part of the Longest Increasing Subsequence (LIS)**.

## Input Format
- **The first line contains an integer** `n` **— the size of the array**.
- **The second line contains** `n` **space-separated positive integers representing the array** `arr[]`.

## Output Format
- **Print a single integer — the maximum possible sum of all elements that are not part of the LIS**.

## Examples

### Input
`arr[] = [4, 6, 1, 2, 3, 8]`<br/>

### Output
`10`<br/>

**Explanation:** The elements which are not in LIS are `4` and `6`.

### Input
`arr[] = [5, 4, 3, 2, 1]`<br/>

### Output
`14`<br/>

**Explanation:** The elements which are not in LIS are `5`, `4`, `3`, and `2`.

## Constraints
- **1 ≤ arr.size() ≤ 103**
- **1 ≤ arr[i] ≤ 105**


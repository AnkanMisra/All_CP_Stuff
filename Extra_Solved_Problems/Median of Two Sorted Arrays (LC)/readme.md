# Problem: Median of Two Sorted Arrays

## Problem Description

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the **median** of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

## Input Format

- Two sorted integer arrays `nums1` and `nums2`.

## Output Format

- A floating-point number representing the median of the two sorted arrays.

## Examples

### Example 1

**Input:**  
nums1 = [1,3], nums2 = [2]

**Output:**  
2.00000

**Explanation:**  
Merged array = [1,2,3] and median is 2.

### Example 2

**Input:**  
nums1 = [1,2], nums2 = [3,4]

**Output:**  
2.50000

**Explanation:**  
Merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

## Constraints

- nums1.length == m
- nums2.length == n
- 0 <= m <= 1000
- 0 <= n <= 1000
- 1 <= m + n <= 2000
- -10^6 <= nums1[i], nums2[i] <= 10^6

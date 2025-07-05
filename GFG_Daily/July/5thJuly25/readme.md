# Max Score from Subarray Mins

## Problem Description
Given an array `arr[]` of integers, your task is to **find the maximum sum of the smallest and second smallest elements across all subarrays (of size >= 2)** of the given array.

## Input Format
- The first line contains an integer `n`, the size of the array.
- The second line contains `n` space-separated integers representing the elements of `arr[]`.

## Output Format
- Print a single integer: **the maximum sum of the smallest and second smallest elements among all subarrays of size at least 2**.

## Constraints
- **2 ≤ n ≤ 10^5**
- **1 ≤ arr[i] ≤ 10^6**

## Examples

**Input:** `arr[] = [4, 3, 5, 1]`<br/>
**Output:** `8`<br/>
**Explanation:**
All subarrays with at least 2 elements and their two smallest numbers:
[4, 3] → 3 + 4 = 7<br/>
[4, 3, 5] → 3 + 4 = 7<br/>
[4, 3, 5, 1] → 1 + 3 = 4<br/>
[3, 5] → 3 + 5 = 8<br/>
[3, 5, 1] → 1 + 3 = 4<br/>
[5, 1] → 1 + 5 = 6<br/>
Maximum Score is **8**.

**Input:** `arr[] = [1, 2, 3]`<br/>
**Output:** `5`<br/>
**Explanation:**
All subarrays with at least 2 elements and their two smallest numbers:
[1, 2] → 1 + 2 = 3<br/>
[1, 2, 3] → 1 + 2 = 3<br/>
[2, 3] → 2 + 3 = 5<br/>
Maximum Score is **5**.

# Smallest Range in K Lists

---

## Problem Statement

Given a 2D integer array `arr[][]` of size `k * n`, where each row is sorted in ascending order, your task is to find the smallest range `[l, r]` that includes at least one element from each of the `k` lists. If more than one such range is found, return the first one.

---

## Examples

### Example 1

**Input:**  
n = 5, k = 3,  
arr = [[4, 7, 9, 12, 15],  
   [0, 8, 10, 14, 20],  
   [6, 12, 16, 30, 50]]

**Output:**  
[6, 8]

**Explanation:**  
Smallest range is formed by number 7 from the first list, 8 from the second list, and 6 from the third list.

---

### Example 2

**Input:**  
n = 5, k = 3,  
arr = [[1, 3, 5, 7, 9],  
   [0, 2, 4, 6, 8],  
   [2, 3, 5, 7, 11]]

**Output:**  
[1, 2]

**Explanation:**  
Smallest range is formed by number 1 present in the first list and 2 present in both the second and third lists.

---

### Example 3

**Input:**  
n = 2, k = 3,  
arr = [[2, 4],  
   [1, 7],  
   [20, 40]]

**Output:**  
[4, 20]

**Explanation:**  
Smallest range is formed by number 4 from the first list, 7 from the second list, and 20 from the third list.

---

## Constraints

- 1 ≤ k, n ≤ 500
- 0 ≤ arr[i] ≤ 10^5

---

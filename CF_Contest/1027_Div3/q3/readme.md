# Problem C. Need More Arrays

## Problem Statement

You are given a sorted ***array a*** of ***n integers*** in non-decreasing order. You can remove any number of elements (including zero) without changing the order of the remaining elements.

After removals, the following process occurs on the remaining array:

- The first element ***a1*** is written to a new array.
- For each subsequent element ***ai*** (where i > 1):
  - If ***ai-1 + 1 < ai***, then ***ai*** starts a **new** array.
  - Otherwise, ***ai*** is added to the **same** array as ***ai-1***.

Your task is to remove elements such that this process creates the **maximum number of arrays** possible.

If you remove all elements, no arrays are created.

---

## Input Format

- First line: Integer ***t*** — number of test cases (1 ≤ t ≤ 10,000).
- For each test case:
  - First line: Integer ***n*** — length of the array (1 ≤ n ≤ 200,000).
  - Second line: ***n*** integers ***a1, a2, ..., an*** (1 ≤ ai ≤ 1,000,000), sorted non-decreasingly (ai ≤ ai+1).

The sum of ***n*** over all test cases does not exceed 200,000.

---

## Output Format

For each test case, output a single integer — the maximum number of arrays that can be formed after removals.

---

## Example

### Input
```
6
6
1 2 3 4 5 6
3
1 2 3
4
1 2 2 4
1
2
3
1 4 8
2
1 1
```

### Output
```
3
2
2
1
3
1
```

---

## Explanation of the Example

- In the first test case, removing elements ***a3*** and ***a5*** yields the array [1, 2, 4, 6], which forms arrays: [1, 2], [4], and [6], i.e., 3 arrays.
- In the second test case, removing ***a2*** results in [1, 3], forming arrays [1] and [3].
- In the third test case, no removal is needed; the arrays formed are [1, 2, 2] and [4].

---

## Constraints & Notes

- The array is sorted in non-decreasing order.
- Removal of elements cannot change the order of remaining elements.
- Goal: maximize the count of arrays formed by the described grouping process.
- Removing all elements results in zero arrays.

---

## Problem Insights

- Arrays form when the difference between consecutive elements is more than 1.
- Removing elements can increase these gaps, thus increasing the number of arrays.
- The problem asks for the maximum number of such arrays possible after optimal removals.

---

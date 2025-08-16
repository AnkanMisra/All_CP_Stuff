
# Problem: Form the Largest Number

## Problem Description
Given an array of integers `arr[]` representing **non-negative integers**, arrange them so that after **concatenating all of them in order**, it results in the **largest possible number**. Since the result may be very large, return it as a **string**.

## Input Format
An array of integers `arr[]` representing non-negative integers.

## Output Format
A string representing the largest possible number formed by concatenating the array elements.

## Examples

### Example 1
**Input:** `arr[] = [3, 30, 34, 5, 9]`<br/>

**Output:** `9534330`<br/>

**Explanation:** Given numbers are `[3, 30, 34, 5, 9]`, the arrangement `[9, 5, 34, 3, 30]` gives the largest value.

### Example 2
**Input:** `arr[] = [54, 546, 548, 60]`<br/>

**Output:** `6054854654`<br/>

**Explanation:** Given numbers are `[54, 546, 548, 60]`, the arrangement `[60, 548, 546, 54]` gives the largest value.

### Example 3
**Input:** `arr[] = [3, 4, 6, 5, 9]`<br/>

**Output:** `96543`<br/>

**Explanation:** Given numbers are `[3, 4, 6, 5, 9]`, the arrangement `[9, 6, 5, 4, 3]` gives the largest value.

## Constraints
- **1 ≤ arr.size() ≤ 10^5**
- **0 ≤ arr[i] ≤ 10^5**


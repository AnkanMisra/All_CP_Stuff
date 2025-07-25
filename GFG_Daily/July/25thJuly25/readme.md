

# Problem: Max Circular Subarray Sum

## Problem Description
You are given a **circular array** `arr[]` of integers. Find the **maximum possible sum of a non-empty subarray**. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the **maximum non-empty subarray sum**, considering both non-wrapping and wrapping cases.

## Input Format
- **Input:** `arr[]` — an array of integers representing the circular array

## Output Format
- **Output:** The **maximum sum** of a non-empty subarray (considering circular wrapping)

## Examples

**Input:** `arr[] = [8, -8, 9, -9, 10, -11, 12]`<br/>
**Output:** `22`<br/>
**Explanation:** Starting from the last element (`12`) and moving in a circular fashion, the maximum subarray is `12, 8, -8, 9, -9, 10`, which gives a sum of `22`.

**Input:** `arr[] = [10, -3, -4, 7, 6, 5, -4, -1]`<br/>
**Output:** `23`<br/>
**Explanation:** The maximum sum of the circular subarray is `23`. The subarray is `[7, 6, 5, -4, -1, 10]`.

**Input:** `arr[] = [5, -2, 3, 4]`<br/>
**Output:** `12`<br/>
**Explanation:** The circular subarray `[3, 4, 5]` gives the maximum sum of `12`.

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `-10^4 ≤ arr[i] ≤ 10^4`


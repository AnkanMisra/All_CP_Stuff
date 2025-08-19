# Number of Zero-Filled Subarrays

## Problem Description
Given an **integer array** `nums`, return the **total number of contiguous subarrays** that are **filled entirely with `0`**.
A subarray is a contiguous, non-empty sequence of elements within an array.

## Input Format
- A single line containing the integer array `nums` of length `n`.

## Output Format
- A single integer – the number of zero-filled subarrays in `nums`.

## Examples

### Example 1
**Input:**
<br/>`nums = [1, 3, 0, 0, 2, 0, 0, 4]`

**Output:**
<br/>`6`

**Explanation:**
There are **4** occurrences of `[0]` and **2** occurrences of `[0, 0]`. No larger zero-only subarrays exist, so the total is `4 + 2 = 6`.

### Example 2
**Input:**
<br/>`nums = [0, 0, 0, 2, 0, 0]`

**Output:**
<br/>`9`

**Explanation:**
Occurrences are: **5** of `[0]`, **3** of `[0, 0]`, and **1** of `[0, 0, 0]`. Total `5 + 3 + 1 = 9`.

### Example 3
**Input:**
<br/>`nums = [2, 10, 2019]`

**Output:**
<br/>`0`

**Explanation:**
There is no contiguous subarray filled with `0`, so the answer is `0`.

## Constraints
- **1 ≤ n ≤ 100 000**
- **−1 000 000 000 ≤ nums[i] ≤ 1 000 000 000**

## Notes
Consider each maximal block of consecutive `0`s of length `k`.
Such a block contributes `k × (k + 1) / 2` zero-filled subarrays to the answer.



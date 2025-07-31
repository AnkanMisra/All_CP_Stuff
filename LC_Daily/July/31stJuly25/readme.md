
# Problem: 898. Bitwise ORs of Subarrays

## Problem Description
Given an integer array `arr`, return **the number of distinct bitwise ORs** of all the non-empty subarrays of `arr`.

The **bitwise OR of a subarray** is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A **subarray** is a contiguous non-empty sequence of elements within an array.

## Input Format
- An integer array `arr`

## Output Format
- An integer representing **the number of distinct bitwise ORs** of all non-empty subarrays

## Examples

### Example 1
**Input:** `arr = [0]`<br/>

**Output:** `1`<br/>

**Explanation:** There is only one possible result: `0`.

### Example 2
**Input:** `arr = [1,1,2]`<br/>

**Output:** `3`<br/>

**Explanation:** The possible subarrays are `[1]`, `[1]`, `[2]`, `[1, 1]`, `[1, 2]`, `[1, 1, 2]`. These yield the results `1`, `1`, `2`, `1`, `3`, `3`. There are **3 unique values**, so the answer is `3`.

### Example 3
**Input:** `arr = [1,2,4]`<br/>

**Output:** `6`<br/>

**Explanation:** The possible results are `1`, `2`, `3`, `4`, `6`, and `7`.

## Constraints
- **1 <= arr.length <= 5 * 10^4**
- **0 <= arr[i] <= 10^9**


# Problem: Subarrays With At Most K Distinct Integers

## Problem Description
You are given an array `arr[]` of positive integers and an integer `k`. Your task is to **find the number of subarrays** in `arr[]` where the **count of distinct integers is at most k**.

**Note:** A subarray is a **contiguous part of an array**.

## Input Format
- An array `arr[]` of positive integers
- An integer `k` representing the maximum number of distinct elements allowed

## Output Format
- An integer representing the **number of subarrays** with at most `k` distinct elements

## Examples

### Example 1
**Input:** `arr[] = [1, 2, 2, 3], k = 2`<br/>
**Output:** `9`<br/>
**Explanation:** Subarrays with at most 2 distinct elements are: `[1]`, `[2]`, `[2]`, `[3]`, `[1, 2]`, `[2, 2]`, `[2, 3]`, `[1, 2, 2]` and `[2, 2, 3]`.

### Example 2
**Input:** `arr[] = [1, 1, 1], k = 1`<br/>
**Output:** `6`<br/>
**Explanation:** Subarrays with at most 1 distinct element are: `[1]`, `[1]`, `[1]`, `[1, 1]`, `[1, 1]` and `[1, 1, 1]`.

### Example 3
**Input:** `arr[] = [1, 2, 1, 1, 3, 3, 4, 2, 1], k = 2`<br/>
**Output:** `24`<br/>
**Explanation:** There are **24 subarrays** with at most 2 distinct elements.

## Constraints
- **Array size:** `1 ≤ arr.size() ≤ 2*10^4`
- **Parameter k:** `1 ≤ k ≤ 2*10^4`
- **Array elements:** `1 ≤ arr[i] ≤ 10^9`

## Notes
- The problem asks for subarrays with **at most k** distinct integers, not exactly k distinct integers
- All subarrays must be **contiguous** parts of the original array
- Each individual element forms a subarray with 1 distinct element
- The solution requires counting all valid subarrays, not just finding them


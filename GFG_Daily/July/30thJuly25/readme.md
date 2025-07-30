
# Problem: Subarrays with sum K

## Problem Description
Given an **unsorted array** `arr[]` of integers, find the **number of subarrays** whose **sum exactly equal** to a given number `k`.

## Input Format
- An array `arr[]` of integers
- An integer `k` representing the target sum

## Output Format
Return the **number of subarrays** that have sum exactly equal to `k`.

## Examples

### Example 1
**Input:** `arr[] = [10, 2, -2, -20, 10], k = -10`<br/>

**Output:** `3`<br/>

**Explanation:** Subarrays `arr[0...3]`, `arr[1...4]`, `arr[3...4]` have sum exactly equal to `-10`.

### Example 2
**Input:** `arr[] = [9, 4, 20, 3, 10, 5], k = 33`<br/>

**Output:** `2`<br/>

**Explanation:** Subarrays `arr[0...2]`, `arr[2...4]` have sum exactly equal to `33`.

### Example 3
**Input:** `arr[] = [1, 3, 5], k = 0`<br/>

**Output:** `0`<br/>

**Explanation:** No subarray with `0` sum.

## Constraints
- **Array size:** `1 ≤ arr.size() ≤ 10^5`
- **Array elements:** `-10^3 ≤ arr[i] ≤ 10^3`
- **Target sum:** `-10^5 ≤ k ≤ 10^5`

## Notes
- A subarray is a **contiguous sequence** of elements within an array
- The solution should efficiently handle both **positive and negative** numbers in the array
- **Empty subarrays** are not considered


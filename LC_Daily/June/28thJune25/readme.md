# Find Subsequence of Length K With the Largest Sum

## Problem Description

You are given an integer array `nums` and an integer `k`. The goal is to find a subsequence of `nums` of length `k` such that the sum of its elements is maximized. You need to return any such subsequence as an integer array of length `k`.

A subsequence is formed by deleting zero or more elements from the original array without changing the order of the remaining elements.

## Examples

### Example 1:

**Input:** `nums = [2, 1, 3, 3], k = 2`

**Output:** `[3, 3]`

**Explanation:** The subsequence `[3, 3]` has the largest sum of 3 + 3 = 6.

### Example 2:

**Input:** `nums = [-1, -2, 3, 4], k = 3`

**Output:** `[-1, 3, 4]`

**Explanation:** The subsequence `[-1, 3, 4]` has the largest sum of -1 + 3 + 4 = 6.

### Example 3:

**Input:** `nums = [3, 4, 3, 3], k = 2`

**Output:** `[3, 4]`

**Explanation:** The subsequence `[3, 4]` has the largest sum of 3 + 4 = 7. Another valid subsequence with the same sum is `[4, 3]`.

## Constraints

-   `1 <= nums.length <= 1000`
-   `-10^5 <= nums[i] <= 10^5`
-   `1 <= k <= nums.length`

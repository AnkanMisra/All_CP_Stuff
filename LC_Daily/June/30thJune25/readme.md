# Problem: 594. Longest Harmonious Subsequence

## Problem Description
We define a **harmonious array** as an array where the **difference between its maximum value and its minimum value is exactly 1**.

Given an integer array `nums`, return the **length of its longest harmonious subsequence** among all its possible subsequences.

## Input Format
- An integer array `nums`

## Output Format
- An integer representing the **length of the longest harmonious subsequence**

## Examples

### Example 1
**Input:** `nums = [1,3,2,2,5,2,3,7]`

**Output:** `5`

**Explanation:** The longest harmonious subsequence is `[3,2,2,2,3]`.

### Example 2
**Input:** `nums = [1,2,3,4]`

**Output:** `2`

**Explanation:** The longest harmonious subsequences are `[1,2]`, `[2,3]`, and `[3,4]`, all of which have a **length of 2**.

### Example 3
**Input:** `nums = [1,1,1,1]`

**Output:** `0`

**Explanation:** **No harmonic subsequence exists**.

## Constraints
- `1 <= nums.length <= 2 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

## Notes
A harmonious subsequence must contain elements where the **maximum and minimum values differ by exactly 1**. If no such subsequence exists, return `0`.


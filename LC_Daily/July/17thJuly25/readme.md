
# Problem: Find the Maximum Length of Valid Subsequence II

## Problem Description
Given an integer array `nums` and a positive integer `k`, your task is to find the **length of the longest valid subsequence** of `nums`.

A subsequence `sub` of `nums` with length `x` is called **valid** if it satisfies:
- `(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k`.

In other words, the sum of every two consecutive elements in the subsequence, taken modulo `k`, must be the same for the entire subsequence.

## Input Format
- An integer array `nums` of length `n` (`2 <= n <= 1000`).
- An integer `k` (`1 <= k <= 1000`).

## Output Format
- An integer representing the **length of the longest valid subsequence** of `nums`.

## Examples

### Input

`nums = [1, 2, 3, 4, 5], k = 2`<br/>

### Output

`5`<br/>

**Explanation:**
The longest valid subsequence is `[1, 2, 3, 4, 5]`.

### Input

`nums = [1, 4, 2, 3, 1, 4], k = 3`<br/>

### Output

`4`<br/>

**Explanation:**
The longest valid subsequence is `[1, 4, 1, 4]`.

## Constraints
- `2 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^7`
- `1 <= k <= 1000`


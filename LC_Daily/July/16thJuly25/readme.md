
# Problem: Find the Maximum Length of Valid Subsequence I

## Problem Description
You are given an integer array `nums`.

A **subsequence** of `nums` with length `x` is called **valid** if it satisfies:
- `(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2`.

Return the **length of the longest valid subsequence** of `nums`.

A **subsequence** is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

## Input Format
- An integer array `nums` of length `n`.

## Output Format
- An integer representing the **length of the longest valid subsequence**.

## Examples

### Input
`nums = [1, 2, 3, 4]`<br/>

### Output
`4`<br/>

**Explanation:**
The longest valid subsequence is `[1, 2, 3, 4]`.

### Input
`nums = [1, 2, 1, 1, 2, 1, 2]`<br/>

### Output
`6`<br/>

**Explanation:**
The longest valid subsequence is `[1, 2, 1, 2, 1, 2]`.

### Input
`nums = [1, 3]`<br/>

### Output
`2`<br/>

**Explanation:**
The longest valid subsequence is `[1, 3]`.

## Constraints
- `2 <= nums.length <= 2 * 10^5`
- `1 <= nums[i] <= 10^7`


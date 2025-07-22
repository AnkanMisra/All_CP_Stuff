
# Problem: Maximum Erasure Value

## Problem Description
You are given an array of positive integers `nums` and want to erase a subarray containing **unique elements**. The **score** you get by erasing the subarray is equal to the **sum** of its elements. Return the **maximum score** you can get by erasing exactly one subarray.

An array `b` is called a subarray of `a` if it forms a **contiguous subsequence** of `a`, that is, if it is equal to `a[l], a[l+1], ..., a[r]` for some `(l, r)`.

## Input Format
- An array of positive integers `nums`.

## Output Format
- An integer representing the **maximum score** obtainable by erasing exactly one subarray with all unique elements.

## Examples

### Input
nums = [4,2,4,5,6]
<br/>

### Output
17
<br/>

### Input
nums = [5,2,1,2,5,2,1,2,5]
<br/>

### Output
8
<br/>

## Constraints
- **1 <= nums.length <= 10^5**
- **1 <= nums[i] <= 10^4**

## Notes
- The optimal subarray in the first example is `[2,4,5,6]`.
- In the second example, the optimal subarray is `[5,2,1]` or `[1,2,5]`.


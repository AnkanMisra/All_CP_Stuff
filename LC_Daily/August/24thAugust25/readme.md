
# Problem: Longest Subarray of 1's After Deleting One Element

## Problem Description
Given a **binary array** `nums`, you should **delete one element** from it. Return the **size of the longest non-empty subarray** containing only **1's** in the resulting array. Return **0** if there is no such subarray.

## Input Format
- A binary array `nums` where each element is either `0` or `1`

## Output Format
- An integer representing the **maximum length** of a subarray containing only `1`s after deleting exactly one element

## Examples

### Example 1
**Input:** `nums = [1,1,0,1]`<br/>

**Output:** `3`<br/>

**Explanation:** After deleting the number in position 2, `[1,1,1]` contains 3 numbers with value of 1's.

### Example 2
**Input:** `nums = [0,1,1,1,0,1,1,0,1]`<br/>

**Output:** `5`<br/>

**Explanation:** After deleting the number in position 4, `[0,1,1,1,1,1,0,1]` longest subarray with value of 1's is `[1,1,1,1,1]`.

### Example 3
**Input:** `nums = [1,1,1]`<br/>

**Output:** `2`<br/>

**Explanation:** You **must delete one element**.

## Constraints
- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`


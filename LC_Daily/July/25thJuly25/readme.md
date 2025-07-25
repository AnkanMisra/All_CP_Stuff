

# Problem: Maximum Unique Subarray Sum After Deletion

## Problem Description
You are given an integer array `nums`. You are allowed to **delete any number of elements** from `nums` (but the array must not become empty). After performing deletions, select a **subarray** of `nums` such that:
- **All elements in the subarray are unique**
- The **sum of the elements in the subarray is maximized**

Return the **maximum sum** of such a subarray.

## Input Format
- An integer array `nums`

## Output Format
- An integer representing the **maximum sum** of a subarray with all unique elements after any number of deletions

## Examples

### Input
nums = [1,2,3,4,5]
<br/>

### Output
15
<br/>

### Input
nums = [1,1,0,1,1]
<br/>

### Output
1
<br/>

### Input
nums = [1,2,-1,-2,1,0,-1]
<br/>

### Output
3
<br/>

## Constraints
- **1 <= nums.length <= 100**
- **-100 <= nums[i] <= 100**

## Notes
- You may delete any number of elements, but the array must not become empty.
- The selected subarray must have all unique elements.
- The sum should be maximized.


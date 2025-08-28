
# Problem: Maximize Number of 1's

## Problem Description
Given a **binary array** `arr[]` containing only 0s and 1s and an integer `k`, you are allowed to **flip at most k 0s to 1s**. Find the **maximum number of consecutive 1's** that can be obtained in the array after performing the operation at most k times.

## Input Format
- A binary array `arr[]` containing only 0s and 1s
- An integer `k` representing the maximum number of 0s that can be flipped

## Output Format
Return an integer representing the **maximum number of consecutive 1's** that can be obtained.

## Examples

### Example 1
**Input:** `arr[] = [1, 0, 1], k = 1`<br/>

**Output:** `3`<br/>

**Explanation:** By flipping the zero at index 1, we get the longest subarray from index 0 to 2 containing all 1's.

### Example 2
**Input:** `arr[] = [1, 0, 0, 1, 0, 1, 0, 1], k = 2`<br/>

**Output:** `5`<br/>

**Explanation:** By flipping the zeroes at indices 4 and 6, we get the longest subarray from index 3 to 7 containing all 1's.

### Example 3
**Input:** `arr[] = [1, 1], k = 2`<br/>

**Output:** `2`<br/>

**Explanation:** Since the array is already having the max consecutive 1's, hence we dont need to perform any operation. Hence the answer is 2.

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `0 ≤ k ≤ arr.size()`
- `0 ≤ arr[i] ≤ 1`


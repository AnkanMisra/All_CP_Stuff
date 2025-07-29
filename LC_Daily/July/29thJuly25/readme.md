
# Problem: Smallest Subarrays With Maximum Bitwise OR

## Problem Description
You are given a **0-indexed array** `nums` of length `n`, consisting of **non-negative integers**. For each index `i` from `0` to `n - 1`, you must determine the **size of the minimum sized non-empty subarray** of `nums` starting at `i` (inclusive) that has the **maximum possible bitwise OR**.

In other words, let `B_ij` be the bitwise OR of the subarray `nums[i...j]`. You need to find the **smallest subarray starting at i**, such that bitwise OR of this subarray is equal to `max(B_ik)` where `i <= k <= n - 1`.

The **bitwise OR of an array** is the bitwise OR of all the numbers in it.

## Input Format
- A **0-indexed integer array** `nums` of length `n`
- Array consists of **non-negative integers**

## Output Format
- Return an **integer array** `answer` of size `n`
- `answer[i]` is the **length of the minimum sized subarray** starting at `i` with **maximum bitwise OR**

## Examples

### Example 1
**Input:**

`nums = [1,0,2,1,3]`<br/>

**Output:**

`[3,3,2,2,1]`<br/>

**Explanation:**
The **maximum possible bitwise OR** starting at any index is `3`.
- Starting at index `0`, the shortest subarray that yields it is `[1,0,2]`
- Starting at index `1`, the shortest subarray that yields the maximum bitwise OR is `[0,2,1]`
- Starting at index `2`, the shortest subarray that yields the maximum bitwise OR is `[2,1]`
- Starting at index `3`, the shortest subarray that yields the maximum bitwise OR is `[1,3]`
- Starting at index `4`, the shortest subarray that yields the maximum bitwise OR is `[3]`

### Example 2
**Input:**

`nums = [1,2]`<br/>

**Output:**

`[2,1]`<br/>

**Explanation:**
- Starting at index `0`, the shortest subarray that yields the maximum bitwise OR is of **length 2**
- Starting at index `1`, the shortest subarray that yields the maximum bitwise OR is of **length 1**

## Constraints
- `n == nums.length`
- **1 <= n <= 10^5**
- **0 <= nums[i] <= 10^9**

## Notes
- A **subarray** is a contiguous non-empty sequence of elements within an array
- The bitwise OR operation only **increases or stays the same** when adding more elements
- For each starting position, we need to find the **shortest subarray** that achieves the **maximum possible OR** from that position


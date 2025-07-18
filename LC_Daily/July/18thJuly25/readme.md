
# Problem: Minimum Difference in Sums After Removal of Elements

## Problem Description
You are given a **0-indexed integer array** `nums` consisting of **3 * n elements**. You are allowed to **remove any subsequence of exactly n elements** from `nums`. The remaining `2 * n` elements will be divided into two equal parts:

- The **first n elements** form the first part, with sum `sumfirst`.
- The **next n elements** form the second part, with sum `sumsecond`.

The **difference** in sums of the two parts is defined as `sumfirst - sumsecond`.

Your task is to **return the minimum possible difference** between the sums of the two parts after removing `n` elements.

## Input Format
- An integer array `nums` of length `3 * n`.

## Output Format
- An integer representing the **minimum possible value** of `sumfirst - sumsecond` after removing `n` elements as described.

## Examples

### Input
`nums = [3, 1, 2]`<br/>

### Output
`-1`<br/>

### Explanation
Here, `n = 1`. Remove 1 element and split the remaining array into two parts:
- Remove `nums[0] = 3`: Remaining `[1, 2]`, difference is `1 - 2 = -1`.
- Remove `nums[1] = 1`: Remaining `[3, 2]`, difference is `3 - 2 = 1`.
- Remove `nums[2] = 2`: Remaining `[3, 1]`, difference is `3 - 1 = 2`.
The **minimum difference** is **-1**.

### Input
`nums = [7, 9, 5, 8, 1, 3]`<br/>

### Output
`1`<br/>

### Explanation
Here, `n = 2`. Remove 2 elements and split the remaining array into two parts:
- Remove `nums[2] = 5` and `nums[3] = 8`: Remaining `[7, 9, 1, 3]`, difference is `(7 + 9) - (1 + 3) = 12`.
- Remove `nums[1] = 9` and `nums[4] = 1`: Remaining `[7, 5, 8, 3]`, difference is `(7 + 5) - (8 + 3) = 1`.
The **minimum difference** is **1**.

## Constraints
- `nums.length == 3 * n`
- `1 <= n <= 100000`
- `1 <= nums[i] <= 100000`

## Notes
- The removed elements can be **any subsequence** of size `n` (not necessarily contiguous).
- The two resulting parts after removal must each have exactly `n` elements, taken in order from the remaining array.


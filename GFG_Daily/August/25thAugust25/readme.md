
# Problem: Maximize Median After Doing K Addition Operations

## Problem Description
Given an array `arr[]` consisting of **positive integers** and an integer `k`. You are allowed to perform **at most k operations**, where in each operation, you can **increment any one element** of the array by `1`. Determine the **maximum possible median** of the array that can be achieved after performing at most `k` such operations.

## Input Format
- An array `arr[]` of positive integers
- An integer `k` representing the maximum number of operations allowed

## Output Format
Return an integer representing the **maximum possible median** after performing at most `k` operations.

## Examples

### Example 1
**Input:** `arr[] = [1, 3, 4, 5], k = 3`<br/>

**Output:** `5`<br/>

**Explanation:** We can add `+2` to the second element and `+1` to the third element to get the array `[1, 5, 5, 5]`. After sorting, the array remains `[1, 5, 5, 5]`. Since the length is even, the median is `(5 + 5) / 2 = 5`.

### Example 2
**Input:** `arr[] = [1, 3, 6, 4, 2], k = 10`<br/>

**Output:** `7`<br/>

**Explanation:** After applying operations optimally, we can transform the array to `[1, 3, 7, 7, 7]` (one possible way). Sorted array becomes `[1, 3, 7, 7, 7]`. Since the length is odd, the median is the **middle element** `7`.

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `0 ≤ arr[i], k ≤ 10^9`

## Notes
The **median** of an array is defined as:
- The **middle element** when the array (after sorting) has an **odd size**
- The **average of the two middle elements** when the array (after sorting) has an **even size**


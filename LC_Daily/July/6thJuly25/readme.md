# Finding Pairs With a Certain Sum

## Problem Description
You are given two integer arrays, **nums1** and **nums2**. You need to implement a data structure that supports the following two types of queries:

- **Add a positive integer** to an element at a given index in the array **nums2**.
- **Count the number of pairs** `(i, j)` such that `nums1[i] + nums2[j]` equals a given value (`0 <= i < nums1.length` and `0 <= j < nums2.length`).

Implement the `FindSumPairs` class with the following methods:
- `FindSumPairs(int[] nums1, int[] nums2)`: Initializes the object with two integer arrays **nums1** and **nums2**.
- `void add(int index, int val)`: Adds `val` to `nums2[index]` (i.e., apply `nums2[index] += val`).
- `int count(int tot)`: Returns the number of pairs `(i, j)` such that `nums1[i] + nums2[j] == tot`.

## Input Format
- The first input is a list of method calls for the `FindSumPairs` class.
- The second input is a list of arguments for each method call.
- For `add`, provide two integers: `index` and `val`.
- For `count`, provide one integer: `tot`.

## Output Format
- For each method call, output the result as specified:
  - For `FindSumPairs` and `add`, output `null`.
  - For `count`, output the integer result.

## Examples

### Input
["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]<br/>
[[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]<br/>

### Output
[null, 8, null, 2, 1, null, null, 11]<br/>

### Explanation
- `FindSumPairs([1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4])`<br/>
- `count(7)` returns `8`<br/>
- `add(3, 2)` (now `nums2 = [1, 4, 5, 4, 5, 4]`)<br/>
- `count(8)` returns `2`<br/>
- `count(4)` returns `1`<br/>
- `add(0, 1)` (now `nums2 = [2, 4, 5, 4, 5, 4]`)<br/>
- `add(1, 1)` (now `nums2 = [2, 5, 5, 4, 5, 4]`)<br/>
- `count(7)` returns `11`<br/>

## Constraints
- `1 <= nums1.length <= 1000`
- `1 <= nums2.length <= 10^5`
- `1 <= nums1[i] <= 10^9`
- `1 <= nums2[i] <= 10^5`
- `0 <= index < nums2.length`
- `1 <= val <= 10^5`
- `1 <= tot <= 10^9`
- At most **1000** calls are made to `add` and `count` each.

## Notes
- The `add` operation only applies to **nums2**.
- The `count` operation should be efficient even for large **nums2**.


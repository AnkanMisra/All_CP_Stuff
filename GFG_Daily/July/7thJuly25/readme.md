# Problem: Next Greater Element in Circular Array

## Problem Description
Given a **circular integer array** `arr[]`, the task is to determine the **next greater element (NGE)** for each element in the array. The **next greater element** of an element `arr[i]` is the **first element that is greater than `arr[i]` when traversing circularly**. If no such element exists, return `-1` for that position.

**Circular Property:** After reaching the last element, the search continues from the beginning until all elements have been checked once.

## Input Format
- The first line contains an integer `n`, the size of the array.
- The second line contains `n` space-separated integers representing the elements of `arr[]`.

## Output Format
- Output a single line containing `n` space-separated integers, where each value is the next greater element for the corresponding position in the array. If no such element exists, output `-1` for that position.

## Constraints
- **1 ≤ n ≤ 10^5**
- **0 ≤ arr[i] ≤ 10^6**

## Examples

**Input:** `arr[] = [1, 3, 2, 4]`<br/>
**Output:** `3 4 4 -1`<br/>
**Explanation:** The next greater element for `1` is `3`. The next greater element for `3` is `4`. The next greater element for `2` is `4`. The next greater element for `4` does not exist, so return `-1`.<br/>

**Input:** `arr[] = [0, 2, 3, 1, 1]`<br/>
**Output:** `2 3 -1 2 2`<br/>
**Explanation:** The next greater element for `0` is `2`. The next greater element for `2` is `3`. The next greater element for `3` does not exist, so return `-1`. The next greater element for `1` is `2` (from circular traversal). The next greater element for `1` is `2` (from circular traversal).<br/>

## Notes
- Focus on the **circular property** when searching for the next greater element.
- Efficient solutions are recommended due to **large constraints**.



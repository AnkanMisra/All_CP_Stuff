# Problem: Find Lucky Integer in an Array

## Problem Description
Given an array of integers `arr`, a **lucky integer** is an integer that has a frequency in the array equal to its value. Your task is to **find the largest lucky integer** in the array. If there is **no lucky integer**, return `-1`.

## Input Format
- An integer array `arr` of length `n` (**1 <= n <= 500**)
- Each element `arr[i]` (**1 <= arr[i] <= 500**)

## Output Format
- An integer representing the **largest lucky integer** in the array, or `-1` if none exists.

## Examples

### Input
`arr = [2, 2, 3, 4]`<br/>
### Output
`2`<br/>
**Explanation:** The only lucky number in the array is `2` because its frequency is `2`.

### Input
`arr = [1, 2, 2, 3, 3, 3]`<br/>
### Output
`3`<br/>
**Explanation:** `1`, `2`, and `3` are all lucky numbers, but the largest is `3`.

### Input
`arr = [2, 2, 2, 3, 3]`<br/>
### Output
`-1`<br/>
**Explanation:** There are no lucky numbers in the array.

## Constraints
- **1 <= arr.length <= 500**
- **1 <= arr[i] <= 500**

## Notes
- If there are multiple lucky integers, return the **largest** one.
- If there is **no lucky integer**, return `-1`.


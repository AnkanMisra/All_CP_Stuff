
# Problem: Majority Element - More Than n/3

## Problem Description
Given an array `arr[]` consisting of `n` integers, the task is to **find all the array elements which occurs more than floor(n/3) times**.

## Input Format
An array `arr[]` of `n` integers.

## Output Format
Return an array of majority elements that occur more than `floor(n/3)` times. **The returned array should be sorted**.

## Examples

### Input

`arr[] = [2, 2, 3, 1, 3, 2, 1, 1]`<br/>

### Output

`[1, 2]`<br/>

**Explanation:** The frequency of `1` and `2` is `3`, which is more than `floor(n/3) = floor(8/3) = 2`.

### Input

`arr[] = [-5, 3, -5]`<br/>

### Output

`[-5]`<br/>

**Explanation:** The frequency of `-5` is `2`, which is more than `floor(n/3) = floor(3/3) = 1`.

### Input

`arr[] = [3, 2, 2, 4, 1, 4]`<br/>

### Output

`[]`<br/>

**Explanation:** There is no majority element.

## Constraints
- **1 ≤ arr.size() ≤ 10^6**
- **-10^5 ≤ arr[i] ≤ 10^5**

## Notes
- Elements that appear more than `floor(n/3)` times are considered majority elements.
- The result should be returned in **sorted order**.
- If no majority elements exist, return an empty array.


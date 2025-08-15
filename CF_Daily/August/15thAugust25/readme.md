

# Zero Array

## Problem Description
You are given an array of `n` non-negative integers.
In **one operation** you may choose two **different** indices `i` and `j` such that `a_i > 0` and `a_j > 0`, then decrease both values by **1**.
Determine whether it is possible to make **all** elements equal to `0` after some (possibly zero) number of operations.

## Input Format
- The first line contains the integer **`n`** — the length of the array.
- The second line contains **`n`** integers `a_1, a_2, …, a_n` — the array elements.

## Output Format
Print **`YES`** if the array can be transformed into all zeros, otherwise print **`NO`**.

## Examples

### Example&nbsp;1
**Input:**<br/>

`4`
`1 1 2 2`

**Output:**<br/>

`YES`

### Example&nbsp;2
**Input:**<br/>

`3`
`5 1 2`

**Output:**<br/>

`NO`

## Constraints
- **`1 ≤ n ≤ 2·10^5`**
- **`0 ≤ a_i ≤ 10^9`**

## Notes
The array can be zeroed **iff** the following two conditions hold:
1. The total sum of elements is **even**.
2. The largest element is **not greater than half** of that sum.

If both conditions are satisfied, you can always pair each unit of the largest element with a unit from the rest of the array until every element becomes zero.



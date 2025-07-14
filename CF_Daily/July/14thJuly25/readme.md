
# B. Phoenix and Beauty

## Problem Description
Phoenix loves beautiful arrays. An array is called **beautiful** if all its subarrays of length `k` have the **same sum**. A subarray is any sequence of consecutive elements.

Phoenix currently has an array `a` of length `n`. He wants to insert some number of integers (possibly zero) into his array so that it becomes beautiful. The inserted integers must be between `1` and `n` (inclusive). Integers may be inserted anywhere (even before the first or after the last element), and he does **not** need to minimize the number of inserted integers.

## Input Format
- The first line contains an integer `t` — **the number of test cases** (`1 ≤ t ≤ 50`).
- For each test case:
  - The first line contains two integers `n` and `k` (`1 ≤ k ≤ n ≤ 100`).
  - The second line contains `n` space-separated integers `a_1, a_2, ..., a_n` (`1 ≤ a_i ≤ n`).

## Output Format
For each test case:
- If it is **impossible** to create a beautiful array, print `-1`.
- Otherwise, print two lines:
  - The first line should contain the length `m` of the beautiful array (`n ≤ m ≤ 10000`).
  - The second line should contain `m` space-separated integers — a beautiful array that can be obtained after inserting some (possibly zero) integers into array `a`. Each integer must be between `1` and `n` (inclusive). You may print integers that were not originally in array `a`.
- If there are multiple solutions, print any.

## Constraints
- `1 ≤ t ≤ 50`
- `1 ≤ k ≤ n ≤ 100`
- `1 ≤ a_i ≤ n`
- If it is possible to make the array beautiful, it is guaranteed that a solution exists with `m ≤ 10000`.

## Examples

### Input
`4`
`4 2`
`1 2 2 1`
`4 3`
`1 2 2 1`
`3 2`
`1 2 3`
`4 4`
`4 3 4 2`
<br/>

### Output
`5`
`1 2 1 2 1`
`4`
`1 2 2 1`
`-1`
`7`
`4 3 2 1 4 3 2`
<br/>

## Notes
- In the first test case, you can make the array beautiful by inserting the integer `1` at index 3 (between the two existing `2`s). Now, all subarrays of length `k = 2` have the same sum `3`. There are many other possible solutions.
- In the second test case, the array is already beautiful: all subarrays of length `k = 3` have the same sum `5`.
- In the third test case, it is impossible to make the array beautiful.
- In the fourth test case, the array shown is beautiful and all subarrays of length `k = 4` have the same sum `10`. Other solutions also exist.


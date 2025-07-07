# B. Minimise Sum

## Problem Description
You are given an array `a` of length `n`, where each element satisfies `0 ≤ a_i ≤ n`. You can perform **at most one operation**:
- Choose two indices `i` and `j` such that `i < j`.
- Set `a_i := a_i + a_j` and then set `a_j = 0`.

Your task is to **output the minimum possible value** of the sum:
`min(a_1) + min(a_1, a_2) + ... + min(a_1, a_2, ..., a_n)`
after performing at most one operation.

## Input Format
- The first line contains the number of test cases `t` (**1 ≤ t ≤ 10^4**).
- For each test case:
  - The first line contains an integer `n` (**2 ≤ n ≤ 2⋅10^5**) — the length of the array.
  - The second line contains `n` space-separated integers `a_1, a_2, ..., a_n` (**0 ≤ a_i ≤ n**).
- It is guaranteed that the sum of `n` over all test cases does not exceed **2⋅10^5**.

## Output Format
- For each test case, output an integer on a new line — the minimum possible value of the required sum after at most one operation.

## Examples

**Input:**
`3`<br/>
`2`<br/>
`1 2`<br/>
`3`<br/>
`1 2 3`<br/>
`4`<br/>
`3 0 2 3`<br/>

**Output:**
`2`<br/>
`2`<br/>
`3`<br/>

## Constraints
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 2⋅10^5`
- `0 ≤ a_i ≤ n`
- The sum of `n` over all test cases does not exceed `2⋅10^5`.

## Notes
- In the second test case, it is optimal to perform the operation with `i = 2` and `j = 3`.
- In the third test case, it is optimal to not perform any operations.

